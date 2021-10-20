package com.paytm.bank.dto.notification;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Response<H, B> implements Serializable {
    private static final long serialVersionUID = -1945872472848010706L;

    private H head;
    private B body;
}
