package com.paytm.bank.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Naveen Hugar
 * @created 17/09/2021
 **/
@AllArgsConstructor
@Data
@NoArgsConstructor
public class GenericResponsePayloadDTO implements Serializable {
    private static final long serialVersionUID = 5392664540381828954L;

    private GenericResponseBodyDTO responseBody;

    private GenericResponseHeaderDTO responseHeader;
}
