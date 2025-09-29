package com.example.dondeQueda.services;

import com.example.dondeQueda.dtos.TagDto;
import com.example.dondeQueda.models.Commerce;
import com.example.dondeQueda.models.Tag;
import com.example.dondeQueda.repositories.ICommerceRepository;
import com.example.dondeQueda.repositories.ITagRepository;
import com.example.dondeQueda.services.interfaces.ICommerceService;
import com.example.dondeQueda.services.interfaces.ITagService;
import com.example.dondeQueda.utils.ValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService implements ITagService {

    @Autowired
    private ITagRepository tagRepo;

    @Autowired
    private ICommerceService commerceService;

    @Override
    public void saveTag(TagDto tagDto) {

        Tag tag = new Tag();
        Commerce commerce = commerceService.getCommerceById(tagDto.getIdCommerce());

        tag.setNameTag(tagDto.getNameTag());
        tag.getCommerces().add(commerce);
        commerce.getTags().add(tag);

        tagRepo.save(tag);
        //commereRepo.save(commerce); TODO: ver implementación de CASCADE
    }

    @Override
    public List<Tag> getTags() {
        return tagRepo.findAll();
    }

    @Override
    public Tag getTagById(Long idTag) {
        return ValidationUtils.validateEntity(tagRepo.findById(idTag),"Etiqueta", idTag);
    }

    @Override
    public void editTag(Long idTag, TagDto tagDto) {

        Tag tag = this.getTagById(idTag);
        tag.setNameTag(tagDto.getNameTag());

        tagRepo.save(tag);
    }

    @Override
    public void deleteTagById(Long idTag) {

        Tag tag = this.getTagById(idTag);
        tagRepo.delete(tag);
    }
}
