package com.paytm.bank.dto.axis;

import com.google.gson.Gson;
import lombok.Data;

import java.io.Serializable;

@Data
public class GetStatusRequest implements Serializable {
    private static final long serialVersionUID = 2231768156695855823L;

    private SubHeader subHeader;
    private String GetStatusRequestBodyEncrypted;

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
//        builder.append(GetStatusRequestBodyEncrypted);
//        builder.append("\"}");
//        return builder.toString();
//    }
}
