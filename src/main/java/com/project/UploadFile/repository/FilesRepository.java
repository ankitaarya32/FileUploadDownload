package com.project.UploadFile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.UploadFile.model.Files;

@Repository
public interface FilesRepository extends JpaRepository<Files, Long> {
 public Files getFilesByFileName(String fileName);
 
}
