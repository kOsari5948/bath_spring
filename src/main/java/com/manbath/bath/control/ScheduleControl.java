package com.manbath.bath.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manbath.bath.DTO.ScheduleDTO;
import com.manbath.bath.entitiy.Schedule;
import com.manbath.bath.service.HistroyService;
import com.manbath.bath.service.ScheduleService;

@RestController
@RequestMapping("/schedule")
public class ScheduleControl {
	@Autowired
	private ScheduleService scheduleService;
	
	@PostMapping("/{id}")
	public Schedule postSchedule(@PathVariable String id,@RequestBody ScheduleDTO scheduledto){
		return scheduleService.saveByBathid(id, scheduledto);
	}
}
