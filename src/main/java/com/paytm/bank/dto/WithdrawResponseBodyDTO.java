package com.paytm.bank.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class WithdrawResponseBodyDTO implements Serializable {
    private static final long serialVersionUID = -8202085386072732942L;

    private ResultInfoDTO resultInfo;

    private String extSerialNo;
    private String traceNo;
    private String rrnCode;
    private String bankAbbr;
    private String referenceNo;
    private String merchantId;
    private String mbid;
    private String transBankDate;
    private String feeCurrency;
    private String feeAmount;
    private String paidCurrency;
    private String paidAmount;

//    private ResultInfoDTO thirdResultInfo;

    private String transferMode;
}
