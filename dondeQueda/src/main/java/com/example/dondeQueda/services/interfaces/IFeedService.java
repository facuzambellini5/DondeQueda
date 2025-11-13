package com.example.dondeQueda.services.interfaces;

import com.example.dondeQueda.dtos.FeedItemWrapperDto;
import com.example.dondeQueda.dtos.FeedResponseDto;
import com.example.dondeQueda.dtos.PostResponseDto;
import com.example.dondeQueda.models.Post;

import java.util.List;

public interface IFeedService {

    List<FeedItemWrapperDto> getMainFeed(int page, int size);

    List<FeedItemWrapperDto> getForYouFeed(Long idUser, int page, int size);

}
