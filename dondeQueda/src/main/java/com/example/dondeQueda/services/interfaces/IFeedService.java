package com.example.dondeQueda.services.interfaces;

import com.example.dondeQueda.dtos.PostResponseDto;

import java.util.List;

public interface IFeedService {

    List<PostResponseDto> getFeed();
}
