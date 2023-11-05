package com.sparta.springcrud.repository;

import com.sparta.springcrud.Entity.Writing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;

public interface WritingRepository extends JpaRepository<Writing, Long> {
    List<Writing> findAllByOrderByModifiedAtDesc();
}
