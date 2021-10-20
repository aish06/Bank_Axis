package com.paytm.bank.dto.notification;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
@AllArgsConstructor
public class ResponseHeader implements Serializable {
    private static final long serialVersionUID = -250515541899425743L;

    private String version;
    private String function;
    private String appId;
    private String reqTime;
    private String reqMsgId;
}
