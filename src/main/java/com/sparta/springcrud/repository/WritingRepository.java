package com.sparta.springcrud.repository;

import com.sparta.springcrud.Entity.Writing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WritingRepository extends JpaRepository<Writing, Long> {
}
