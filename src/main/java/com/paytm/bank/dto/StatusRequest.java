package com.paytm.bank.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author aishwarysrivastava
 * @created 20/09/2021
 */
@Data
public class StatusRequest implements Serializable, Logable {
    private static final long serialVersionUID = -1152543926180343210L;

    private String channel;
    private String transactionType;
    private String txnReqId;

    @Override
    public String toJson() {
        StringBuilder builder = new StringBuilder();
        builder.append("{\"channel\":\"");
        builder.append(channel);
        builder.append("\", \"transactionType\":\"");
        builder.append(transactionType);
        builder.append("\", \"txnReqId\":\"");
        builder.append(txnReqId);
        builder.append("\"}");
        return builder.toString();
    }
}
