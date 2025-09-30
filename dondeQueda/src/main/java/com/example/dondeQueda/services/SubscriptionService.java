package com.example.dondeQueda.services;

import com.example.dondeQueda.dtos.SubscriptionDto;
import com.example.dondeQueda.models.Subscription;
import com.example.dondeQueda.repositories.ISubscriptionRepository;
import com.example.dondeQueda.services.interfaces.ISubscriptionService;
import com.example.dondeQueda.utils.ValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionService implements ISubscriptionService {

    @Autowired
    private ISubscriptionRepository subscriptionRepo;

    @Override
    public void saveSubscription(SubscriptionDto subscriptionDto) {
        Subscription subscription = new Subscription();

        subscription.setNameSubscription(subscriptionDto.getNameSubscription());
        subscription.setPrice(subscriptionDto.getPrice());
        subscription.setDuration(subscriptionDto.getDuration());
        subscription.setDescription(subscriptionDto.getDescription());
        subscription.setMaxCommerces(subscriptionDto.getMaxCommerces());
        subscription.setMaxPosts(subscriptionDto.getMaxPosts());

        subscriptionRepo.save(subscription);
    }

    @Override
    public List<Subscription> getSubscriptions() {
        return subscriptionRepo.findAll();
    }

    @Override
    public Subscription getSubscriptionById(Long idSubscription) {
        return ValidationUtils.validateEntity(subscriptionRepo.findById(idSubscription),"Subscripción",idSubscription);
    }

    @Override
    public void editSubscription(Long idSubscription, SubscriptionDto subscriptionDto) {

        Subscription subscription = this.getSubscriptionById(idSubscription);

        subscription.setNameSubscription(subscriptionDto.getNameSubscription());
        subscription.setPrice(subscriptionDto.getPrice());
        subscription.setDuration(subscriptionDto.getDuration());
        subscription.setDescription(subscriptionDto.getDescription());
        subscription.setMaxCommerces(subscriptionDto.getMaxCommerces());
        subscription.setMaxPosts(subscriptionDto.getMaxPosts());

        subscriptionRepo.save(subscription);
    }

    @Override
    public void deleteSubscriptionById(Long idSubscription) {

        Subscription subscription = this.getSubscriptionById(idSubscription);
        subscriptionRepo.delete(subscription);
    }
}
