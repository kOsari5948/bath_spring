package com.manbath.bath.control;

import java.util.List;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manbath.bath.entitiy.History;
import com.manbath.bath.entitiy.Info;
import com.manbath.bath.entitiy.Control;
import com.manbath.bath.repository.ControlRepository;
import com.manbath.bath.service.ControlService;
import com.manbath.bath.service.InfoService;
import com.manbath.bath.DTO.*;

@Log4j2
@RestController
@RequestMapping("/info")
public class InfoControl {
	
	@Autowired
	private InfoService infoService;
	
	@GetMapping("/{id}")
	public Info infoGet(@PathVariable String id) {
		log.info("info GET id:" + id);
		return infoService.findByBathid(id);
	}
	
	
	
	@PostMapping("/{id}")
	public Info infoPost(@PathVariable String id, @RequestBody  InfoPostDTO infoDTO) {
		log.info("info POST id:" + id +" Body :" + infoDTO.toString());
		return infoService.saveByBathid(id, infoDTO);
	}

}
