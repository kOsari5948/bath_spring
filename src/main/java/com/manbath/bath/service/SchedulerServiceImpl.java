package com.manbath.bath.service;

import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import com.manbath.bath.DTO.ControlPostDTO;
import com.manbath.bath.DTO.ScheduleDTO;
import com.manbath.bath.entitiy.Control;
import com.manbath.bath.repository.BathRepository;
import com.manbath.bath.repository.ControlRepository;
import com.manbath.bath.repository.UserRepository;

@Component
public class SchedulerServiceImpl {
	@Autowired
	private ControlRepository controlRepository;
	
	@Autowired
	private BathRepository bathRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	private static final Map<String, ThreadPoolTaskScheduler> scheduledMap = new HashMap<>();

	private String cron = "*/2 * * * * *";
	// 4월 6일 17시 28분
	// private String cron = "* 29 17 6 4 *";

	public void startScheduler(ScheduleDTO scheduleDTO) {
		ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
		scheduler.initialize();
		
		//들어오는 값으로 시간 cron 설정
		String dateSt = "* ";
		dateSt+= scheduleDTO.getBath_start().getMinute()+" ";
		dateSt+= scheduleDTO.getBath_start().getHour()+" ";
		dateSt+= scheduleDTO.getBath_start().getDayOfMonth()+" ";
		dateSt+= scheduleDTO.getBath_start().getMonthValue()+" ";
		dateSt+= "*";
		//dateSt+=scheduleDTO.getBath_start().getYear();
		System.out.println("기본 cron 처리문 : "+ cron.toString());	
		System.out.println("스케쥴의 스케줄러 cron 처리문 : "+ dateSt.toString());		
		setCron(dateSt);
		
		// scheduler setting
		scheduler.schedule(getRunnable(scheduleDTO), getTrigger());

		// 사용자 id 와 시간 동일하면 스케쥴 에러 출력해 주자

		scheduledMap.put(scheduleDTO.getUser_id() + scheduleDTO.getBath_start(), scheduler);
	}

	public void setCron(String cron) {
		this.cron = cron;
	}

	public void stopScheduler(ScheduleDTO scheduleDTO) {
		scheduledMap.get(scheduleDTO.getUser_id() + scheduleDTO.getBath_start()).shutdown();
	}

	private Runnable getRunnable(ScheduleDTO scheduleDTO) {
		return () -> {
			System.out.println("스케쥴 출력");
			
			ControlPostDTO controlDTO = new ControlPostDTO();
			
			controlDTO.setBath_id(scheduleDTO.getBath_id());
			controlDTO.setUser_id(scheduleDTO.getUser_id());
			controlDTO.setTemp(scheduleDTO.getTemp());
			controlDTO.setLevel(scheduleDTO.getLevel());
			controlDTO.setClean(scheduleDTO.getClean_time());
			
			Control ct = new Control();
			
			ct.setBathid(bathRepository.findByBathid(controlDTO.getBath_id()));
			ct.setUserid(userRepository.findByUserid(controlDTO.getUser_id()));
			ct.setTemp(controlDTO.getTemp());
			ct.setLevel(controlDTO.getLevel());
			ct.setCap(controlDTO.getCap());
			ct.setCap(controlDTO.getCap());
			ct.setH_valve(controlDTO.getH_valve());
			ct.setC_valve(controlDTO.getC_valve());
			ct.setCleantime(controlDTO.getClean());
			
			//작업 출력
			System.out.println(controlRepository.toString());
			
			//한번만 실행 하고 종료 
			controlRepository.save(ct);
			stopScheduler(scheduleDTO);
			
			
		};
	}

	private Trigger getTrigger() {
		// cronSetting
		return new CronTrigger(cron);
	}
}
