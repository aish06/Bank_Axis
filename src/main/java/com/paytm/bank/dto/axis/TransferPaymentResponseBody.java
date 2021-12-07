package com.paytm.bank.dto.axis;

import com.google.gson.Gson;
import lombok.Data;

import java.io.Serializable;

@Data
public class TransferPaymentResponseBody implements Serializable {
    private static final long serialVersionUID = -5318900149887377831L;

    private String data;
    private String message;
    private String status;
    private String checksum;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

//    @Override
//    public String toJson() {
//        StringBuilder builder = new StringBuilder();
//        builder.append("{\"data\":");
//        builder.append(data);
//        builder.append(", \"message\":\"");
//        builder.append(message);
//        builder.append(", \"status\":\"");
//        builder.append(status);
//        builder.append(", \"checksum\":\"");
//        builder.append(checksum);
//        builder.append("\"}");
//        return builder.toString();
//    }
}
