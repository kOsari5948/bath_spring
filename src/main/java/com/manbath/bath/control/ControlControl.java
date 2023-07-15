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
import com.manbath.bath.entitiy.Control;
import com.manbath.bath.repository.ControlRepository;
import com.manbath.bath.service.ControlService;
import com.manbath.bath.vo.HistoryPostVo;
import com.manbath.bath.vo.HistroyGetVo;

@RestController
@RequestMapping("/control")
public class ControlControl {
	
	@Autowired
	private ControlService controlService;
	
	@GetMapping("/{id}")
	public List<Control> historyGet(@PathVariable String id) {
		
		return controlService.findByBathid(id);
	}
	
//	@PostMapping("/{id}")
//	public int historyPost(@PathVariable String id, @RequestBody HistoryPostVo histroyVO) {
//		
//		System.out.print(histroyVO.toString());
//		
//		System.out.println(controlService.saveByBathid(id, histroyVO));
//		
//		return 1;
//	}

}
