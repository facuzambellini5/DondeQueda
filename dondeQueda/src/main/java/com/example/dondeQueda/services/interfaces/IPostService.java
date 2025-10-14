package com.example.dondeQueda.services.interfaces;

import com.example.dondeQueda.dtos.PostDto;
import com.example.dondeQueda.dtos.PostResponseDto;
import com.example.dondeQueda.models.Post;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IPostService {

    void savePost(PostDto postDto, List<MultipartFile> images) throws IOException;

    List<PostResponseDto> getPosts();

    Post getPostById(Long idPost);

    PostResponseDto getPostResponseById(Long idPost);

    void editPost(Long idPost, PostDto postDto);

    void deletePostById(Long idPost);

    void addImagesToPost(Long idPost, List<MultipartFile> images) throws IOException;

    void deleteImagesFromPost(Long idPost, List<Long> imageIds);

}
