package com.paytm.bank.dto.axis;

import com.google.gson.Gson;
import lombok.Data;

import java.io.Serializable;

@Data
public class CURTXNENQ implements Serializable {
    private static final long serialVersionUID = 8247023197609641499L;

    private String corpCode;
    private String statusDescription;
    private String batchNo;
    private String utrNo;
    private String processingDate;
    private String responseCode;
    private String crn;
    private String transactionStatus;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

//    @Override
//    public String toJson() {
//        StringBuilder builder = new StringBuilder();
//        builder.append("{\"corpCode\":");
//        builder.append(corpCode);
//        builder.append("{\"statusDescription\":");
//        builder.append(statusDescription);
//        builder.append("{\"batchNo\":");
//        builder.append(batchNo);
//        builder.append("{\"utrNo\":");
//        builder.append(utrNo);
//        builder.append("{\"processingDate\":");
//        builder.append(processingDate);
//        builder.append(",\"responseCode\":\"");
//        builder.append(responseCode);
//        builder.append(",\"crn\":\"");
//        builder.append(crn);
//        builder.append(", \"transactionStatus\":\"");
//        builder.append(transactionStatus);
//        builder.append("\"}");
//        return builder.toString();
//    }
}
