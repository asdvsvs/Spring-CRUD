package com.sparta.springcrud.Entity;

import com.sparta.springcrud.dto.WritingRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Writing extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "author", nullable = false)
    private String author;
    @Column(name = "passWord", nullable = false)
    private String passWord;
    @Column(name = "contents", nullable = false, length = 500)
    private String contents;

    @Builder
    public Writing(Long id, String title, String author, String passWord, String contents) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.passWord = passWord;
        this.contents = contents;
    }

    public Writing(WritingRequestDto writingRequestDto) {
        this.title = writingRequestDto.getTitle();
        this.author = writingRequestDto.getAuthor();
        this.passWord = writingRequestDto.getPassWord();
        this.contents = writingRequestDto.getContents();
    }

    public void update(WritingRequestDto writingRequestDto) {
        this.title = writingRequestDto.getTitle();
        this.author = writingRequestDto.getAuthor();
        this.passWord = writingRequestDto.getPassWord();
        this.contents = writingRequestDto.getContents();
    }

}
