package com.paytm.bank.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author aishwarysrivastava
 * @created 06/10/2021
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CallbackRequest implements Serializable, Logable {
    private static final long serialVersionUID = -5931124919721594820L;

    private String event_tracking_id;
    private String ca_id;
    private CallbackRequestData data;

    @Override
    public String toJson() {
        StringBuilder builder = new StringBuilder();
        builder.append("{\"event_tracking_id\":\"");
        builder.append(event_tracking_id);
        builder.append("\", \"ca_id\":\"");
        builder.append(ca_id);
        builder.append("\", \"data\":\"");
        builder.append(data!=null ? data.toJson() : "{}");
        builder.append("}");
        return builder.toString();
    }
}
