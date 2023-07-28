package com.manbath.bath.service;


import com.manbath.bath.entitiy.Schedule;
import com.manbath.bath.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Component
public class SchedulerMap {

    @Autowired
    private ScheduleRepository scheduleRepository;

    private static final Map<String, Map<String, Schedule>> schedulerMap = new HashMap<>();

    public synchronized Map<String, Map<String, Schedule>> getSchedulerMap(){
        return schedulerMap;
    }

    public synchronized Map<String, Map<String, Schedule>> addSchedulerMap(Schedule schedule){
        System.out.println("에드 실행_맵");
        //들어온 걸로 id 찾고
        if(schedulerMap.containsKey(schedule.getUserid().getUserid())){
            System.out.println("에드 맵 있음");
            //있으면 추가
            schedulerMap.get(schedule.getUserid().getUserid()).put(schedule.getUserid().getUserid()+schedule.getTime(),schedule);
        }else {
            System.out.println("에드 실행_맵_없음");
            //없으면 만들어서 추가
            Map<String,Schedule> map = new HashMap<>();
            map.put(schedule.getUserid().getUserid()+schedule.getTime(),schedule);
            schedulerMap.put(schedule.getUserid().getUserid(), map);
        }
        return  schedulerMap;
    }

    public synchronized String deleteSchedulerMap(String key){
        //받은키 자르기
        //뒤에서 부터 자르기
        // 2018-06-17T22:46:17.348
        String key_tmp =  key.substring(0,key.length()-26);

        System.out.println("key_tmp :" + key_tmp);
        System.out.println("key : "  + key);

        try{
            Schedule schedule = schedulerMap.get(key_tmp).get(key);
            schedulerMap.get(key_tmp).remove(key);
            schedule.setDelete(1);
            scheduleRepository.save(schedule);
            return  schedule.toString();
        }catch (Exception e){
            System.out.println("에러 : "+ e.toString());
            return  "false";
        }

    }

    public synchronized Set<String> findSchedule(String key){
        //받은키 자르기
        //뒤에서 부터 자르기
        // 2018-06-17T22:46:17.348
        //받은키 자르기
        //뒤에서 부터 자르기
        // 2018-06-17T22:46:17.348

        try{
            return schedulerMap.get(key).keySet();
        }catch (Exception e){
            return new HashSet<>();
        }

    }
}
