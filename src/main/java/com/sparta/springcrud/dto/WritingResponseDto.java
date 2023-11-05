package com.sparta.springcrud.dto;

import com.sparta.springcrud.Entity.Writing;
import jakarta.persistence.Column;
import lombok.Getter;

@Getter
public class WritingResponseDto {
    private Long id;
    private String title;
    private String author;
    private String contents;

    public WritingResponseDto(Writing writing) {
        this.id = writing.getId();
        this.title = writing.getTitle();
        this.author = writing.getAuthor();
        this.contents = writing.getContents();
    }
}
