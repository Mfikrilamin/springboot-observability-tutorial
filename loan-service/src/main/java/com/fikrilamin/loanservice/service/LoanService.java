package com.fikrilamin.loanservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fikrilamin.loanservice.client.FraudDetectionClient;
import com.fikrilamin.loanservice.dto.LoanDto;
import com.fikrilamin.loanservice.entity.Loan;
import com.fikrilamin.loanservice.entity.LoanStatus;
import com.fikrilamin.loanservice.repository.LoanRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoanService {
    private final FraudDetectionClient fraudDetectionClient;
    private final LoanRepository loanRepository;

    public List<LoanDto> listAllLoans() {
        return loanRepository.findAll()
                .stream()
                .map(LoanDto::from)
                .toList();
    }

    public String applyLoan(LoanDto loanDto) {
        Loan loan = Loan.from(loanDto);
        LoanStatus loanStatus = fraudDetectionClient.evaluateLoan(loan.getCustomerId());
        loan.setLoanStatus(loanStatus);
        if (loanStatus.equals(LoanStatus.APPROVED)) {
            loanRepository.save(loan);
            return "Loan applied sucessfully";
        }
        return "Sorry! Your loan was not approved";
    }
}
