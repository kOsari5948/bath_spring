package com.manbath.bath.control;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.type.descriptor.DateTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manbath.bath.DTO.HistoryPostDTO;
import com.manbath.bath.DTO.HistroyGetDTO;
import com.manbath.bath.entitiy.History;
import com.manbath.bath.service.HistroyService;

import jakarta.websocket.server.PathParam;

@Log4j2
@RestController
@RequestMapping("/history")
public class HistoryControl {
	@Autowired
	private HistroyService history_service;

	
	//사용자 기준으로 받기
	@GetMapping("/{id}")
	public ResponseEntity<?> historyGet(@PathVariable String id, HistroyGetDTO histroyDTO) {
		log.info("history get id:" + id +" Body :" + histroyDTO.toString());

		return new ResponseEntity(history_service.findByUserid(id,histroyDTO), HttpStatus.OK);
	}
	
	
	
	//사용자 기준으로 올리기
	@PostMapping("/{id}")
	public ResponseEntity<?> historyPost(@PathVariable String id, @RequestBody HistoryPostDTO histroyDTO) {
		log.info("history post id:" + id +" Body :" + histroyDTO.toString());
		return new ResponseEntity(history_service.saveByBathid(id, histroyDTO), HttpStatus.CREATED);
	}
	
}
