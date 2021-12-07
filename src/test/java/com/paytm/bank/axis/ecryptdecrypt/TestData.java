package com.paytm.bank.axis.ecryptdecrypt;

import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class TestData implements Serializable {
    private static final long serialVersionUID = -8048611747803655552L;


    private String a;
    private String b;
    private String c;
    private List<TestData1> d;

    @Override
    public String toString() {
        System.out.println("In to string");
        String json = new Gson().toJson(this);
        System.out.println(json);
        return json;
    }
}
