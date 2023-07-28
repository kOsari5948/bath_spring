package com.manbath.bath.service;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.manbath.bath.entitiy.Schedule;
import com.manbath.bath.repository.ScheduleRepository;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.manbath.bath.entitiy.Control;
import com.manbath.bath.repository.BathRepository;
import com.manbath.bath.repository.ControlRepository;
import com.manbath.bath.repository.UserRepository;

@Log4j2
@Component
public class SchedulerServiceImpl{

	private final ScheduleRepository scheduleRepository;

	private final ControlRepository controlRepository;
	

	private final BathRepository bathRepository;
	

	private final UserRepository userRepository;

	private final SchedulerMap schedulerMap;

	private ExecutorService executorService = Executors.newSingleThreadExecutor();

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());



	public SchedulerServiceImpl(ScheduleRepository scheduleRepository,ControlRepository controlRepository,BathRepository bathRepository,UserRepository userRepository,SchedulerMap schedulerMap){
		this.scheduleRepository = scheduleRepository;
		this.controlRepository = controlRepository;
		this.bathRepository = bathRepository;
		this.userRepository = userRepository;
		this.schedulerMap = schedulerMap;

		executorService.execute(()->{
			//맵을 뒤지기
			try {
				while (true){
					for( String key_1 : schedulerMap.getSchedulerMap().keySet() ){
						for(String key_2 : schedulerMap.getSchedulerMap().get(key_1).keySet()){
							System.out.println(key_2);
							if(schedulerMap.getSchedulerMap().get(key_1).get(key_2).getStarttime().isBefore(LocalDateTime.now())){

								Schedule sc =  schedulerMap.getSchedulerMap().get(key_1).get(key_2);
								Control control = new Control();

								control.setScheduleid(sc);
								control.setCleantime(sc.getCleantime());
								control.setLevel(sc.getLevel());
								control.setTemp(sc.getTemp());
								control.setBathid(sc.getBathid());

								control.setBathid(sc.getBathid());
								control.setUserid(sc.getUserid());

								controlRepository.save(control);

								schedulerMap.getSchedulerMap().get(key_1).remove(key_2);
							}
						}
					}
					Thread.sleep(1000);

				}

			}catch (InterruptedException e) {
				throw new RuntimeException(e);
			}

		});
	}

	
	public void startScheduler(Schedule schedule) {
		System.out.println("에드 실행");
		schedulerMap.addSchedulerMap(schedule);
	}



	public void allStopSchedler(){
		executorService.shutdown();
	}

	public String stopScheduler(String key) {
		System.out.println("딜리트 실행");
		return schedulerMap.deleteSchedulerMap(key);
	}

	public Set<String> findSchduler(String key) {
		System.out.println("찾기 실행");
		return schedulerMap.findSchedule(key);
	}
}
