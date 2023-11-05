package com.sparta.springcrud.controller;

import com.sparta.springcrud.dto.WritingRequestDto;
import com.sparta.springcrud.dto.WritingResponseDto;
import com.sparta.springcrud.service.WritingService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class WritingController {
    private final WritingService writingService;
    public WritingController(WritingService writingService) {
        this.writingService = writingService;
    }

    @PostMapping("/writing")
    public WritingResponseDto createWriting(@RequestBody WritingRequestDto writingRequestDto) {
        return writingService.createWriting(writingRequestDto);
    }
}
