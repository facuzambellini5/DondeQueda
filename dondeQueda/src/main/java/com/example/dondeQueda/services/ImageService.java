package com.example.dondeQueda.services;

import com.example.dondeQueda.dtos.ImageDto;
import com.example.dondeQueda.models.Commerce;
import com.example.dondeQueda.models.Event;
import com.example.dondeQueda.models.Image;
import com.example.dondeQueda.models.Post;
import com.example.dondeQueda.repositories.IImageRepository;
import com.example.dondeQueda.services.interfaces.IImageService;
import com.example.dondeQueda.utils.ValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService implements IImageService {

    @Autowired
    private IImageRepository imageRepo;
    @Autowired
    private CommerceService commerceService;
    @Autowired
    private EventService eventService;
    @Autowired
    private PostService postService;

    @Override
    public void saveImgage(ImageDto imageDto) {

        Image image = new Image();

        image.setUrl(imageDto.getUrl());
        image.setImageType(imageDto.getImageType());

        imageRepo.save(image);
    }

    @Override
    public List<Image> getImages() {
        return imageRepo.findAll();
    }

    @Override
    public Image getImageById(Long idImage) {
        return ValidationUtils.validateEntity(imageRepo.findById(idImage),"Imagen", idImage);
    }

    @Override
    public void editImage(Long idImage, ImageDto imageDto) {

        Image image = getImageById(idImage);

        image.setUrl(imageDto.getUrl());
        image.setImageType(imageDto.getImageType());

        imageRepo.save(image);
    }

    @Override
    public void deleteImageById(Long idImage) {

        Image image = this.getImageById(idImage);
        imageRepo.delete(image);
    }

    @Override
    public List<Image> getImagesByCommerce(Long idCommerce) {

        Commerce commerce = commerceService.getCommerceById(idCommerce);
        return imageRepo.findByCommerceOrderByImageOrder(commerce);
    }

    @Override
    public List<Image> getImagesByEvent(Long idEvent) {

        Event event = eventService.getEventById(idEvent);
        return imageRepo.findByEventOrderByImageOrder(event);
    }

    @Override
    public List<Image> getImagesByPost(Long idPost) {

        Post post = postService.getPostById(idPost);
        return imageRepo.findByPostOrderByImageOrder(post);
    }


}
