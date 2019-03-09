package com.zhukdi.yourphotos.controller;

import com.zhukdi.yourphotos.entity.Photo;
import com.zhukdi.yourphotos.repository.PhotoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("photos")
public class PhotoController {
    private final PhotoRepository photoRepository;

    @Autowired
    public PhotoController(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    @GetMapping
    public List<Photo> getAll() {
        return photoRepository.findAll();
    }

    @GetMapping("{id}")
    public Photo getById(@PathVariable("id") Photo photo) {
        return photo;
    }

    @PostMapping
    public Photo add(@RequestBody Photo photo) {
        return photoRepository.save(photo);
    }

    @PutMapping("{id}")
    public Photo update(@PathVariable("id") Photo photoFromDb, @RequestBody Photo photo) {
        BeanUtils.copyProperties(photo, photoFromDb, "id");
        return photoRepository.save(photoFromDb);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Photo photo) {
        photoRepository.delete(photo);
    }
}
