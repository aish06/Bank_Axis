package com.paytm.bank.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
/**
 * Class holding the request body object.
 * @author shubham sonthalia
 *
 */

//@Value
public class RequestBody implements Serializable, Logable {

    private static final long serialVersionUID = 8352305293471573835L;

    protected String extSerialNo = "";


    @Override
    public String toJson() {
        StringBuilder builder = new StringBuilder();
        builder.append("{\"extSerialNo\":");
        builder.append(extSerialNo);
        builder.append("}");
        return builder.toString();
    }

}
