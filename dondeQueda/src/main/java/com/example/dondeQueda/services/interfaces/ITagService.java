package com.example.dondeQueda.services.interfaces;


import com.example.dondeQueda.dtos.TagDto;
import com.example.dondeQueda.models.Tag;

import java.util.List;

public interface ITagService {

    void saveTag(TagDto tagDto);

    List<Tag> getTags();

    Tag getTagById(Long idTag);

    void editTag(Long idTag, TagDto tagDto);

    void deleteTagById(Long idTag);

}
