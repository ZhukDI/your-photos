package com.zhukdi.yourphotos.repository;

import com.zhukdi.yourphotos.entity.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoRepository extends JpaRepository<Photo, Long> {
}
