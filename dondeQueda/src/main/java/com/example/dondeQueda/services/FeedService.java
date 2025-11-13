package com.example.dondeQueda.services;

import com.example.dondeQueda.dtos.FeedItemWrapperDto;
import com.example.dondeQueda.dtos.FeedResponseDto;
import com.example.dondeQueda.dtos.PostResponseDto;
import com.example.dondeQueda.models.Commerce;
import com.example.dondeQueda.models.Event;
import com.example.dondeQueda.models.Post;
import com.example.dondeQueda.models.User;
import com.example.dondeQueda.repositories.IEventRepository;
import com.example.dondeQueda.repositories.IPostRepository;
import com.example.dondeQueda.repositories.IUserRepository;
import com.example.dondeQueda.services.interfaces.IFeedService;
import com.example.dondeQueda.utils.ValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class FeedService implements IFeedService {

    @Autowired
    private IPostRepository postRepo;
    @Autowired
    private IEventRepository eventRepo;
    @Autowired
    private IUserRepository userRepo;


    @Override
    public List<FeedItemWrapperDto> getMainFeed(int page, int size) {

        if(size != 20) {
            size = 20;
        }

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime since = now.minusDays(60);

        List<Post> posts = postRepo.findRecentPosts(since);

        List<Event> events = eventRepo.findActiveAndUpcomingEvents(now);

        List<FeedItemWrapperDto> feedItems = new ArrayList<>();

        for(Post post : posts){
            FeedItemWrapperDto feedItem = new FeedItemWrapperDto(post);
            feedItem.setRelevanceScore(this.calculatePostScore(post, now));

            feedItems.add(feedItem);
        }

        for(Event event : events){
            FeedItemWrapperDto feedItem = new FeedItemWrapperDto(event);
            feedItem.setRelevanceScore(this.calculateEventScore(event, now));
            feedItems.add(feedItem);
        }

        // Ordenar por relevancia (MAYOR A MENOR)
        feedItems.sort((a, b) -> Double.compare(b.getRelevanceScore(), a.getRelevanceScore()));


        int start = page * size;
        int end = Math.min((start + size), feedItems.size());

        if(start >= feedItems.size()){
            return new ArrayList<>();
        }

        return feedItems.subList(start, end);
    }

    @Override
    public List<FeedItemWrapperDto> getForYouFeed(Long idUser, int page, int size) {

        if (size != 20){
            size = 20;
        }

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime since = now.minusDays(60);

        User user = ValidationUtils.validateEntity(userRepo.findById(idUser), "Usuario", idUser);

        List<Commerce> commerces = user.getFavoriteCommerces();
        List<Long> commerceIds = new ArrayList<>();

        for (Commerce commerce : commerces){
            commerceIds.add(commerce.getIdCommerce());
        }

        List<Post> posts = postRepo.findRecentPostsByCommerces(commerceIds, since);

        List<Event> events = eventRepo.findActiveAndUpcomingEventsByCommerces(commerceIds, now);

        List<FeedItemWrapperDto> feedItems = new ArrayList<>();

        for(Post post : posts){
            FeedItemWrapperDto feedItem = new FeedItemWrapperDto(post);
            feedItem.setRelevanceScore(this.calculatePostScore(post, now));

            feedItems.add(feedItem);
        }

        for (Event event : events){
            FeedItemWrapperDto feedItem = new FeedItemWrapperDto(event);
            feedItem.setRelevanceScore(this.calculateEventScore(event, now));

            feedItems.add(feedItem);
        }

        // Ordenar por relevancia (MAYOR A MENOR)
        feedItems.sort((a,b) -> Double.compare(b.getRelevanceScore(), a.getRelevanceScore()));

        int start = page * size;
        int end = Math.min((start + size), feedItems.size());

        if (start >= feedItems.size()) {
            return new ArrayList<>();
        }

        return feedItems.subList(start, end);
    }

    private double calculatePostScore(Post post, LocalDateTime now) {

        long hoursAgo = ChronoUnit.HOURS.between(post.getPostedAt(), now);

        // Fórmula: Score disminuye con el tiempo
        // Post recién creado: ~1000 puntos
        // Post de hace 24 h: ~500 puntos
        // Post de hace 7 días: ~100 puntos

        double baseScore = 1000.0;
        double decayRate = 0.05; // Ajustable

        return baseScore * Math.exp(-decayRate * hoursAgo / 24.0);
    }

    private double calculateEventScore(Event event, LocalDateTime now) {

        long hoursUntilStart = ChronoUnit.HOURS.between(now, event.getStartDate());
        long hoursUntilEnd = ChronoUnit.HOURS.between(now, event.getEndDate());
        long hoursSinceCreation = ChronoUnit.HOURS.between(event.getCreatedAt(), now);

        // CASO 1: Evento en curso (entre startDate y endDate)
        if (hoursUntilStart <= 0 && hoursUntilEnd > 0) {
            return 1200.0; // Score muy alto - evento está ocurriendo AHORA
        }

        // CASO 2: Evento futuro cercano (dentro de 7 días)
        if (hoursUntilStart > 0 && hoursUntilStart <= 168) { // 168 horas = 7 días
            // Mientras más cercano, mayor score
            // Evento en 1 hora: ~1100 puntos
            // Evento en 7 días: ~800 puntos
            return 800.0 + (400.0 * (168 - hoursUntilStart) / 168);
        }

        // CASO 3: Evento futuro medio (7-30 días)
        if (hoursUntilStart > 168 && hoursUntilStart <= 720) { // 720 horas = 30 días
            // Score medio, aumenta ligeramente al acercarse
            return 600.0 + (200.0 * (720 - hoursUntilStart) / 720);
        }

        // CASO 4: Evento futuro lejano (más de 30 días)
        // Score basado en qué tan reciente fue creado
        double baseScore = 400.0;
        double decayRate = 0.05;
        return baseScore * Math.exp(-decayRate * hoursSinceCreation / 24.0);
    }
}

