package com.example.dondeQueda.services.interfaces;

import com.example.dondeQueda.dtos.FeedResponseDto;
import com.example.dondeQueda.dtos.PostResponseDto;

import java.util.List;

public interface IFeedService {

    FeedResponseDto getMainFeed(int limit, int offset);

    FeedResponseDto getForYouFeed(int limit, int offset);

}
