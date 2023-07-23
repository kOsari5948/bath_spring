package com.manbath.bath.DTO;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class InfoPostDTO {
	int cap;
	int h_valve;
	int c_valve;
	int clean_valve;
	float temp;
	int level;
	int fan;
	int heat;
	int state;
	String bath_id;
}
