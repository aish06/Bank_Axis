package com.paytm.bank.dto.axis;

import com.google.gson.Gson;
import lombok.*;
import lombok.Data;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDetail implements Serializable {
    private static final long serialVersionUID = 837013708012053488L;

    private String txnPaymode;
    private String custUniqRef;
    private String corpAccNum;
    private String valueDate;
    private String txnAmount;
    private String beneName;
    private String beneCode;
    private String beneAccNum;
    private String beneAcType;
    private String beneAddr1;
    private String beneAddr2;
    private String beneAddr3;
    private String beneCity;
    private String beneState;
    private String benePincode;
    private String beneIfscCode;
    private String beneBankName;
    private String baseCode;
    private String chequeNumber;
    private String chequeDate;
    private String payableLocation;
    private String printLocation;
    private String beneEmailAddr1;
    private String beneMobileNo;
    private String productCode;
    private String txnType;
    private String invoiceDetails;
    private String enrichment1;
    private String enrichment2;
    private String enrichment3;
    private String enrichment4;
    private String enrichment5;
    private String senderToReceiverInfo;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

//    @Override
//    public String toJson() {
//        StringBuilder builder = new StringBuilder();
//        builder.append("{\"txnPaymode\":\"");
//        builder.append(txnPaymode);
//        builder.append("\", \"custUniqRef\":\"");
//        builder.append(custUniqRef);
//        builder.append("\", \"corpAccNum\":\"");
//        builder.append(corpAccNum);
//        builder.append("\", \"valueDate\":\"");
//        builder.append(valueDate);
//        builder.append("\", \"txnAmount\":\"");
//        builder.append(txnAmount);
//        builder.append("\", \"beneName\":\"");
//        builder.append(beneName);
//        builder.append("\", \"beneCode\":\"");
//        builder.append(beneCode);
//        builder.append("\", \"beneAcType\":\"");
//        builder.append(beneAcType);
//        builder.append("\", \"beneAddr1\":\"");
//        builder.append(beneAddr1);
//        builder.append("\", \"beneAddr2\":\"");
//        builder.append(beneAddr2);
//        builder.append("\", \"beneAddr3\":\"");
//        builder.append(beneAddr3);
//        builder.append("\", \"beneCity\":\"");
//        builder.append(beneCity);
//        builder.append("\", \"beneState\":\"");
//        builder.append(beneState);
//        builder.append("\", \"benePincode\":\"");
//        builder.append(benePincode);
//        builder.append("\", \"beneIfscCode\":\"");
//        builder.append(beneIfscCode);
//        builder.append("\", \"beneBankName\":\"");
//        builder.append(beneBankName);
//        builder.append("\", \"baseCode\":\"");
//        builder.append(baseCode);
//        builder.append("\", \"chequeNumber\":\"");
//        builder.append(chequeNumber);
//        builder.append("\", \"chequeDate\":\"");
//        builder.append(chequeDate);
//        builder.append("\", \"payableLocation\":\"");
//        builder.append(payableLocation);
//        builder.append("\", \"printLocation\":\"");
//        builder.append(printLocation);
//        builder.append("\", \"beneEmailAddr1\":\"");
//        builder.append(beneEmailAddr1);
//        builder.append("\", \"beneMobileNo\":\"");
//        builder.append(beneMobileNo);
//        builder.append("\", \"productCode\":\"");
//        builder.append(productCode);
//        builder.append("\", \"txnType\":\"");
//        builder.append(txnType);
//        builder.append("\", \"invoiceDetails\":\"");
//        builder.append(invoiceDetails);
//        builder.append("\", \"enrichment1\":\"");
//        builder.append(enrichment1);
//        builder.append("\", \"enrichment2\":\"");
//        builder.append(enrichment2);
//        builder.append("\", \"enrichment3\":\"");
//        builder.append(enrichment3);
//        builder.append("\", \"enrichment4\":\"");
//        builder.append(enrichment4);
//        builder.append("\", \"enrichment5\":\"");
//        builder.append(enrichment5);
//        builder.append("\", \"senderToReceiverInfo\":\"");
//        builder.append(senderToReceiverInfo);
//        builder.append("\"}");
//        return builder.toString();
//    }

//    @Override
//    public String toString() {
//        System.out.println("In to String of Payment Details");
//        String json = new Gson().toJson(this);
//        System.out.println(json);
//        return json;
////        return toJson();
////        return "PaymentDetail(txnPaymode=" + this.getTxnPaymode() + ", custUniqRef=" + this.getCustUniqRef() + ", corpAccNum=" + this.getCorpAccNum() + ", valueDate=" + this.getValueDate() + ", txnAmount=" + this.getTxnAmount() + ", beneName=" + this.getBeneName() + ", beneCode=" + this.getBeneCode() + ", beneAccNum=" + this.getBeneAccNum() + ", beneAcType=" + this.getBeneAcType() + ", beneAddr1=" + this.getBeneAddr1() + ", beneAddr2=" + this.getBeneAddr2() + ", beneAddr3=" + this.getBeneAddr3() + ", beneCity=" + this.getBeneCity() + ", beneState=" + this.getBeneState() + ", benePincode=" + this.getBenePincode() + ", beneIfscCode=" + this.getBeneIfscCode() + ", beneBankName=" + this.getBeneBankName() + ", baseCode=" + this.getBaseCode() + ", chequeNumber=" + this.getChequeNumber() + ", chequeDate=" + this.getChequeDate() + ", payableLocation=" + this.getPayableLocation() + ", printLocation=" + this.getPrintLocation() + ", beneEmailAddr1=" + this.getBeneEmailAddr1() + ", beneMobileNo=" + this.getBeneMobileNo() + ", productCode=" + this.getProductCode() + ", txnType=" + this.getTxnType() + ", invoiceDetails=" + this.getInvoiceDetails() + ", enrichment1=" + this.getEnrichment1() + ", enrichment2=" + this.getEnrichment2() + ", enrichment3=" + this.getEnrichment3() + ", enrichment4=" + this.getEnrichment4() + ", enrichment5=" + this.getEnrichment5() + ", senderToReceiverInfo=" + this.getSenderToReceiverInfo() + ")";
//    }
}
