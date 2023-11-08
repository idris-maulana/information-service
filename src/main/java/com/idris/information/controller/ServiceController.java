package com.idris.information.controller;

import com.idris.information.common.CommonResponse;
import com.idris.information.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/services")
public class ServiceController {

    @Autowired
    ServiceService serviceService;

    @GetMapping
    public ResponseEntity<?> getAllService() {
        try {
            return ResponseEntity.ok(serviceService.getAllService());
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.ok(new CommonResponse<>(500, ex.getMessage(), null));
        }
    }
}
