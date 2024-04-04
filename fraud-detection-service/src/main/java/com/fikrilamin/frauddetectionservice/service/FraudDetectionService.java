package com.fikrilamin.frauddetectionservice.service;

import org.springframework.stereotype.Service;

import com.fikrilamin.frauddetectionservice.entity.LoanStatus;
import com.fikrilamin.frauddetectionservice.repository.FraudRecordRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FraudDetectionService {
    private final FraudRecordRepository fraudRecordRepository;

    public LoanStatus checkForFraud(int customerId) {
        return fraudRecordRepository.existsByCustomerId(customerId) ? LoanStatus.REJECTED : LoanStatus.APPROVED;
    }
}
