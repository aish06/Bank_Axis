package com.paytm.bank.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author aishwarysrivastava
 * @created 06/10/2021
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CallbackRequestData implements Serializable, Logable {
    private static final long serialVersionUID = -4278700520998259422L;

    private String transactionType;
    private String amount;
    private String response_code;
    private String clientRequestId;
    private String transactionRequestId;
    private String transactionDate;
    private String status;
    private CallbackRequestExtraInfo extra_info;

    @Override
    public String toJson() {
        StringBuilder builder = new StringBuilder();
        builder.append("{\"transactionType\":\"");
        builder.append(transactionType);
        builder.append("\", \"amount\":\"");
        builder.append(amount);
        builder.append("\", \"response_code\":\"");
        builder.append(response_code);
        builder.append("\", \"clientRequestId\":\"");
        builder.append(clientRequestId);
        builder.append("\", \"transactionRequestId\":\"");
        builder.append(transactionRequestId);
        builder.append("\", \"transactionDate\":\"");
        builder.append(transactionDate);
        builder.append("\", \"status\":\"");
        builder.append(status);
        builder.append("\", \"extra_info\":\"");
        builder.append(extra_info!=null ? extra_info.toJson() : "{]");
        builder.append("}");
        return builder.toString();
    }
}
