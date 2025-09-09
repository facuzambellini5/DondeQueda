package com.example.dondeQueda.controllers;

import com.example.dondeQueda.dtos.SubscriptionDto;
import com.example.dondeQueda.models.Subscription;
import com.example.dondeQueda.services.interfaces.ISubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subscripcion")
public class SubscriptionController {

    @Autowired
    private ISubscriptionService subscriptionService;

    @PostMapping("/guardar")
    private String saveSubscription(SubscriptionDto subscriptionDto){
        return subscriptionService.saveSubscription(subscriptionDto);
    }

    @GetMapping("/traer")
    private List<Subscription> getSubscriptions(){
        return subscriptionService.getSubscriptions();
    }

    @GetMapping("/traer/{idSubscription}")
    private Subscription getSubscriptionById(@PathVariable Long idSubscription){
        return subscriptionService.getSubscriptionById(idSubscription);
    }

    @PutMapping("/editar/{idSubscription}")
    private String editSubscription(@PathVariable Long idSubscription,
                                    @RequestBody SubscriptionDto subscriptionDto){
        return subscriptionService.editSubscription(idSubscription, subscriptionDto);
    }

    @DeleteMapping("/eliminar/{idSubscription}")
    private String deleteSubscriptionById(@PathVariable Long idSubscription){
        return subscriptionService.deleteSubscriptionById(idSubscription);
    }
}
