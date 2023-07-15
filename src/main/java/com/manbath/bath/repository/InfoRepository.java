package com.manbath.bath.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.manbath.bath.entitiy.History;

import java.awt.print.Pageable;
import java.time.LocalDateTime;


@Repository
public interface InfoRepository extends JpaRepository<History,String>{

}
