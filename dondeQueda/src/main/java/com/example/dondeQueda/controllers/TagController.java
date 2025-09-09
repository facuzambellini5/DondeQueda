package com.example.dondeQueda.controllers;

import com.example.dondeQueda.dtos.TagDto;
import com.example.dondeQueda.models.Tag;
import com.example.dondeQueda.services.interfaces.ITagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/etiqueta")
public class TagController {

    @Autowired
    private ITagService tagService;

    @PostMapping("/guardar")
    public String saveTag(@RequestBody TagDto tagDto){
        return tagService.saveTag(tagDto);
    }

    @GetMapping("/traer")
    public List<Tag> getTags(){
        return tagService.getTags();
    }

    @GetMapping("/traer/{idTag}")
    public Tag getTagById(@PathVariable Long idTag){
        return tagService.getTagById(idTag);
    }

    @PutMapping("/editar/{idTag}")
    public String editTag(@PathVariable Long idTag,
                          @RequestBody TagDto tagDto){
        return tagService.editTag(idTag, tagDto);
    }

    @DeleteMapping("/eliminar/{idTag}")
    public String deleteTagById(@PathVariable Long idTag){
        return tagService.deleteTagById(idTag);
    }
}
