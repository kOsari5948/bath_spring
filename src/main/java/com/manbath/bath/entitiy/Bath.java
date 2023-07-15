package com.manbath.bath.entitiy;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@Entity(name="bath")
@NoArgsConstructor
@AllArgsConstructor
public class Bath {
	
	@Id
    private String bathid;
    
    @CreationTimestamp
	@Column(name = "time")
	private LocalDateTime time;
}
