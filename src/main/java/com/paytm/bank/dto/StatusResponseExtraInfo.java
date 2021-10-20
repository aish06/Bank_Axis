package com.paytm.bank.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author aishwarysrivastava
 * @created 30/09/2021
 */
@Data
public class StatusResponseExtraInfo implements Serializable, Logable{
    private static final long serialVersionUID = -4545793095869482971L;

    private String beneficiary_name;
    private String response_code;
    private String pu_id;
    private String custom_pmt_status_lag;
    private String externalTransactionId;

    @Override
    public String toJson() {
        StringBuilder builder = new StringBuilder();
        builder.append("{\"beneficiary_name\":\"");
        builder.append(beneficiary_name);
        builder.append("\", \"response_code\":\"");
        builder.append(response_code);
        builder.append("\", \"pu_id\":\"");
        builder.append(pu_id);
        builder.append("\", \"custom_pmt_status_lag\":\"");
        builder.append(custom_pmt_status_lag);
        builder.append("\", \"externalTransactionId\":\"");
        builder.append(externalTransactionId);
        builder.append("\"}");
        return builder.toString();
    }
}
