package com.paytm.bank.dto.axis;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.google.gson.Gson;
import lombok.Getter;

import java.io.Serializable;
import java.util.List;

@Getter
public class Data implements Serializable {
    private static final long serialVersionUID = -5461837468584228180L;

    private List<CURTXNENQ> CUR_TXN_ENQ;
    private String errorMessage;
    private String checksum;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

//    @Override
//    public String toJson() {
//        StringBuilder builder = new StringBuilder();
//        builder.append("{\"CUR_TXN_ENQ\":");
//        builder.append(CUR_TXN_ENQ);
//        builder.append(", \"errorMessage\":\"");
//        builder.append(errorMessage);
//        builder.append(", \"checksum\":\"");
//        builder.append(checksum);
//        builder.append("\"}");
//        return builder.toString();
//    }

    @JsonSetter("CUR_TXN_ENQ")
    public void setCUR_TXN_ENQ(List<CURTXNENQ> CUR_TXN_ENQ) {
        this.CUR_TXN_ENQ = CUR_TXN_ENQ;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public void setChecksum(String checksum) {
        this.checksum = checksum;
    }
}
