package com.sparta.springcrud.service;

import com.sparta.springcrud.Entity.Writing;
import com.sparta.springcrud.dto.WritingRequestDto;
import com.sparta.springcrud.dto.WritingResponseDto;
import com.sparta.springcrud.repository.WritingRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class WritingService {
    private final WritingRepository writingRepository;

    public WritingService(WritingRepository writingRepository) {
        this.writingRepository = writingRepository;
    }

    public WritingResponseDto createWriting(WritingRequestDto writingRequestDto) {
        Writing writing = new Writing(writingRequestDto);
        Writing saveWriting = writingRepository.save(writing);
        return new WritingResponseDto(saveWriting);
    }

    public WritingResponseDto getWriting(Long id) {
        Writing writing = findWriting(id);
        return new WritingResponseDto(writing);
    }

    public List<WritingResponseDto> getWritingList() {
        return writingRepository.findAllByOrderByModifiedAtDesc().stream().map(WritingResponseDto::new).toList();
    }

    @Transactional
    public WritingResponseDto updateWriting(Long id, WritingRequestDto writingRequestDto) {
        Writing writing = findWriting(id);
        checkPassword(writing, writingRequestDto);
        writing.update(writingRequestDto);
        return new WritingResponseDto(writing);
    }


    public Long deleteWriting(Long id, String passWord) {
        Writing writing = findWriting(id);
        checkPassword(writing,passWord);
        writingRepository.delete(writing);
        return id;
    }

    private Writing findWriting(Long id) {
        return writingRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("404, 선택한 글은 존재하지 않습니다.")
        );
    }

    private void checkPassword(Writing writing, WritingRequestDto writingRequestDto) {
        if(!Objects.equals(writing.getPassWord(), writingRequestDto.getPassWord())){
            throw new IllegalArgumentException("403, 비밀번호가 일치하지 않습니다.");
        }
    }
    private void checkPassword(Writing writing, String passWord) {
        if(!Objects.equals(writing.getPassWord(), passWord)){
            throw new IllegalArgumentException("403, 비밀번호가 일치하지 않습니다.");
        }
    }
}