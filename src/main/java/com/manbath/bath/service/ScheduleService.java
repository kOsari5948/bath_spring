package com.manbath.bath.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
		scheduleDTO.setBath_id(id);
		
		Schedule sc = new Schedule();
		
		sc.setBathid(bathRepository.findByBathid(scheduleDTO.getBath_id()));
		sc.setUserid(userRepository.findByUserid(scheduleDTO.getUser_id()));
		sc.setTemp(scheduleDTO.getTemp());
		sc.setLevel(scheduleDTO.getLevel());
		sc.setCleantime(scheduleDTO.getClean_time());
		sc.setStarttime(scheduleDTO.getBath_start());
		System.out.println("시간 출력 : "+ scheduleDTO.getBath_start());
		
		
		//동적 스케쥴 처리
		schedulerServiceImpl.startScheduler(scheduleDTO);
		
		return scheduleRepository.save(sc);
	}

}
