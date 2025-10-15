package com.example.dondeQueda.controllers;

import com.example.dondeQueda.dtos.PostDto;
import com.example.dondeQueda.dtos.PostResponseDto;
import com.example.dondeQueda.services.interfaces.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/publicacion")
public class PostController {

    @Autowired
    IPostService postService;

    @PostMapping("/crear")
    ResponseEntity<?> savePost(@RequestParam String description,
                               @RequestParam Long idCommerce,
                               @RequestParam(required = false) List<MultipartFile> images) throws IOException {

        PostDto postDto = new PostDto(description, idCommerce);

        postService.savePost(postDto, images);
        return ResponseEntity.status(HttpStatus.CREATED).body("Publicación creada correctamente.");
    }

    @GetMapping("/traer")
    ResponseEntity<List<PostResponseDto>> getPosts() {
        return ResponseEntity.ok(postService.getPosts());
    }

    @GetMapping("/traer/{idPost}")
    ResponseEntity<?> getPostById(Long idPost) {
        return ResponseEntity.ok(postService.getPostById(idPost));
    }

    @GetMapping("/traer/comercio/{idCommerce}")
    ResponseEntity<?> getPostsResponseByIdCommerce(@PathVariable Long idCommerce){
        return ResponseEntity.ok(postService.getPostsResponseByIdCommerce(idCommerce));
    }

    @PutMapping("/editar/{idPost}")
    ResponseEntity<?> editPost(Long idPost, PostDto postDto) {
        postService.editPost(idPost, postDto);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Publicación editada correctamente.");
    }

    @DeleteMapping("/eliminar/{idPost}")
    ResponseEntity<?> deletePostById(Long idPost) {
        postService.deletePostById(idPost);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Publicación eliminada correctamente.");
    }

    @PostMapping("/agregar/imagenes/{idPost}")
    ResponseEntity<?> addImagesToPost(@PathVariable Long idPost,
                                      @RequestParam List<MultipartFile> images) throws IOException {
        postService.addImagesToPost(idPost, images);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Imagen/es añadidas correctamente.");
    }

    @DeleteMapping("/eliminar/imagenes/{idPost}")
    ResponseEntity<?> deleteImagesFromPost(@PathVariable Long idPost,
                                           @RequestParam List<Long> imageIds) {
        postService.deleteImagesFromPost(idPost, imageIds);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Imagen/es eliminadas correctamente.");
    }

}
