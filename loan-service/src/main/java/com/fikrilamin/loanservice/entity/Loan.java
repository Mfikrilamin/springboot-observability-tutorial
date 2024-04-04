package com.fikrilamin.loanservice.entity;

import java.math.BigDecimal;

import com.fikrilamin.loanservice.dto.LoanDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Loan {
    private Long id;
    private String loanId;
    private String customerName;
    private int customerId;
    private BigDecimal amount;
    private LoanStatus loanStatus;

    public static Loan from(LoanDto loanDto) {
        if (loanDto.getLoanId() == null && loanDto.getLoanStatus() == null) {
            return Loan.builder()
                    .amount(loanDto.getAmount())
                    .customerId(loanDto.getCustomerId())
                    .customerName(loanDto.getCustomerName())
                    .build();
        }
        return Loan.builder()
                .loanId(loanDto.getLoanId())
                .amount(loanDto.getAmount())
                .customerId(loanDto.getCustomerId())
                .customerName(loanDto.getCustomerName())
                .build();
    }

}
