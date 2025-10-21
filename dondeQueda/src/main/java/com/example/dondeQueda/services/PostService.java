package com.example.dondeQueda.services;

import com.example.dondeQueda.dtos.PostDto;
import com.example.dondeQueda.dtos.PostResponseDto;
import com.example.dondeQueda.models.Commerce;
import com.example.dondeQueda.models.Image;
import com.example.dondeQueda.models.Post;
import com.example.dondeQueda.repositories.ICommerceRepository;
import com.example.dondeQueda.repositories.IPostRepository;
import com.example.dondeQueda.services.interfaces.IPostService;
import com.example.dondeQueda.utils.ValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostService implements IPostService {

    @Autowired
    private IPostRepository postRepo;
    @Autowired
    private ICommerceRepository commerceRepo;
    @Autowired
    private ImageService imageService;

    @Override
    public void savePost(PostDto postDto, List<MultipartFile> images) throws IOException {

        //TODO VER si hacer validación de que tenga ALMENOS UNA imagen

        Post post = new Post();
        Commerce commerce = ValidationUtils.validateEntity(commerceRepo.findById(postDto.getIdCommerce()), "Comercio", postDto.getIdCommerce());

        post.setDescription(postDto.getDescription());
        post.setCommerce(commerce);

        postRepo.save(post);

        for(MultipartFile image : images){
            this.addImagesToPost(post.getIdPost(), images);
        }

        //TODO ver CASCADE
        commerce.getPosts().add(post);

        postRepo.save(post);
        commerceRepo.save(commerce);
    }

    @Override
    public List<PostResponseDto> getPosts() {

        List<Post> posts = postRepo.findAll();
        List<PostResponseDto> postResponseDtos = new ArrayList<>();

        for(Post post : posts){
            PostResponseDto postResponseDto = new PostResponseDto(post);
            postResponseDtos.add(postResponseDto);
        }

        return postResponseDtos;
    }

    @Override
    public Post getPostById(Long idPost) {
        return ValidationUtils.validateEntity(postRepo.findById(idPost),"Publicación", idPost);
    }

    @Override
    public List<PostResponseDto> getPostsResponseByIdCommerce(Long idCommerce) {

        Commerce commerce = ValidationUtils.validateEntity(commerceRepo.findById(idCommerce),"Comercio", idCommerce);
        List<Post> posts = postRepo.findByCommerce(commerce);
        List<PostResponseDto> postResponseDtos = new ArrayList<>();

        for(Post post : posts){
            PostResponseDto postResponseDto = new PostResponseDto(post);
            postResponseDtos.add(postResponseDto);
        }
        return postResponseDtos;
    }

    @Override
    public PostResponseDto getPostResponseById(Long idPost) {
        Post post = this.getPostById(idPost);
        return new PostResponseDto(post);
    }

    @Override
    public void editPost(Long idPost, PostDto postDto) {

        Post post = this.getPostById(idPost);

        if(postDto.getDescription() != null) {
            post.setDescription(postDto.getDescription());
        }

        postRepo.save(post);
    }

    @Override
    public void deletePostById(Long idPost) {

        Post post = this.getPostById(idPost);
        List<Image> postImages = post.getImages();

        for(Image image : postImages){
            imageService.deleteImage(image.getIdImage());
        }

        postRepo.delete(post);
    }

    @Override
    public void addImagesToPost(Long idPost, List<MultipartFile> images) throws IOException {
        int imageOrder = 1;

        for(MultipartFile image : images){
            imageService.uploadImageToPost(idPost, imageOrder, image);
            imageOrder += 1;
        }
    }

    @Override
    public void deleteImagesFromPost(Long idPost, List<Long> imageIds) {

        for(Long idImage : imageIds){
            imageService.deleteImage(idImage);
        }
    }
}
