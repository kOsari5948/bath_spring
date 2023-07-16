package com.manbath.bath.control;

import java.util.List;

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

@RestController
@RequestMapping("/info")
public class InfoControl {
	
	@Autowired
	private InfoService infoService;
	
	@GetMapping("/{id}")
	public List<Info> historyGet(@PathVariable String id) {
		
		return infoService.findByBathid(id);
	}
	
	
	
	@PostMapping("/{id}")
	public Info historyPost(@PathVariable String id, @RequestBody  InfoPostDTO infoDTO) {
		
		System.out.print(infoDTO.toString());
		
		return infoService.saveByBathid(id, infoDTO);
	}
	
	

}
