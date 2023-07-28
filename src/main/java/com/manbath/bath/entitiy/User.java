package com.manbath.bath.entitiy;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@Entity(name="user")
@NoArgsConstructor
@AllArgsConstructor
public class User {
	@Id
    private String userid;
    
	@ManyToOne
    @JoinColumn(name = "bathid")
    private Bath bathid;
    
    @CreationTimestamp
	@Column(name = "time")
	private LocalDateTime time;
}
