package com.manbath.bath.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.manbath.bath.entitiy.History;
import com.manbath.bath.entitiy.Schedule;

import java.awt.print.Pageable;
import java.time.LocalDateTime;


@Repository
public interface ScheduleRepository extends JpaRepository<Schedule,String>{

}
