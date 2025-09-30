package com.example.dondeQueda.services.interfaces;

import com.example.dondeQueda.dtos.ImageDto;
import com.example.dondeQueda.dtos.PostDto;
import com.example.dondeQueda.models.Event;
import com.example.dondeQueda.models.Post;

import java.util.List;

public interface IPostService {

    void savePost(PostDto postDto);

    List<Post> getPosts();

    Post getPostById(Long idPost);

    void editPost(Long idPost, PostDto postDto);

    void deletePostById(Long idPost);

    void addImagesToPost(Long idPost, List<ImageDto> imagesDto);

    void deleteImagesFromPost(Long idPost, List<Long> imageIds);

}
