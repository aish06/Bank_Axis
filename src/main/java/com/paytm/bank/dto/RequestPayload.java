package com.paytm.bank.dto;


import lombok.Data;

/**
 * Contains computable data received in the Request excluding the signature
 *
 * @author Shubham Sonthalia
 */

@Data
public class RequestPayload<H extends Logable,B extends Logable> implements Logable{

    H head;

    B body;

    @Override
    public String toJson() {
        StringBuilder builder = new StringBuilder();
        builder.append("{\"head\":");
        builder.append(head.toJson());
        builder.append(", \"body\":");
        builder.append(body.toJson());
        builder.append("}");
        return builder.toString();
    }

}
