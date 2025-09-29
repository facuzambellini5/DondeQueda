package com.example.dondeQueda.controllers;

import com.example.dondeQueda.dtos.SubscriptionDto;
import com.example.dondeQueda.models.Subscription;
import com.example.dondeQueda.services.interfaces.ISubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subscripcion")
public class SubscriptionController {

    @Autowired
    private ISubscriptionService subscriptionService;

    @PostMapping("/guardar")
    private ResponseEntity<?> saveSubscription(SubscriptionDto subscriptionDto){
        subscriptionService.saveSubscription(subscriptionDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Subscripción creada correctamente.");
    }

    @GetMapping("/traer")
    private ResponseEntity<List<Subscription>> getSubscriptions(){
        return ResponseEntity.ok(subscriptionService.getSubscriptions());
    }

    @GetMapping("/traer/{idSubscription}")
    private ResponseEntity<?> getSubscriptionById(@PathVariable Long idSubscription){
        return ResponseEntity.ok(subscriptionService.getSubscriptionById(idSubscription));
    }

    @PutMapping("/editar/{idSubscription}")
    private ResponseEntity<?> editSubscription(@PathVariable Long idSubscription,
                                    @RequestBody SubscriptionDto subscriptionDto){
        subscriptionService.editSubscription(idSubscription, subscriptionDto);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Subscripción editada correctamente.");
    }

    @DeleteMapping("/eliminar/{idSubscription}")
    private ResponseEntity<?> deleteSubscriptionById(@PathVariable Long idSubscription){
        subscriptionService.deleteSubscriptionById(idSubscription);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Subsrcipción eliminada correctamente.");
    }
}
