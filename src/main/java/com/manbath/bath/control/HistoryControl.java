package com.manbath.bath.control;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manbath.bath.entitiy.History;
import com.manbath.bath.service.HistroyService;
import com.manbath.bath.vo.HistoryPostVo;
import com.manbath.bath.vo.HistroyGetVo;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/history")
public class HistoryControl {
	@Autowired
	private HistroyService history_service;

	@GetMapping("/{id}")
	public List<History> historyGet(@PathVariable String id, HistroyGetVo histroyVO) {
		System.out.println(histroyVO.toString());
		return history_service.findByUserid(id,histroyVO);
	}
	
	@PostMapping("/{id}")
	public int historyPost(@PathVariable String id, @RequestBody HistoryPostVo histroyVO) {
		
		System.out.print(histroyVO.toString());
		
		System.out.println(history_service.saveByBathid(id, histroyVO));
		
		return 1;
	}

}
