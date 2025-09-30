package com.example.dondeQueda.services.interfaces;

import com.example.dondeQueda.dtos.SubscriptionDto;
import com.example.dondeQueda.models.Subscription;

import java.util.List;

public interface ISubscriptionService {

    void saveSubscription(SubscriptionDto subscriptionDto);

    List<Subscription> getSubscriptions();

    Subscription getSubscriptionById(Long idSubscription);

    void editSubscription(Long idSubscription, SubscriptionDto subscriptionDto);

    void deleteSubscriptionById(Long idSubscription);
}
