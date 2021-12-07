package com.paytm.bank.dto.axis;

import com.google.gson.Gson;
import lombok.Data;

import java.io.Serializable;

@Data
public class CallbackRequestEncrypted implements Serializable {
    private static final long serialVersionUID = -8806332506096927908L;

    private String getStatusResponseBodyEncrypted;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

//    @Override
//    public String toJson() {
//        StringBuilder builder = new StringBuilder();
//        builder.append("{\"getStatusResponseBodyEncrypted\":");
//        builder.append(getStatusResponseBodyEncrypted);
//        builder.append("\"}");
//        return builder.toString();
//    }
}
