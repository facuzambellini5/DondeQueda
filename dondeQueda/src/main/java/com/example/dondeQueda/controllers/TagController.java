package com.example.dondeQueda.controllers;

import com.example.dondeQueda.dtos.TagDto;
import com.example.dondeQueda.models.Tag;
import com.example.dondeQueda.services.interfaces.ITagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/etiqueta")
public class TagController {

    @Autowired
    private ITagService tagService;

    @PostMapping("/guardar")
    public ResponseEntity<?> saveTag(@RequestBody TagDto tagDto){
        tagService.saveTag(tagDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Etiqueta guardada correctamente.");
    }

    @GetMapping("/traer")
    public ResponseEntity<List<Tag>> getTags(){
        return ResponseEntity.ok(tagService.getTags());
    }

    @GetMapping("/traer/{idTag}")
    public ResponseEntity<?> getTagById(@PathVariable Long idTag){
        return ResponseEntity.ok(tagService.getTagById(idTag));
    }

    @PutMapping("/editar/{idTag}")
    public ResponseEntity<?> editTag(@PathVariable Long idTag,
                          @RequestBody TagDto tagDto){
        tagService.editTag(idTag, tagDto);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Etiqueta editada correctamente.");
    }

    @DeleteMapping("/eliminar/{idTag}")
    public ResponseEntity<?> deleteTagById(@PathVariable Long idTag){
        tagService.deleteTagById(idTag);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Etiqueta eliminada correctamente.");
    }
}
