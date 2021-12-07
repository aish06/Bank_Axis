package com.paytm.bank.dto.axis;

import com.google.gson.Gson;
import lombok.Data;

import java.io.Serializable;

@Data
public class GetStatusRequestBody implements Serializable {
    private static final long serialVersionUID = 3606769751162956884L;

    private String channelId;
    private String corpCode;
    private String crn;
    private String checksum;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

//    @Override
//    public String toJson() {
//        StringBuilder builder = new StringBuilder();
//        builder.append("{\"channelId\":");
//        builder.append(channelId);
//        builder.append(", \"corpCode\":\"");
//        builder.append(corpCode);
//        builder.append(", \"crn\":\"");
//        builder.append(crn);
//        builder.append(", \"checksum\":\"");
//        builder.append(checksum);
//        builder.append("\"}");
//        return builder.toString();
//    }
}
