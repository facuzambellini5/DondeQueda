package com.example.dondeQueda.controllers;

import com.example.dondeQueda.dtos.PostResponseDto;
import com.example.dondeQueda.models.Post;
import com.example.dondeQueda.services.interfaces.IFeedService;
import com.example.dondeQueda.services.interfaces.IPostService;
import jakarta.validation.constraints.Future;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FeedController {

    @Autowired
    private IFeedService feedService;


    @GetMapping("/main/feed")
    ResponseEntity<List<PostResponseDto>> getMainFeedTest(){
        return ResponseEntity.ok(feedService.getMainFeedTest());
    }

}
