package com.manbath.bath.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manbath.bath.entitiy.History;
import com.manbath.bath.entitiy.Control;
import com.manbath.bath.repository.BathRepository;
import com.manbath.bath.repository.ControlRepository;
import com.manbath.bath.vo.HistroyGetVo;

import jakarta.persistence.TypedQuery;

@Service
public class ControlService {
	
	@Autowired
	private ControlRepository controlRepository;
	
	@Autowired
	private BathRepository bathRepository;
	
	@Transactional(readOnly = true)
	public List<Control> findByBathid(String id){
		
		return controlRepository.findByBathid(bathRepository.findByBathid(id));
	}

}
