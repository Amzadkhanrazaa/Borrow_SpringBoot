
package com.example.borrow.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity //entity and NOT A DTO
@Table(name = "borrow_requests")
public class BorrowRequest {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //borrow id - unique identifier - save

    //, message = "Borrower Name can not be null"
    @Column(nullable = false)
    private String borrowerName; //name

    @Column(nullable = false)
    private Long itemId; //item

    private LocalDate startDate; //start to end
    private LocalDate endDate;

	private String justification; //why borrow
    
	private String bookId; //this could be null 
    
    @Column(nullable = false)
    private String status; // PENDING, APPROVED, REJECTED 
    
    
    
    
    public String getJustification() {
		return justification;
	}

	public void setJustification(String justification) {
		this.justification = justification;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

    public BorrowRequest() {}

    public BorrowRequest(Long id, String borrowerName, Long itemId, LocalDate startDate, LocalDate endDate, String status) {
        this.id = id;
        this.borrowerName = borrowerName;
        this.itemId = itemId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getBorrowerName() { return borrowerName; }
    public void setBorrowerName(String borrowerName) { this.borrowerName = borrowerName; }
    public Long getItemId() { return itemId; }
    public void setItemId(Long itemId) { this.itemId = itemId; }
    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }
    public LocalDate getEndDate() { return endDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
