package com.example.dondeQueda.services.interfaces;

import com.example.dondeQueda.dtos.FeedItemWrapperDto;
import com.example.dondeQueda.dtos.FeedResponseDto;
import com.example.dondeQueda.dtos.PostResponseDto;
import com.example.dondeQueda.models.Post;

import java.util.List;

public interface IFeedService {

    List<PostResponseDto> getMainFeedTest();

    List<FeedItemWrapperDto> getMainFeed(int limit, int offset);

    FeedResponseDto getForYouFeed(Long idUser, int limit, int offset);

}
