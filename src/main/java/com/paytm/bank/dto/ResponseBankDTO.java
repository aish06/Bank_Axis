package com.paytm.bank.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
public class ResponseBankDTO implements Serializable {
    private static final long serialVersionUID = -79951997957371743L;

    private String status;

    private BigDecimal amount;

    private String responseCode;

    private String bankTransactionId;
}
