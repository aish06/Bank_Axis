package com.paytm.bank.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class WithdrawResponseHeaderDTO implements Serializable {

    private static final long serialVersionUID = -250515541899425743L;

    private String version;
    private String function;
    private String appId;
    private String reqTime;
    private String reqMsgId;
}
