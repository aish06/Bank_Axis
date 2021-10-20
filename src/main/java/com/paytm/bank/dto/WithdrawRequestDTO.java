package com.paytm.bank.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * Fluxnet api withdraw request body DTO
 *
 */


@Data
public class WithdrawRequestDTO extends RequestBody implements Serializable, Logable {
    private static final long serialVersionUID = 5690290016204760112L;

    private String transId;
    private String bankAbbr;
    private String bankName;
    private String bankLineNo;
    private String bankAccountNo;
    private String mobileNo;
    private String terminalType;
    private String exchangeCurrency;
    private Double exchangeAmount;
    private String cashierWithdrawTime;
    private String payoutId;
    private String pmid;
    private String extendInfo;
    private String virtualPaymentAddress;
    private String merchantTransId;
    private String merchantName;
    private String holderFirstName;
    private String createdTime;
    private String payTime;
    private String payoutPriority;
    private String transferMode;

    @Override
    public String toJson() {
        StringBuilder builder = new StringBuilder();
        builder.append("{\"transId\":\"");
        builder.append(transId);
        builder.append("\", \"bankAbbr\":\"");
        builder.append(bankAbbr);
        builder.append("\", \"bankName\":\"");
        builder.append(bankName);
        builder.append("\", \"bankLineNo\":\"");
        builder.append(bankLineNo);
        builder.append("\", \"bankAccountNo\":\"");
        builder.append(bankAccountNo);
        builder.append("\", \"mobileNo\":\"");
        builder.append(mobileNo);
        builder.append("\", \"terminalType\":\"");
        builder.append(terminalType);
        builder.append("\", \"exchangeCurrency\":\"");
        builder.append(exchangeCurrency);
        builder.append("\", \"exchangeAmount\":\"");
        builder.append(exchangeAmount);
        builder.append("\", \"cashierWithdrawTime\":\"");
        builder.append(cashierWithdrawTime);
        builder.append("\", \"payoutId\":\"");
        builder.append(payoutId);
        builder.append("\", \"pmid\":\"");
        builder.append(pmid);
        builder.append("\", \"extendInfo\":\"");
        builder.append(extendInfo);
        builder.append("\", \"virtualPaymentAddress\":\"");
        builder.append(virtualPaymentAddress);
        builder.append("\", \"merchantTransId\":\"");
        builder.append(merchantTransId);
        builder.append("\", \"merchantName\":\"");
        builder.append(merchantName);
        builder.append("\", \"holderFirstName\":\"");
        builder.append(holderFirstName);
        builder.append("\", \"createdTime\":\"");
        builder.append(createdTime);
        builder.append("\", \"payTime\":\"");
        builder.append(payTime);
        builder.append("\", \"payoutPriority\":\"");
        builder.append(payoutPriority);
        builder.append("\", \"transferMode\":\"");
        builder.append(transferMode);
        builder.append("\"}");
        return builder.toString();
    }
}