package com.idris.information.controller;

import com.idris.information.common.CommonResponse;
import com.idris.information.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/banner")
public class BannerController {

    @Autowired
    BannerService bannerService;

    @GetMapping
    public ResponseEntity<?> getAllBanner() {
        try {
            return ResponseEntity.ok(bannerService.getAllBanner());
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.ok(new CommonResponse<>(500, ex.getMessage(), null));
        }
    }
}
