package com.paytm.bank.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author aishwarysrivastava
 * @created 30/09/2021
 */
@Data
public class StatusResponse implements Serializable, Logable {
    private static final long serialVersionUID = 9015452756081468215L;

    private String status;
    private String amount;
    private String transactionStatus;
    private String response_code;
    private String txn_id;
    private String message;
    private String errorCode;
    private String errorMessage;
    private StatusResponseExtraInfo extra_info;

    @Override
    public String toJson() {
        StringBuilder builder = new StringBuilder();
        builder.append("{\"status\":\"");
        builder.append(status);
        builder.append("\", \"amount\":\"");
        builder.append(amount);
        builder.append("\", \"transactionStatus\":\"");
        builder.append(transactionStatus);
        builder.append("\", \"response_code\":\"");
        builder.append(response_code);
        builder.append("\", \"txn_id\":\"");
        builder.append(txn_id);
        builder.append("\", \"extra_info\":");
        builder.append(extra_info!=null ? extra_info.toJson() : "{}");
        builder.append("}");
        return  builder.toString();
    }
}
