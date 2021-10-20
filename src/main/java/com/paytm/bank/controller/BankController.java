package com.paytm.bank.controller;

import com.paytm.bank.dto.*;
import com.paytm.bank.dto.RequestHeader;
import com.paytm.bank.dto.notification.GenericResponse;
import com.paytm.bank.dto.notification.Response;
import com.paytm.bank.dto.notification.ResponseBody;
import com.paytm.bank.dto.notification.ResponseHeader;
import org.springframework.http.*;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

@RestController
public class BankController {
    private String callbackUrl="http://localhost:8080/sts/secureresponse/PPBL/NEFT/RESP";

    @PostMapping(value = "/fund/initiate")
    public ResponseEntity<?> fundInitiate(@RequestBody TransferPaymentRequest transferPaymentRequest)
    {
        BankAcknowledgement bankAcknowledgement=new BankAcknowledgement();
        bankAcknowledgement.setStatus("Failure");
        bankAcknowledgement.setResponse_code(1100);
        bankAcknowledgement.setTxn_id(transferPaymentRequest.getTxnReqId());
        ExtraInfo extraInfo=new ExtraInfo();
        extraInfo.setResponse_code("0");
        bankAcknowledgement.setExtra_info(extraInfo);
//        bankAcknowledgement.setErrorMessage("bad gateway");
//        bankAcknowledgement.setErrorCode("456");
        callbackUrl=transferPaymentRequest.getProperties().getCallbackUrl();
        return new ResponseEntity<>(bankAcknowledgement,HttpStatus.OK);


//        StatusResponse statusResponse=new StatusResponse();
//        StatusResponseExtraInfo statusResponseExtraInfo=new StatusResponseExtraInfo();
//
//        statusResponseExtraInfo.setResponse_code("1100");
//        statusResponseExtraInfo.setExternalTransactionId(null);
//
//        statusResponse.setStatus("Success");
//        statusResponse.setResponse_code("1100");
//        statusResponse.setTransactionStatus("Failure");
//        statusResponse.setTxn_id(statusRequest.getTxnReqId());
//        statusResponse.setExtra_info(statusResponseExtraInfo);
//        return new ResponseEntity<>(statusResponse,HttpStatus.OK);

//        StatusResponse statusResponse = new StatusResponse();
//        statusResponse.setErrorCode("304");
//        statusResponse.setErrorMessage("SERVICE_UNAVAILABLE");
//        statusResponse.setStatus("Failure");
//        statusResponse.setResponse_code("1099");
//        statusResponse.setTxn_id(statusRequest.getTxnReqId());
//        statusResponse.setMessage("order id not found");
//        return new ResponseEntity<>(statusResponse, HttpStatus.SERVICE_UNAVAILABLE);

//        "status": "failure",
//            "message": "order id not found",
//            "response_code": 1099,
//            "txn_id": "D0L951O600MB3"
    }

    @GetMapping(value = "/status/{requestId}")
    public ResponseEntity statusResponse(@PathVariable String requestId)
    {
        CallbackRequest callbackRequest=new CallbackRequest();
        CallbackRequestExtraInfo callbackRequestExtraInfo=new CallbackRequestExtraInfo();
        CallbackRequestData callbackRequestData=new CallbackRequestData();

        callbackRequestData.setResponse_code("0");
        callbackRequestData.setClientRequestId(requestId);
        callbackRequestData.setTransactionRequestId("PB123");
        callbackRequestData.setStatus("Success");

        callbackRequestExtraInfo.setExternalTransactionId("rrn_2322");
        callbackRequestExtraInfo.setRefundId("56");
        callbackRequestExtraInfo.setCallback_Type("Paytm");

        callbackRequestData.setExtra_info(callbackRequestExtraInfo);
        callbackRequest.setData(callbackRequestData);
        MultiValueMap<String, String> headers=new HttpHeaders();
        headers.add("Authorization","hello");
        HttpEntity<CallbackRequest> requestEntity=new HttpEntity<>(callbackRequest,headers);
//        HttpEntity<CallbackRequest> requestEntity=new HttpEntity<>(callbackRequest);
        RestTemplate restTemplate=new RestTemplate();
        restTemplate.postForObject(callbackUrl,requestEntity,Object.class);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/notify")
    public ResponseEntity<?> notify(@RequestBody GenericResponse<Response<ResponseHeader, ResponseBody>> genericResponseDTO)
    {
        System.out.println(genericResponseDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(path = "/withdraw",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void withdraw(@RequestBody GenericRequest<RequestPayload<RequestHeader, WithdrawRequestDTO>> request)
    {
        for(int i=1;i<=10;i++)
        {
            Double d=Math.random();
            request.getRequest().getBody().setExtSerialNo(d.toString());
            HttpEntity requestEntity=new HttpEntity(request);
            RestTemplate restTemplate=new RestTemplate();
            GenericResponseDTO genericResponseDTO=
            restTemplate.postForObject("http://localhost:8080/sts/withdraw",requestEntity,GenericResponseDTO.class);
            System.out.println(genericResponseDTO.getGenericResponsePayload().getResponseBody().getResultInfo().getResultCode());
        }
        System.out.println("--------");
    }
}
