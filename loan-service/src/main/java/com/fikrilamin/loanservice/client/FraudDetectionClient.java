package com.fikrilamin.loanservice.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import com.fikrilamin.loanservice.entity.LoanStatus;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class FraudDetectionClient {
    private final RestClient restClient;

    public LoanStatus evaluateLoan(int customerId) {
        log.info("Calling Fraud Detection Service for customer id: {}", customerId);
        var response = restClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/fraud/check")
                        .queryParam("customerId", customerId)
                        .build())
                .retrieve()
                .toEntity(LoanStatus.class)
                .getBody();
        log.info("Fraud Detection Service response {}", response);
        return response;
    }
}
