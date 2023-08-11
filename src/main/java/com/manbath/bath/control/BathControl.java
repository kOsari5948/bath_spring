package com.manbath.bath.control;


import com.manbath.bath.entitiy.Bath;
import com.manbath.bath.entitiy.Control;
import com.manbath.bath.service.BathService;
import com.manbath.bath.service.ControlService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("/bath")
public class BathControl {

    @Autowired
    private BathService bathService;

    @GetMapping("/{id}")
    public ResponseEntity<?> bathlGet(@PathVariable String id) {
        log.info("bath get id:" + id);
        return new ResponseEntity(bathService.findByBathid(id), HttpStatus.OK);
    }

}
