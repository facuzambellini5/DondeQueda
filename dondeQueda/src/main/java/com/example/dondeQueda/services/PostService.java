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
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class PostService implements IPostService {

    @Autowired
    private IPostRepository postRepo;
    @Autowired
    private ICommerceService commerceService;
    @Autowired
    private ImageService imageService;

    @Override
    public void savePost(PostDto postDto, List<MultipartFile> images) throws IOException {

        //TODO VER si hacer validación de que tenga ALMENOS UNA imagen

        Post post = new Post();
        Commerce commerce = commerceService.getCommerceById(postDto.getIdCommerce());

        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setCommerce(commerce);

        for(MultipartFile image : images){
            imageService.uploadImageToPost(post.getIdPost(), image);
        }

        //TODO ver CASCADE
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
        List<Image> postImages = post.getImages();

        for(Image image : postImages){
            imageService.deleteImage(image.getIdImage());
        }

        postRepo.delete(post);
    }

    @Override
    public void addImagesToPost(Long idPost, List<MultipartFile> images) throws IOException {

        Post post = this.getPostById(idPost);

        for(MultipartFile image : images){
            imageService.uploadImageToPost(idPost, image);
        }

        postRepo.save(post);
    }

    @Override
    public void deleteImagesFromPost(Long idPost, List<Long> imageIds) {

        Post post = this.getPostById(idPost);

        for(Long idImage : imageIds){
            imageService.deleteImage(idImage);
        }

        postRepo.save(post);
    }
}
