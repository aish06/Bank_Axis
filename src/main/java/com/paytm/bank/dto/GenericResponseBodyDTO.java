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
public class GenericResponseBodyDTO implements Serializable {

    private static final long serialVersionUID = 324593431866559130L;

    private ResultInfoDTO resultInfo;
}
