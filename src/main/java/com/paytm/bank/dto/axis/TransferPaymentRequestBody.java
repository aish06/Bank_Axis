package com.paytm.bank.dto.axis;

import com.google.gson.Gson;
import lombok.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransferPaymentRequestBody implements Serializable{
    private static final long serialVersionUID = -8048611747803655552L;

    private String channelId;
    private String corpCode;
    private List<PaymentDetail> paymentDetails;
    private String checksum;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

    //    @Override
//    public String toJson() {
//        StringBuilder builder = new StringBuilder();
//        builder.append("{\"channelId\":\"");
//        builder.append(channelId);
//        builder.append("\", \"corpCode\":\"");
//        builder.append(corpCode);
//        builder.append("\", \"paymentDetails\":");
//        builder.append(paymentDetails);
//        builder.append(", \"checksum\":\"");
//        builder.append(checksum);
//        builder.append("\"}");
//        return builder.toString();
//    }

//    @Override
//    public String toString() {
//        System.out.println("In to string");
//        String json = new Gson().toJson(this);
//        System.out.println(json);
//        return json;
////        return toJson();        System.out.println(r);

////        return "TransferPaymentRequestBody(channelId=" + this.getChannelId() + ", corpCode=" + this.getCorpCode() + ", paymentDetails=" + this.getPaymentDetails() + ", checksum=" + this.getChecksum() + ")";
//    }
}
