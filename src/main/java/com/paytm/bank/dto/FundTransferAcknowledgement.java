package com.paytm.bank.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class FundTransferAcknowledgement extends BankResponse implements Serializable, Logable {
    private static final long serialVersionUID = 6596820559216503988L;

    private ExtraInfo extra_info;

    @Override
    public String toJson() {
        StringBuilder builder = new StringBuilder();
        builder.append("{\"extra_info\":");
        builder.append(extra_info!=null ? extra_info.toJson() : "{}");
        builder.append("}");
        return builder.toString();
    }
}