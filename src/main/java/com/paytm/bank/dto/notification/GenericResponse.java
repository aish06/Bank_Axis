package com.paytm.bank.dto.notification;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class GenericResponse<R> implements Serializable {
    private static final long serialVersionUID = 6172341942032325789L;

    private R request;

    private String signature;
}
