package com.fikrilamin.frauddetectionservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fikrilamin.frauddetectionservice.entity.LoanStatus;
import com.fikrilamin.frauddetectionservice.service.FraudDetectionService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/fraud")
@RequiredArgsConstructor
public class FraudDetectionController {
    private final FraudDetectionService fraudDetectionService;

    @GetMapping("/check")
    public LoanStatus checkForFraud(@RequestParam int customerId) {
        return fraudDetectionService.checkForFraud(customerId);
    }

    @GetMapping("/test")
    public LoanStatus test() {
        return LoanStatus.APPROVED;
    }
}
