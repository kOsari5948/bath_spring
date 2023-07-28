package com.manbath.bath.control;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.manbath.bath.DTO.ScheduleDTO;
import com.manbath.bath.entitiy.Schedule;
import com.manbath.bath.service.ScheduleService;

import java.util.List;
import java.util.Set;

@Log4j2
@RestController
@RequestMapping("/schedule")
public class ScheduleControl {
	@Autowired
	private ScheduleService scheduleService;
	
	@PostMapping("/{id}")
	public Schedule postSchedule(@PathVariable String id,@RequestBody ScheduleDTO scheduledto){
		log.info("Schedule POST id :" + id + " body" + scheduledto.toString() );
		return scheduleService.saveByBathid(id, scheduledto);
	}

	@GetMapping("/{id}")
	public List<Schedule> getSchedule(@PathVariable String id){
		log.info("Schedule GET id :" + id );
		return scheduleService.findByBathid(id);
	}

	@GetMapping("/delete/{id}")
	public String getDeleteSchedule(@PathVariable String id){
		log.info("DeleteSchedule GET id :" + id );
		return scheduleService.DeleteScheduleFindByUserId(id);
	}

	@GetMapping("/find/{id}")
	public Set<String> getfindSchedule(@PathVariable String id){
		log.info("findSchedule GET id :" + id );
		return scheduleService.findScheduleByUserId(id);
	}

}
