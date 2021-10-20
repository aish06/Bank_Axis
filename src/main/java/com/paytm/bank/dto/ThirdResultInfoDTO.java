package com.paytm.bank.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Naveen Hugar
 * @created 07/09/2021
 **/

@Data
public class ThirdResultInfoDTO implements Serializable {

    private static final long serialVersionUID = 1648546589821270941L;

    private String resultStatus;

    private String resultCodeId;

    private String resultCode;

    private String resultMsg;
}
