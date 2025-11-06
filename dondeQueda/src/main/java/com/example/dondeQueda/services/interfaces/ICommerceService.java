package com.example.dondeQueda.services.interfaces;

import com.example.dondeQueda.dtos.CommerceDto;
import com.example.dondeQueda.dtos.CommerceResponseBySearch;
import com.example.dondeQueda.dtos.CommerceResponseDto;
import com.example.dondeQueda.models.Category;
import com.example.dondeQueda.models.Commerce;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.List;

public interface ICommerceService {

    void saveCommerce(Commerce commerce);

    CommerceResponseDto saveCommerce(CommerceDto commerceDto);

    List<CommerceResponseDto> getCommerces();

    Commerce getCommerceById(Long idCommerce);

    CommerceResponseDto getCommerceResponseById(Long idCommerce);

    List<CommerceResponseDto> getCommercesByOwner(Long idOwner);

    void editCommerce(Long idCommerce, CommerceDto commerceDto);

    void deleteCommerceById(Long idCommerce);

    void addCategoriesToCommerce(Long idCommerce, List<Long> idCategories);

    void removeCategoriesFromCommerce(Long idCommerce, List<Long> idCategories);

    List<CommerceResponseDto> getCommercesByCategories(List<Long> categoryIds);

    void addTagsToCommerce(Long idCommerce, List<String> nameTags);

    void removeTagsFromCommerce(Long idCommerce, List<Long> tagIds);

    void addGalleryImagesToCommerce(Long idCommerce, List<MultipartFile> images)throws IOException;

    void removeImagesFromCommerce(Long idCommerce, List<Long> imageIds)throws IOException;

    void setProfileImageToCommerce(Long idCommerce, MultipartFile image)throws IOException;

    void setCoverImageToCommerce(Long idCommerce, MultipartFile image)throws IOException;

    //Buscador principal de commerces
    List<CommerceResponseBySearch> searchCommercesByNameOrTag(String searchParam, int limit, int offset);
}
