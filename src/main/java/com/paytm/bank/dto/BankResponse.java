package com.paytm.bank.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class BankResponse implements Serializable, Logable {
    private static final long serialVersionUID = 6461710314469708449L;

    private String status;
    private String amount;
    private String response_code;
    private String txn_id;
    private String errorCode;
    private String errorMessage;

    @Override
    public String toJson() {
        StringBuilder builder = new StringBuilder();
        builder.append("{\"status\":\"");
        builder.append(status);
        builder.append("\", \"amount\":\"");
        builder.append(amount);
        builder.append("\", \"response_code\":\"");
        builder.append(response_code);
        builder.append("\", \"txn_id\":\"");
        builder.append(txn_id);
        builder.append("\", \"errorCode\":\"");
        builder.append(errorCode);
        builder.append("\", \"errorMessage\":\"");
        builder.append(errorMessage);
        builder.append("\"}");
        return builder.toString();
    }
}
