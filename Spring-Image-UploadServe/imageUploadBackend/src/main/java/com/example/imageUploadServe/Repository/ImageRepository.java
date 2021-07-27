package com.example.imageUploadServe.Repository;

import com.example.imageUploadServe.Model.ImageModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ImageRepository  extends JpaRepository<ImageModel,Long> {
    Optional<ImageModel> findByName(String name);
}
