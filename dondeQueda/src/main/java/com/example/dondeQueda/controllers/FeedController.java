package com.example.dondeQueda.controllers;

import com.example.dondeQueda.dtos.PostResponseDto;
import com.example.dondeQueda.services.interfaces.IFeedService;
import com.example.dondeQueda.services.interfaces.IPostService;
import jakarta.validation.constraints.Future;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/feed")
public class FeedController {

    @Autowired
    private IFeedService feedService;

    @GetMapping
    ResponseEntity<List<PostResponseDto>> feed() {
         return ResponseEntity.ok(feedService.getFeed());
    }

}
