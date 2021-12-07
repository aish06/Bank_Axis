package com.paytm.bank.dto.axis;

import com.google.gson.Gson;
import lombok.Data;

import java.io.Serializable;

@Data
public class GetStatusResponse implements Serializable {
    private static final long serialVersionUID = 4967715462148962958L;

    private SubHeader subHeader;
    private String GetStatusResponseBodyEncrypted;

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
//        builder.append(GetStatusResponseBodyEncrypted);
//        builder.append("\"}");
//        return builder.toString();
//    }
}
