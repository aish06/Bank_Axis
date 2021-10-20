package com.paytm.bank.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Naveen Hugar
 * @created 07/09/2021
 **/

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultInfoDTO implements Serializable {

    private static final long serialVersionUID = 1544996319276746268L;

    private String resultStatus;

    private String resultCodeId;

    private String resultCode;

    private String resultMsg;
}
