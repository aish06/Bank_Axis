package com.paytm.bank.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class ResponseDTO<H, B> implements Serializable {
    private static final long serialVersionUID = -1945872472848010706L;

    private H head;
    private B body;
}
