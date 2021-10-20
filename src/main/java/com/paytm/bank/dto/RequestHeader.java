package com.paytm.bank.dto;

import lombok.Data;
import java.io.Serializable;

@Data
public class RequestHeader implements Serializable, Logable {

    private String version;

    private String function;


    private String appId;

    private String reqTime;

    private String reqMsgId;

    @Override
    public String toJson() {
        StringBuilder builder = new StringBuilder();
        builder.append("{\"version\":\"");
        builder.append(version);
        builder.append("\", \"function\":\"");
        builder.append(function);
        builder.append("\", \"appId\":\"");
        builder.append(appId);
        builder.append("\", \"reqTime\":\"");
        builder.append(reqTime);
        builder.append("\", \"reqMsgId\":\"");
        builder.append(reqMsgId);
        builder.append("\"}");
        return builder.toString();
    }
}
