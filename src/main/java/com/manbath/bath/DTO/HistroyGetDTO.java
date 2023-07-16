package com.manbath.bath.DTO;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class HistroyGetDTO {
	int start;
	int number;
	int year;
	int month;
	int day;
}
