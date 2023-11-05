package com.sparta.springcrud.dto;

import jakarta.persistence.Column;
import lombok.Getter;

@Getter
public class WritingRequestDto {
    private String title;
    private String author;
    private String passWord;
    private String contents;
}
