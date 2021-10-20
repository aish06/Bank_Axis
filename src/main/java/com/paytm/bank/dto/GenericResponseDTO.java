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
public class GenericResponseDTO implements Serializable {

    private static final long serialVersionUID = -8251728636737054237L;

    private GenericResponsePayloadDTO genericResponsePayload;

    private String signature;
}
