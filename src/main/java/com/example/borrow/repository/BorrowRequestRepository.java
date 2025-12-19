
package com.example.borrow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.borrow.entity.BorrowRequest;
@Repository
public interface BorrowRequestRepository extends JpaRepository<BorrowRequest, Long> {
}
