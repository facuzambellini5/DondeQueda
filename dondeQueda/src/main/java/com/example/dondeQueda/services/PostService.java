package com.example.dondeQueda.services;

import com.example.dondeQueda.dtos.ImageDto;
import com.example.dondeQueda.dtos.PostDto;
import com.example.dondeQueda.models.Commerce;
import com.example.dondeQueda.models.Image;
import com.example.dondeQueda.models.Post;
import com.example.dondeQueda.repositories.IPostRepository;
import com.example.dondeQueda.services.interfaces.ICommerceService;
import com.example.dondeQueda.services.interfaces.IPostService;
import com.example.dondeQueda.utils.ValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PostService implements IPostService {

    @Autowired
    private IPostRepository postRepo;
    @Autowired
    private ICommerceService commerceService;

    @Override
    public void savePost(PostDto postDto) {

        Post post = new Post();
        Commerce commerce = commerceService.getCommerceById(postDto.getIdCommerce());

        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setCommerce(commerce);

        commerce.getPosts().add(post);

        postRepo.save(post);
        commerceService.saveCommerce(commerce);
    }

    @Override
    public List<Post> getPosts() {
        return postRepo.findAll();
    }

    @Override
    public Post getPostById(Long idPost) {
        return ValidationUtils.validateEntity(postRepo.findById(idPost),"Publicación", idPost);
    }

    @Override
    public void editPost(Long idPost, PostDto postDto) {

        Post post = this.getPostById(idPost);

        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());

        postRepo.save(post);
    }

    @Override
    public void deletePostById(Long idPost) {

        Post post = this.getPostById(idPost);
        postRepo.delete(post);
    }

    @Override
    public void addImagesToPost(Long idPost, List<ImageDto> imagesDto) {

        //TODO: implementar lógica con Cloudinary
        Post post = this.getPostById(idPost);

        for(ImageDto imageDto : imagesDto){

            Image image = new Image();

            image.setUrl(imageDto.getUrl());
            image.setImageType(imageDto.getImageType());

            post.getImages().add(image);
            image.setPost(post);
            //imageRepo.save(image);
        }
        postRepo.save(post);
    }

    @Override
    public void deleteImagesFromPost(Long idPost, List<Long> imageIds) {

        Post post = this.getPostById(idPost);

        //TODO: implementar lógica con Cloudinary
    }
}
