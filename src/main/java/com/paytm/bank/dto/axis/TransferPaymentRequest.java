package com.paytm.bank.dto.axis;

import com.google.gson.Gson;
import lombok.Data;

import java.io.Serializable;

@Data
public class TransferPaymentRequest implements Serializable {
    private static final long serialVersionUID = -6057219445441516774L;

    private SubHeader subHeader;
    private String TransferPaymentRequestBodyEncrypted;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

//    @Override
//    public String toJson() {
//        StringBuilder builder = new StringBuilder();
//        builder.append("{\"subHeader\":");
//        builder.append(subHeader!=null ? subHeader.toJson():"{}");
//        builder.append(", \"TransferPaymentRequestBodyEncrypted\":\"");
//        builder.append(TransferPaymentRequestBodyEncrypted);
//        builder.append("\"}");
//        return builder.toString();
//    }
}
