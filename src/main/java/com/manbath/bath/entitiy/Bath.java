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

	@Column(name = "state")
	private int state;

	@Column(name = "temp")
	private float temp;

	@Column(name = "level")
	private int level;

	@Column(name = "cap")
	private int cap;

	@Column(name = "h_valve")
	private int h_valve;

	@Column(name = "c_valve")
	private int c_valve;

	@Column(name = "clean_valve")
	private int clean_valve;
}


