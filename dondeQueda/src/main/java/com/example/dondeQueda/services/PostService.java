package com.example.dondeQueda.services;

import com.example.dondeQueda.dtos.ImageDto;
import com.example.dondeQueda.dtos.PostDto;
import com.example.dondeQueda.models.Commerce;
import com.example.dondeQueda.models.Event;
import com.example.dondeQueda.models.Image;
import com.example.dondeQueda.models.Post;
import com.example.dondeQueda.repositories.IPostRepository;
import com.example.dondeQueda.services.interfaces.IPostService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PostService implements IPostService {

    @Autowired
    private IPostRepository postRepo;
    @Autowired
    private CommerceService commerceService;
    @Autowired
    private EntityValidatorService validatorService;

    @Override
    public String savePost(PostDto postDto) {

        Post post = new Post();
        Commerce commerce = commerceService.getCommerceById(postDto.getIdCommerce());

        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setCommerce(commerce);

        commerce.getPosts().add(post);

        postRepo.save(post);
        commerceService.saveCommerce(commerce);

        return "Publicación creada correctamente.";
    }

    @Override
    public List<Post> getPosts() {
        return postRepo.findAll();
    }

    @Override
    public Post getPostById(Long idPost) {
        return validatorService.validatePost(idPost);
    }

    @Override
    public String editPost(Long idPost, PostDto postDto) {

        Post post = validatorService.validatePost(idPost);

        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());

        postRepo.save(post);

        return "Publicación editada correctamente.";
    }

    @Override
    public String deletePostById(Long idPost) {

        Post post = validatorService.validatePost(idPost);
        postRepo.delete(post);

        return "Publicación eliminada correctamente.";
    }

    @Override
    public String addImagesToPost(Long idPost, List<ImageDto> imagesDto) {

        //TODO ver si implementar esta logica aca o en ImageService
        Post post = validatorService.validatePost(idPost);

        for(ImageDto imageDto : imagesDto){

            Image image = new Image();

            image.setUrl(imageDto.getUrl());
            image.setImageType(imageDto.getImageType());

            post.getImages().add(image);
            image.setPost(post);
            imageRepo.save(image);
        }
        postRepo.save(post);

        return "Imagen/es agregadas correctamente.";
    }

    @Override
    public String deleteImagesFromPost(Long idPost, List<Long> imageIds) {
        return "";
    }
}
