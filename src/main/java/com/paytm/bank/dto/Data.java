package com.paytm.bank.dto;

import com.google.gson.Gson;
import com.paytm.bank.dto.axis.CURTXNENQCallback;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class Data implements Serializable {
    private static final long serialVersionUID = 5798634019145861924L;

    private List<CURTXNENQCallback> CUR_TXN_ENQ;
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
//        builder.append(", \"checksum\":\"");
//        builder.append(checksum);
//        builder.append("\"}");
//        return builder.toString();
//    }
}
