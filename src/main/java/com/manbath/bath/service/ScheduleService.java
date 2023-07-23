package com.manbath.bath.service;

import java.util.List;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manbath.bath.entitiy.History;
import com.manbath.bath.entitiy.Schedule;
import com.manbath.bath.DTO.ControlPostDTO;
import com.manbath.bath.DTO.HistroyGetDTO;
import com.manbath.bath.DTO.ScheduleDTO;
import com.manbath.bath.entitiy.Control;
import com.manbath.bath.repository.BathRepository;
import com.manbath.bath.repository.ControlRepository;
import com.manbath.bath.repository.HistoryRepository;
import com.manbath.bath.repository.ScheduleRepository;
import com.manbath.bath.repository.UserRepository;

import jakarta.persistence.TypedQuery;


@Log4j2
@Service
public class ScheduleService {
	
	@Autowired
	private ScheduleRepository scheduleRepository;
	
	@Autowired
	private BathRepository bathRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private SchedulerServiceImpl schedulerServiceImpl;
	
	@Transactional
	public Schedule saveByBathid(String id, ScheduleDTO scheduleDTO) {
		log.info("Schedule saveBathid");
		scheduleDTO.setBath_id(id);
		
		Schedule sc = new Schedule();

		sc.setBathid(bathRepository.findByBathid(scheduleDTO.getBath_id()));
		sc.setUserid(userRepository.findByUserid(scheduleDTO.getUser_id()));
		sc.setTemp(scheduleDTO.getTemp());
		sc.setLevel(scheduleDTO.getLevel());
		sc.setCleantime(scheduleDTO.getClean_time());
		sc.setStarttime(scheduleDTO.getBath_start());

		Schedule schedule = scheduleRepository.save(sc);
		
		//동적 스케쥴 처리
		schedulerServiceImpl.startScheduler(scheduleDTO,schedule);
		
		return schedule;
	}

	@Transactional(readOnly = true)
	public List<Schedule> findByBathid(String id){
		log.info("Schedule findByBathid");
		return scheduleRepository.findByBathid(bathRepository.findByBathid(id));
	}

	public String scheduleFindByUserId(String id){
		return schedulerServiceImpl.keyFind(id);
	}

	public ThreadPoolTaskScheduler deleteScheduleByUserId(String id) {
		return schedulerServiceImpl.stopScheduler(id);
	}
}
