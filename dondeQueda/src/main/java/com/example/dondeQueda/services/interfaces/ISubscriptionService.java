package com.example.dondeQueda.services.interfaces;

import com.example.dondeQueda.dtos.SubscriptionDto;
import com.example.dondeQueda.models.Subscription;

import java.util.List;

public interface ISubscriptionService {

    String saveSubscription(SubscriptionDto subscriptionDto);

    List<Subscription> getSubscriptions();

    Subscription getSubscriptionById(Long idSubscription);

    String editSubscription(Long idSubscription, SubscriptionDto subscriptionDto);

    String deleteSubscriptionById(Long idSubscription);
}
