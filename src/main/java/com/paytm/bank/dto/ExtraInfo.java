package com.paytm.bank.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ExtraInfo implements Serializable, Logable {

    private static final long serialVersionUID = 6343529698019123331L;

    private String response_code;
    private String errorCode;
    private String limitMessage;
    private String statusCode;

    @Override
    public String toJson() {
        StringBuilder builder = new StringBuilder();
        builder.append("{\"response_code\":");
        builder.append(response_code);
        builder.append(", \"errorCode\":\"");
        builder.append(errorCode);
        builder.append(", \"limitMessage\":\"");
        builder.append(limitMessage);
        builder.append(", \"statusCode\":\"");
        builder.append(statusCode);
        builder.append("\"}");
        return builder.toString();
    }
}
