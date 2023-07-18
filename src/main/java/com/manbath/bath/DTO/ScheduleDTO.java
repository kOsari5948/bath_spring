package com.manbath.bath.DTO;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.manbath.bath.entitiy.Bath;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ScheduleDTO {
	
	String user_id;
	int temp;
	String bath_id;
	int level;
	int clean_time;
	LocalDateTime bath_start;
}
