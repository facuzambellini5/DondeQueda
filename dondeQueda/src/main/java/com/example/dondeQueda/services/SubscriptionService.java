package com.example.dondeQueda.services;

import com.example.dondeQueda.dtos.SubscriptionDto;
import com.example.dondeQueda.models.Subscription;
import com.example.dondeQueda.repositories.ISubscriptionRepository;
import com.example.dondeQueda.services.interfaces.ISubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionService implements ISubscriptionService {

    @Autowired
    private ISubscriptionRepository subscriptionRepo;
    @Autowired
    private EntityValidatorService validatorService;

    @Override
    public String saveSubscription(SubscriptionDto subscriptionDto) {
        Subscription subscription = new Subscription();

        subscription.setNameSubscription(subscriptionDto.getNameSubscription());
        subscription.setPrice(subscriptionDto.getPrice());
        subscription.setDuration(subscriptionDto.getDuration());
        subscription.setDescription(subscriptionDto.getDescription());
        subscription.setMaxCommerces(subscriptionDto.getMaxCommerces());
        subscription.setMaxPosts(subscriptionDto.getMaxPosts());

        subscriptionRepo.save(subscription);

        return "Subscripción guardada correctamente.";
    }

    @Override
    public List<Subscription> getSubscriptions() {
        return subscriptionRepo.findAll();
    }

    @Override
    public Subscription getSubscriptionById(Long idSubscription) {
        return validatorService.validateSubscription(idSubscription);
    }

    @Override
    public String editSubscription(Long idSubscription, SubscriptionDto subscriptionDto) {

        Subscription subscription = validatorService.validateSubscription(idSubscription);

        subscription.setNameSubscription(subscriptionDto.getNameSubscription());
        subscription.setPrice(subscriptionDto.getPrice());
        subscription.setDuration(subscriptionDto.getDuration());
        subscription.setDescription(subscriptionDto.getDescription());
        subscription.setMaxCommerces(subscriptionDto.getMaxCommerces());
        subscription.setMaxPosts(subscriptionDto.getMaxPosts());

        subscriptionRepo.save(subscription);

        return "Subscripción editada correctamente.";
    }

    @Override
    public String deleteSubscriptionById(Long idSubscription) {

        Subscription subscription = validatorService.validateSubscription(idSubscription);
        subscriptionRepo.delete(subscription);

        return "Subscripción eliminada correctamente.";
    }
}
