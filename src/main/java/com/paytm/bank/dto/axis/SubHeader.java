package com.paytm.bank.dto.axis;

import lombok.Data;

import java.io.Serializable;

@Data
public class SubHeader implements Serializable, Logable {
    private static final long serialVersionUID = 674661546815186185L;

    private String requestUUID;
    private String serviceRequestId;
    private String serviceRequestVersion;
    private String channelId;

    @Override
    public String toJson() {
        StringBuilder builder = new StringBuilder();
        builder.append("{\"requestUUID\":");
        builder.append(requestUUID);
        builder.append(", \"serviceRequestId\":\"");
        builder.append(serviceRequestId);
        builder.append(", \"serviceRequestVersion\":\"");
        builder.append(serviceRequestVersion);
        builder.append(", \"channelId\":\"");
        builder.append(channelId);
        builder.append("\"}");
        return builder.toString();
    }
}
