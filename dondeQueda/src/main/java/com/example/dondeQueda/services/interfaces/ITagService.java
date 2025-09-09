package com.example.dondeQueda.services.interfaces;


import com.example.dondeQueda.dtos.TagDto;
import com.example.dondeQueda.models.Tag;

import java.util.List;

public interface ITagService {

    String saveTag(TagDto tagDto);

    List<Tag> getTags();

    Tag getTagById(Long idTag);

    String editTag(Long idTag, TagDto tagDto);

    String deleteTagById(Long idTag);

}
