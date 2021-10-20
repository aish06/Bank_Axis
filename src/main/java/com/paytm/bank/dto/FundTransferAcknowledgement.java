package com.paytm.bank.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class FundTransferAcknowledgement implements Serializable, Logable {
    private static final long serialVersionUID = 6596820559216503988L;

    private String status;
    private BigDecimal amount;
    private String response_code;
    private String txn_id;
    private ExtraInfo extra_info;
    private String errorCode;
    private String errorMessage;


    // TODO: 06/10/21 add extra info in toJson
    @Override
    public String toJson() {
        StringBuilder builder = new StringBuilder();
        builder.append("{\"status\":\"");
        builder.append(status);
        builder.append("\", \"amount\":\"");
        builder.append(amount!=null ? amount.toString() : null);
        builder.append("\", \"response_code\":\"");
        builder.append(response_code!=null ? response_code.toString() : null);
        builder.append("\", \"txn_id\":\"");
        builder.append(txn_id);
        builder.append("\"}");
        return builder.toString();
    }
}