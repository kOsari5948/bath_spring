package com.manbath.bath.DTO;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class HistoryPostDTO {
	private LocalDateTime start_time;
	private LocalDateTime end_time;
	private LocalDateTime bath_time;
	
	private int temp;
	private int level;
	
	private String user_id;
	private String bath_id;
}
