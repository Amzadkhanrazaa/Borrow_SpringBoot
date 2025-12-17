
package com.example.borrow.service;

import java.util.List;

import com.example.borrow.dto.BorrowRequestDto;
import com.example.borrow.entity.BorrowRequest;

public interface BorrowRequestService {
    // 5 service methods
    BorrowRequestDto create(BorrowRequestDto dto);
    BorrowRequestDto update(Long id, BorrowRequestDto dto);
    BorrowRequestDto get(Long id);
    List<BorrowRequestDto> getList();
    void delete(Long id);

    // 2 helper conversion methods
    BorrowRequestDto entityToDto(BorrowRequest entity);
    BorrowRequest dtoToEntity(BorrowRequestDto dto);
}
