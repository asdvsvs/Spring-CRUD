package com.sparta.springcrud.service;

import com.sparta.springcrud.Entity.Writing;
import com.sparta.springcrud.repository.WritingRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WritingServiceTest {

    @Autowired
    WritingRepository writingRepository;
    @Test
    void createWriting() {
        Writing writing = Writing.builder()
                .title("테스트 제목")
                .author("테스트 유저")
                .passWord("4321")
                .contents("테스트하는 내용")
                .build();
        writingRepository.save(writing);
    }

    @Test
    void getWriting() {
        Writing writing = findWriting(10L);
    }

    @Test
    void getWritingList() {
    }

    @Test
    void updateWriting() {
    }

    @Test
    void deleteWriting() {
    }

    private Writing findWriting(Long id) {
        return writingRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("404, 선택한 글은 존재하지 않습니다.")
        );
    }
}