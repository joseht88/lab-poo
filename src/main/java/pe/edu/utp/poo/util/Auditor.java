package pe.edu.utp.poo.util;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@MappedSuperclass
public class Auditor<T> {
	
	@Column(name = "created_by", nullable = false, updatable = false)
	@CreatedDate
    private T createdBy;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date", nullable = false, updatable = false)
    @CreatedDate
    private LocalDateTime createdDate;

	@Column(name = "modified_by")
	@LastModifiedDate
    private T modifiedBy;
	
	@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modified_date")
    @LastModifiedDate
    private LocalDateTime modifiedDate;
}
