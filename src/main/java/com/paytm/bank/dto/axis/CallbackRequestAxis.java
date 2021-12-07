package com.paytm.bank.dto.axis;

import com.google.gson.Gson;
import com.paytm.bank.dto.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class CallbackRequestAxis implements Serializable {
    private static final long serialVersionUID = 3319046175525925938L;

    private Data data;
    private String message;
    private String status;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

//    @Override
//    public String toJson() {
//        StringBuilder builder = new StringBuilder();
//        builder.append("{\"data\":");
//        builder.append(data!=null ? data.toJson():"{}");
//        builder.append(", \"message\":\"");
//        builder.append(message);
//        builder.append(", \"status\":\"");
//        builder.append(status);
//        builder.append("\"}");
//        return builder.toString();
//    }

}
