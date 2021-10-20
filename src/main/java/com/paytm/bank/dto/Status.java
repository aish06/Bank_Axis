package com.paytm.bank.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class Status implements Serializable, Logable {
    private static final long serialVersionUID = -2940746660793120840L;
    private String amount;
    private String benAccNo;
    private String benIfsc;
    private String benName;
    private String channel;
    private Properties properties;
    private String transactionType;
    private String txnReqId;
    private String remarks;
    @Override
    public String toJson() {
        StringBuilder builder = new StringBuilder();
        builder.append("{\"amount\":");
        builder.append(amount);
        builder.append(", \"benAccNo\":\"");
        builder.append(benAccNo);
        builder.append(", \"benIfsc\":\"");
        builder.append(benIfsc);
        builder.append(", \"benAccNo\":\"");
        builder.append(benAccNo);
        builder.append(", \"benName\":\"");
        builder.append(benName);
        builder.append(", \"channel\":\"");
        builder.append(channel);
        builder.append(", \"properties\":\"");
        builder.append(properties!=null ? properties.toJson() : "{}");
        builder.append(", \"transactionType\":\"");
        builder.append(transactionType);
        builder.append(", \"txnReqId\":\"");
        builder.append(txnReqId);
        builder.append(", \"remarks\":\"");
        builder.append(remarks);
        builder.append("\"}");
        return builder.toString();
    }
}