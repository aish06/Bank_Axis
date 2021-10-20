package com.paytm.bank.dto;

import lombok.Data;
import java.io.Serializable;

@Data
public class TransferPaymentRequestDTO implements Serializable {
    private static final long serialVersionUID = -2940746660793120840L;

    com.paytm.bank.dto.SubHeaderRequestDTO subHeader;
    String transferPaymentRequestBody;
}
