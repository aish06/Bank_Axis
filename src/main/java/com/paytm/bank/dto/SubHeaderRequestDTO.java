package com.paytm.bank.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class SubHeaderRequestDTO implements Serializable {
    private static final long serialVersionUID = 254565816712489205L;

    String requestUUID;
    String serviceRequestId;
    String serviceRequestVersion;
    String channelId;
}
