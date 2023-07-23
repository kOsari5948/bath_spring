package com.manbath.bath.control;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.web.bind.annotation.*;

import com.manbath.bath.DTO.ScheduleDTO;
import com.manbath.bath.entitiy.Schedule;
import com.manbath.bath.service.HistroyService;
import com.manbath.bath.service.ScheduleService;

import java.util.List;

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
		return scheduleService.scheduleFindByUserId(id);
	}

	@PostMapping("/delete/{id}")
	public ThreadPoolTaskScheduler postDeleteSchedule(@PathVariable String id){
		log.info("DeleteSchedule POST id :" + id);
		return scheduleService.deleteScheduleByUserId(id);
	}
}
