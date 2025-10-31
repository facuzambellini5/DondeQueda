package com.example.dondeQueda.services;

import com.example.dondeQueda.dtos.FeedResponseDto;
import com.example.dondeQueda.dtos.PostResponseDto;
import com.example.dondeQueda.repositories.IEventRepository;
import com.example.dondeQueda.repositories.IPostRepository;
import com.example.dondeQueda.repositories.IUserRepository;
import com.example.dondeQueda.services.interfaces.IFeedService;
import com.example.dondeQueda.services.interfaces.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FeedService implements IFeedService {

    @Autowired
    private IPostRepository postRepo;
    private IEventRepository eventRepo;
    private IUserRepository userRepo;


    @Override
    public FeedResponseDto getMainFeed(int limit, int offset) {
        return null;
    }

    @Override
    public FeedResponseDto getForYouFeed(int limit, int offset) {
        return null;
    }
}
