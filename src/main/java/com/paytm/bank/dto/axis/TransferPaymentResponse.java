package com.paytm.bank.dto.axis;

import com.google.gson.Gson;
import lombok.Data;

import java.io.Serializable;

@Data
public class TransferPaymentResponse implements Serializable {

    private static final long serialVersionUID = 5664966449635150593L;

    private SubHeader subHeader;
    private String TransferPaymentResponseBodyEncrypted;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

//    @Override
//    public String toJson() {
//        StringBuilder builder = new StringBuilder();
//        builder.append("{\"subHeader\":");
//        builder.append(subHeader!=null ? subHeader.toJson():"{}");
//        builder.append(", \"transferPaymentRequestBody\":\"");
//        builder.append(TransferPaymentResponseBodyEncrypted);
//        builder.append("\"}");
//        return builder.toString();
//    }
}
