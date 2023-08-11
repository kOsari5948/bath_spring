package com.manbath.bath.control;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<?> postSchedule(@PathVariable String id, @RequestBody ScheduleDTO scheduledto){
		log.info("Schedule POST id :" + id + " body" + scheduledto.toString() );
		return new ResponseEntity(scheduleService.saveByBathid(id, scheduledto), HttpStatus.CREATED);
	}

	//스케쥴 검색
	@GetMapping("/{id}")
	public ResponseEntity<?> getSchedule(@PathVariable String id){
		log.info("Schedule GET id :" + id );
		return new ResponseEntity(scheduleService.findByBathid(id), HttpStatus.OK);
	}
	
	//스케줄 삭제
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> getDeleteSchedule(@PathVariable String id){
		log.info("DeleteSchedule GET id :" + id );
		return new ResponseEntity(scheduleService.DeleteScheduleId(id), HttpStatus.OK);

	}

	@GetMapping("/find/user/{id}")
	public ResponseEntity<?> getUserfindSchedule(@PathVariable String id){
		log.info("findSchedule GET id :" + id );
		return new ResponseEntity(scheduleService.findScheduleByUserId(id), HttpStatus.OK);
	}

	@GetMapping("/find/bath/{id}")
	public ResponseEntity<?> getBathfindSchedule(@PathVariable String id){
		log.info("findSchedule GET id :" + id );
		return new ResponseEntity(scheduleService.findScheduleByBathId(id), HttpStatus.OK);
	}

}
