package com.manbath.bath.control;

import java.util.List;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.manbath.bath.DTO.*;

@Log4j2
@RestController
@RequestMapping("/control")
public class ControlControl {

    @Autowired
    private ControlService controlService;


    @GetMapping("/{id}")
    public ResponseEntity<?> controlGet(@PathVariable String id) {
        log.info("control get id:" + id);
        return new ResponseEntity(controlService.findByBathid(id), HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> controlPost(@PathVariable String id, @RequestBody ControlPostDTO controlDTO) {
        log.info("control Post id:" + id + " postDTO : " + controlDTO.toString());
        System.out.print(controlDTO.toString());
        return new ResponseEntity(controlService.saveByBathid(id, controlDTO), HttpStatus.CREATED);
    }

}
