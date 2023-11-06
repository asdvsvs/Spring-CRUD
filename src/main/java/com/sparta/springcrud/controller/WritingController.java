package com.sparta.springcrud.controller;

import com.sparta.springcrud.dto.WritingRequestDto;
import com.sparta.springcrud.dto.WritingResponseDto;
import com.sparta.springcrud.service.WritingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/writing")
    public WritingResponseDto getWriting(Long id){
        return writingService.getWriting(id);
    }

    @GetMapping("/writings")
    public List<WritingResponseDto> getWritingList() {
        return writingService.getWritingList();
    }

    @PutMapping("/writing")
    public WritingResponseDto updateWriting(Long id, @RequestBody WritingRequestDto writingRequestDto) {
        return writingService.updateWriting(id,writingRequestDto);
    }

    @DeleteMapping("/writing")
    public Long deleteWriting(Long id,String passWord) {
        return writingService.deleteWriting(id,passWord);
    }
}
