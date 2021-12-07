package com.paytm.bank.axis.ecryptdecrypt;

import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TestData1 implements Serializable {
    private static final long serialVersionUID = 837013708012053488L;

    private String f;
    private String t;

    @Override
    public String toString() {
        System.out.println("In to string");
        String json = new Gson().toJson(this);
        System.out.println(json);
        return json;
    }
}
