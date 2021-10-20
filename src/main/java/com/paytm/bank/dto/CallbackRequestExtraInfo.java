package com.paytm.bank.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author aishwarysrivastava
 * @created 20/09/2021
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CallbackRequestExtraInfo implements Serializable, Logable{
    private static final long serialVersionUID = 7885192511413313601L;

    private String benName;
    private String transfer_mode;
    private String externalTransactionId;
    private String callback_Type;
    private String refundId;
    private String beneficiary_name;

    @Override
    public String toJson() {
        StringBuilder builder = new StringBuilder();
        builder.append("{\"benName\":\"");
        builder.append(benName);
        builder.append("\", \"transfer_mode\":\"");
        builder.append(transfer_mode);
        builder.append("\", \"externalTransactionId\":\"");
        builder.append(externalTransactionId);
        builder.append("\", \"callback_Type\":\"");
        builder.append(callback_Type);
        builder.append("\", \"refundId\":\"");
        builder.append(refundId);
        builder.append("\", \"beneficiary_name\":\"");
        builder.append(beneficiary_name);
        builder.append("\"}");
        return builder.toString();
    }
}
