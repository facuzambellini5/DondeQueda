package com.example.dondeQueda.controllers;

import com.example.dondeQueda.services.interfaces.IFeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class FeedController {

    @Autowired
    private IFeedService feedService;

    @GetMapping("/main/feed")
    public ResponseEntity<?> getMainFeed(int limit, int offset){
        return ResponseEntity.ok(feedService.getMainFeed(limit, offset));
    }

    @GetMapping("/foryou/feed")
    public ResponseEntity<?> getForYouFeed(int limit, int offset){
        return ResponseEntity.ok(feedService.getForYouFeed(limit, offset));
    }
}
