package com.manbath.bath.entitiy;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
