package com.paytm.bank.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class Properties implements Serializable, Logable {

    private static final long serialVersionUID = -1591648529898591635L;
    private String payoutPriority;
    private String callbackUrl;
    private String transfer_mode;
    private String orderID;
    private String payoutBatchID;

    @Override
    public String toJson() {
        StringBuilder builder = new StringBuilder();
        builder.append("{\"payoutPriority\":");
        builder.append(payoutPriority);
        builder.append(", \"callbackUrl\":\"");
        builder.append(callbackUrl);
        builder.append(", \"transfer_mode\":\"");
        builder.append(transfer_mode);
        builder.append(", \"orderID\":\"");
        builder.append(orderID);
        builder.append(", \"payoutBatchID\":\"");
        builder.append(payoutBatchID);
        builder.append("\"}");
        return builder.toString();
    }
}