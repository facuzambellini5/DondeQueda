package com.example.dondeQueda.services;

import com.example.dondeQueda.dtos.PostResponseDto;
import com.example.dondeQueda.services.interfaces.IFeedService;
import com.example.dondeQueda.services.interfaces.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedServiceService implements IFeedService {

    @Autowired
    private IPostService postService;

    @Override
    public List<PostResponseDto> getFeed() {
        return postService.getPosts();
    }
}
