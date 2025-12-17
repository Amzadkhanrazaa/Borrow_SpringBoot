
package com.example.borrow.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.borrow.dto.BorrowRequestDto;
import com.example.borrow.exception.NotFoundException;
import com.example.borrow.service.BorrowRequestService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/borrow-requests")
public class BorrowRequestController {

    private final BorrowRequestService service;

    public BorrowRequestController(BorrowRequestService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<BorrowRequestDto> create(@Valid 
    		@RequestBody BorrowRequestDto dto) {
    	if(null == dto.getId() || dto.getId() < 0) {
    		throw new NotFoundException("ID Found" + dto.getId());
    	}
    	
        BorrowRequestDto created = service.create(dto);
        //return ResponseEntity.status(201).body(created);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }
    
    List<BorrowRequestDto> list = new ArrayList<>();
    

    @PutMapping("/{id}")
    public ResponseEntity<BorrowRequestDto> update(@PathVariable Long id, 
    		@Valid @RequestBody BorrowRequestDto dto) {
        BorrowRequestDto updated = service.update(id, dto);
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BorrowRequestDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.get(id));
    }

    @GetMapping
    public ResponseEntity<List<BorrowRequestDto>> getList() {
        return ResponseEntity.ok(service.getList());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
