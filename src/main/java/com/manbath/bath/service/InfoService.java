package com.manbath.bath.service;

import java.util.List;

import com.manbath.bath.entitiy.Bath;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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

@Log4j2
@Service
public class InfoService {
	
	@Autowired
	private InfoRepository infoRepository;
	
	@Autowired
	private BathRepository bathRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional(readOnly = true)
	public Info findByBathid(String id){
		log.info("info findByBathid id :" + id );


		try {
			return infoRepository.findByBathid(bathRepository.findByBathid(id), Sort.by(Sort.Direction.DESC, "infoid")).get(0);
		}catch (IndexOutOfBoundsException e){
			return new Info();
		}

	}
	
	@Transactional
	public Info saveByBathid (String id, InfoPostDTO infodto) {
		log.info("info saveByBathid id :" + id );
		infodto.setBath_id(id);
		
		Info info = new Info();

		Bath bath = bathRepository.findByBathid(infodto.getBath_id());
		
		info.setBathid(bath);
		info.setTemp(infodto.getTemp());
		info.setLevel(infodto.getLevel());
		info.setCap(infodto.getCap());
		info.setH_valve(infodto.getH_valve());
		info.setC_valve(infodto.getC_valve());
		info.setFan(infodto.getFan());
		info.setHeat(infodto.getHeat());
		info.setClean_valve(infodto.getClean_valve());
		info.setState(infodto.getState());

		bath.setTemp(infodto.getTemp());
		bath.setLevel(infodto.getLevel());
		bath.setState(infodto.getState());
		bath.setCap(infodto.getCap());
		bath.setC_valve(infodto.getC_valve());
		bath.setH_valve(infodto.getH_valve());
		bath.setClean_valve(infodto.getClean_valve());

		bathRepository.save(bath);

		return infoRepository.save(info);
	}


}
