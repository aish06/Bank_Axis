package com.paytm.bank.dto;

import lombok.Data;


/**
 * Generic class to map the incoming request.
 *
 * @author Shubham Sonthalia
 */

@Data
public class GenericRequest<R extends Logable> implements Logable{

    private R request;

    private String signature;

    @Override
    public String toJson() {
        StringBuilder builder = new StringBuilder();
        builder.append("{\"request\":");
        builder.append(request.toJson());
        builder.append(", \"signature\":\"");
        builder.append(signature);
        builder.append("\"}");
        return builder.toString();
    }

}
