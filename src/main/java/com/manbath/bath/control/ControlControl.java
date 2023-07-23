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
    public Control controlGet(@PathVariable String id) {

        log.info("control get id:" + id);
        System.out.println("loglog this");
        return controlService.findByBathid(id);
    }

    @PostMapping("/{id}")
    public Control controlPost(@PathVariable String id, @RequestBody ControlPostDTO controlDTO) {
        log.info("control Post id:" + id + " postDTO : " + controlDTO.toString());
        System.out.print(controlDTO.toString());
        return controlService.saveByBathid(id, controlDTO);
    }

}
