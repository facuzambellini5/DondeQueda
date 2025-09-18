package com.example.dondeQueda.services.interfaces;

import com.example.dondeQueda.dtos.ImageDto;
import com.example.dondeQueda.dtos.PostDto;
import com.example.dondeQueda.models.Event;
import com.example.dondeQueda.models.Post;

import java.util.List;

public interface IPostService {

    String savePost(PostDto postDto);

    List<Post> getPosts();

    Post getPostById(Long idPost);

    String editPost(Long idPost, PostDto postDto);

    String deletePostById(Long idPost);

    String addImagesToPost(Long idPost, List<ImageDto> imagesDto);

    String deleteImagesFromPost(Long idPost, List<Long> imageIds);

}
