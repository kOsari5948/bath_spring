package com.manbath.bath.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manbath.bath.entitiy.History;
import com.manbath.bath.entitiy.Info;
import com.manbath.bath.DTO.ControlPostDTO;
import com.manbath.bath.DTO.HistoryPostDTO;
import com.manbath.bath.DTO.HistroyGetDTO;
import com.manbath.bath.DTO.InfoPostDTO;
import com.manbath.bath.entitiy.Control;
import com.manbath.bath.repository.BathRepository;
import com.manbath.bath.repository.ControlRepository;
import com.manbath.bath.repository.InfoRepository;
import com.manbath.bath.repository.UserRepository;

import jakarta.persistence.TypedQuery;

@Service
public class InfoService {
	
	@Autowired
	private InfoRepository infoRepository;
	
	@Autowired
	private BathRepository bathRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional(readOnly = true)
	public List<Info> findByBathid(String id){
		return infoRepository.findByBathid(bathRepository.findByBathid(id));
	}
	
	@Transactional
	public Info saveByBathid (String id, InfoPostDTO infodto) {
		infodto.setBath_id(id);
		
		Info info = new Info();
		
		info.setBathid(bathRepository.findByBathid(infodto.getBath_id()));
		info.setTemp(infodto.getTemp());
		info.setLevel(infodto.getLevel());
		info.setCap(infodto.getCap());
		info.setH_valve(infodto.getH_valve());
		info.setC_valve(infodto.getC_valve());
		info.setFan(infodto.getFan());
		info.setHeat(infodto.getHeat());
		info.setClean_valve(infodto.getClean_valve());
		
		return infoRepository.save(info);
	}


}
