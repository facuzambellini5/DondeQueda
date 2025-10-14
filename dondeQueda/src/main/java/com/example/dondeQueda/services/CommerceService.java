package com.example.dondeQueda.services;

import com.example.dondeQueda.dtos.CommerceDto;
import com.example.dondeQueda.dtos.CommerceDtoResponse;
import com.example.dondeQueda.enums.UserRole;
import com.example.dondeQueda.models.*;
import com.example.dondeQueda.repositories.ICategoryRepository;
import com.example.dondeQueda.repositories.ICommerceRepository;
import com.example.dondeQueda.repositories.ITagRepository;
import com.example.dondeQueda.repositories.IUserRepository;
import com.example.dondeQueda.services.interfaces.ICommerceService;
import com.example.dondeQueda.services.interfaces.IImageService;
import com.example.dondeQueda.utils.ValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CommerceService implements ICommerceService {

  @Autowired private ICommerceRepository commerceRepo;
  @Autowired private IUserRepository userRepo;
  @Autowired private ICategoryRepository categoryRepo;
  @Autowired private ITagRepository tagRepo;
  @Autowired private IImageService imageService;

  @Override
  public void saveCommerce(Commerce commerce) {
    commerceRepo.save(commerce);
  }

  @Override
  public void saveCommerce(CommerceDto commerceDto) {

    Commerce commerce = new Commerce();

    if(commerceDto.getBranchOf() != null){
      Commerce mainCommerce = ValidationUtils.validateEntity(commerceRepo.findById(commerceDto.getBranchOf()), "Comercio principal", commerceDto.getBranchOf());

      mainCommerce.getCommerces().add(commerce);
      commerce.setBranchOf(mainCommerce);

      commerceRepo.save(mainCommerce);
    }

    User owner = ValidationUtils.validateEntity(userRepo.findById(commerceDto.getIdOwner()), "Usuario", commerceDto.getIdOwner());

    commerce.setName(commerceDto.getName());
    commerce.setDescription(commerceDto.getDescription());
    commerce.setPhone(commerceDto.getPhone());
    commerce.setLink(commerceDto.getLink());
    commerce.setEmail(commerceDto.getEmail());

    commerce.setOwner(owner);
    owner.getOwnedCommerces().add(commerce);

    owner.setRole(UserRole.OWNER);

    commerceRepo.save(commerce);
    userRepo.save(owner);
  }

  @Override
  public List<Commerce> getCommerces() {
    return commerceRepo.findAll();
  }

  @Override
  public Commerce getCommerceById(Long idCommerce) {
    return ValidationUtils.validateEntity(
        commerceRepo.findById(idCommerce), "Comercio", idCommerce);
  }

  @Override
  public List<CommerceDtoResponse> getCommercesByOwner(Long idOwner) {
    User owner = ValidationUtils.validateEntity(userRepo.findById(idOwner),"Usuario", idOwner);

    List<Commerce> commerces = commerceRepo.findByOwner(owner);
    List<CommerceDtoResponse> commerceDtoResponses = new ArrayList<>();

    for(Commerce commerce : commerces){
      CommerceDtoResponse commerceDtoResponse = new CommerceDtoResponse(commerce);
      commerceDtoResponses.add(commerceDtoResponse);
    }

    return commerceDtoResponses;
  }

  @Override
  public void editCommerce(Long idCommerce, CommerceDto commerceDto) {

    Commerce commerce = this.getCommerceById(idCommerce);

    if (commerceDto.getName() != null) {
      commerce.setName(commerceDto.getName());
    }

    if (commerceDto.getDescription() != null) {
      commerce.setDescription(commerceDto.getDescription());
    }

    if (commerceDto.getPhone() != null) {
      commerce.setPhone(commerceDto.getPhone());
    }

    if (commerceDto.getLink() != null) {
      commerce.setLink(commerceDto.getLink());
    }

    if (commerceDto.getEmail() != null) {
      commerce.setEmail(commerceDto.getEmail());
    }
    commerceRepo.save(commerce);
  }

  @Override
  public void deleteCommerceById(Long idCommerce) {
    Commerce commerce = this.getCommerceById(idCommerce);
    commerceRepo.delete(commerce);
  }

  @Override
  public void addCategoriesToCommerce(Long idCommerce, List<Long> idCategories) {

    Commerce commerce = this.getCommerceById(idCommerce);

    for (Long idCategory : idCategories) {
      Category category =
          ValidationUtils.validateEntity(
              categoryRepo.findById(idCategory), "Categoría", idCategory);
      commerce.getCategories().add(category);
    }
    commerceRepo.save(commerce);
  }

  @Override
  public void removeCategoriesFromCommerce(Long idCommerce, List<Long> idCategories) {

    Commerce commerce = this.getCommerceById(idCommerce);

    for (Long idCategory : idCategories) {
      Category category =
          ValidationUtils.validateEntity(
              categoryRepo.findById(idCategory), "Categoría", idCategory);
      commerce.getCategories().remove(category);
    }
    commerceRepo.save(commerce);
  }

  @Override
  public void addTagsToCommerce(Long idCommerce, List<String> nameTags) {

    Commerce commerce = this.getCommerceById(idCommerce);

    for (String nameTag : nameTags) {

      Optional<Tag> tagOptional = tagRepo.findByNameTag(nameTag);

      if (tagOptional.isEmpty()) {
        Tag tag = new Tag();
        tag.setNameTag(nameTag);

        tag.getCommerces().add(commerce); // TODO ver implementacion CASCADE
        commerce.getTags().add(tag);

        commerceRepo.save(commerce);
        tagRepo.save(tag);
      }

      if(tagOptional.isPresent()){
          Tag tag = tagOptional.get();

          tag.getCommerces().add(commerce); //TODO ver implementacion CASCADE
          commerce.getTags().add(tag);

          commerceRepo.save(commerce);
          tagRepo.save(tag);
      }
    }
  }

  @Override
  public void removeTagsFromCommerce(Long idCommerce, List<Long> tagIds) {

      Commerce commerce = this.getCommerceById(idCommerce);

      for(Long idTag : tagIds){

          Tag tag = ValidationUtils.validateEntity(tagRepo.findById(idTag), "Etiqueta", idTag);

          if(tag != null){
              tag.getCommerces().remove(commerce);
              commerce.getTags().remove(tag);

              tagRepo.save(tag);
              commerceRepo.save(commerce);
          }
      }
  }

  @Override
  public void addGalleryImagesToCommerce(Long idCommerce, List<MultipartFile> images) throws IOException {

    int imageOrder = 1;

    for(MultipartFile image : images){
      imageService.uploadGalleryImageToCommerce(idCommerce, imageOrder, image);
      imageOrder += 1;
    }
  }

  public void removeImagesFromCommerce(Long idCommerce, List<Long> imageIds) {
    for (Long idImage : imageIds){
      imageService.deleteImage(idImage);
    }
  }

  @Override
  public void setProfileImageToCommerce(Long idCommerce, MultipartFile image) throws IOException{
    imageService.setProfileImageToCommerce(idCommerce, image);
  }

  @Override
  public void setCoverImageToCommerce(Long idCommerce, MultipartFile image) throws IOException{
    imageService.setCoverImageToCommerce(idCommerce, image);
  }

  @Override
  public List<Commerce> getCommercesByCategories(List<Category> categories) {
    // TODO implementar metodo
    return List.of();
  }
}
