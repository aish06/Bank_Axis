package com.paytm.bank.dto.axis;

import com.google.gson.Gson;
import lombok.Data;

import java.io.Serializable;

@Data
public class CURTXNENQCallback implements Serializable {
    private static final long serialVersionUID = 7688897076480504348L;

    private String transaction_id;
    private String chequeNo;
    private String statusDescription;
    private String batchNo;
    private String utrNo;
    private String transactionStatus;
    private String processingDate;
    private String corpCode;
    private String crn;
    private String responseCode;
    private String paymentMode;
    private String vendorCode;
    private String amount;
    private String corporateAccountNumber;
    private String debitCreditIndicator;
    private String beneficiaryAccountNumber;
    private String extra1;
    private String extra2;
    private String extra3;
    private String extra4;
    private String extra5;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

//    @Override
//    public String toJson() {
//        StringBuilder builder = new StringBuilder();
//        builder.append("{\"transaction_id\":");
//        builder.append(transaction_id);
//        builder.append(", \"chequeNo\":\"");
//        builder.append(chequeNo);
//        builder.append(", \"statusDescription\":\"");
//        builder.append(statusDescription);
//        builder.append(", \"batchNo\":\"");
//        builder.append(batchNo);
//        builder.append(", \"utrNo\":\"");
//        builder.append(utrNo);
//        builder.append(", \"transactionStatus\":\"");
//        builder.append(transactionStatus);
//        builder.append(", \"processingDate\":\"");
//        builder.append(processingDate);
//        builder.append(", \"corpCode\":\"");
//        builder.append(corpCode);
//        builder.append(", \"crn\":\"");
//        builder.append(crn);
//        builder.append(", \"responseCode\":\"");
//        builder.append(responseCode);
//        builder.append(", \"paymentMode\":\"");
//        builder.append(paymentMode);
//        builder.append(", \"vendorCode\":\"");
//        builder.append(vendorCode);
//        builder.append(", \"amount\":\"");
//        builder.append(amount);
//        builder.append(", \"corporateAccountNumber\":\"");
//        builder.append(corporateAccountNumber);
//        builder.append(", \"debitCreditIndicator\":\"");
//        builder.append(debitCreditIndicator);
//        builder.append(", \"beneficiaryAccountNumber\":\"");
//        builder.append(beneficiaryAccountNumber);
//        builder.append(", \"extra1\":\"");
//        builder.append(extra1);
//        builder.append(", \"extra2\":\"");
//        builder.append(extra2);
//        builder.append(", \"extra3\":\"");
//        builder.append(extra3);
//        builder.append(", \"extra4\":\"");
//        builder.append(extra4);
//        builder.append(", \"extra5\":\"");
//        builder.append(extra5);
//        builder.append("\"}");
//        return builder.toString();
//    }
}
