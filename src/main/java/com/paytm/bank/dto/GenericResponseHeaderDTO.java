package com.paytm.bank.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Naveen Hugar
 * @created 17/09/2021
 **/
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenericResponseHeaderDTO implements Serializable {
    private static final long serialVersionUID = -4885390154245995934L;

    private String version;
    private String function;
    private String appId;
    private String reqTime;
    private String reqMsgId;
}
