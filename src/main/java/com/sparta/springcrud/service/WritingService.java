package com.sparta.springcrud.service;

import com.sparta.springcrud.Entity.Writing;
import com.sparta.springcrud.dto.WritingRequestDto;
import com.sparta.springcrud.dto.WritingResponseDto;
import com.sparta.springcrud.repository.WritingRepository;
import org.springframework.stereotype.Service;

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
}