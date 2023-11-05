package com.sparta.springcrud.service;

import com.sparta.springcrud.Entity.Writing;
import com.sparta.springcrud.dto.WritingRequestDto;
import com.sparta.springcrud.dto.WritingResponseDto;
import com.sparta.springcrud.repository.WritingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
        return writingRepository.findAll().stream().map(WritingResponseDto::new).toList();
    }

    @Transactional
    public Long updateWriting(Long id, WritingRequestDto writingRequestDto) {
        Writing writing = findWriting(id);
        writing.update(writingRequestDto);
        return id;
    }

    public Long deleteWriting(Long id) {
        Writing writing = findWriting(id);
        writingRepository.delete(writing);
        return id;
    }

    private Writing findWriting(Long id) {
        return writingRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("선택한 글은 존재하지 않습니다.")
        );
    }
}