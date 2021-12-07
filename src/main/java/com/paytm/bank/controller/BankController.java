package com.paytm.bank.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.paytm.bank.axis.ecryptdecrypt.AESEncryptionDecryptionUtils;
import com.paytm.bank.axis.ecryptdecrypt.ChecksumUtil;
import com.paytm.bank.axis.ecryptdecrypt.ObjectToHashUtil;
import com.paytm.bank.dto.*;
import com.paytm.bank.dto.RequestHeader;
import com.paytm.bank.dto.TransferPaymentRequest;
import com.paytm.bank.dto.axis.*;
import com.paytm.bank.dto.axis.Data;
import com.paytm.bank.dto.notification.GenericResponse;
import com.paytm.bank.dto.notification.Response;
import com.paytm.bank.dto.notification.ResponseBody;
import com.paytm.bank.dto.notification.ResponseHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@RestController
public class BankController {
    private String callbackUrl="http://localhost:8080/sts/secureresponse/PPBL/NEFT/RESP";

    @PostMapping(value = "/fund/initiate")
    public ResponseEntity<?> fundInitiate(@RequestBody TransferPaymentRequest transferPaymentRequest)
    {
        try {
            Thread.sleep(600000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        BankAcknowledgement bankAcknowledgement=new BankAcknowledgement();
//        bankAcknowledgement.setStatus("Accepted");
//        bankAcknowledgement.setResponse_code(0);
//        bankAcknowledgement.setTxn_id(transferPaymentRequest.getTxnReqId());
//        ExtraInfo extraInfo=new ExtraInfo();
//        extraInfo.setResponse_code("0");
//        bankAcknowledgement.setExtra_info(extraInfo);
//        bankAcknowledgement.setErrorMessage("bad gateway");
//        bankAcknowledgement.setErrorCode("456");
        FundTransferAcknowledgement fundTransferAcknowledgement=new FundTransferAcknowledgement();
        fundTransferAcknowledgement.setStatus("Accepted");
        fundTransferAcknowledgement.setResponse_code("0");
        fundTransferAcknowledgement.setTxn_id(transferPaymentRequest.getTxnReqId());

        ExtraInfo extraInfo=new ExtraInfo();
        extraInfo.setResponse_code("0");

        fundTransferAcknowledgement.setExtra_info(extraInfo);
        callbackUrl=transferPaymentRequest.getProperties().getCallbackUrl();
        return new ResponseEntity<>(fundTransferAcknowledgement,HttpStatus.OK);



//        "status": "failure",
//            "message": "order id not found",
//            "response_code": 1099,
//            "txn_id": "D0L951O600MB3"
    }

    @PostMapping(value = "/statuscheck")
    public ResponseEntity<?> statuscheck(@RequestBody StatusRequest statusRequest)
    {
        StatusResponse statusResponse=new StatusResponse();
        StatusResponseExtraInfo statusResponseExtraInfo = new StatusResponseExtraInfo();
        statusResponseExtraInfo.setResponse_code("0");
        statusResponseExtraInfo.setExternalTransactionId("PPBL67");

        statusResponse.setStatus("Success");
//        statusResponse.setResponse_code("1074");
        statusResponse.setTransactionStatus("Pending");
        statusResponse.setMessage("Status");
        statusResponse.setExtra_info(statusResponseExtraInfo);
        statusResponse.setTxn_id(statusRequest.getTxnReqId());
        return new ResponseEntity<>(statusResponse,HttpStatus.OK);
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

    @Autowired
    AESEncryptionDecryptionUtils aesEncryptionDecryptionUtils;

    @Autowired
    ChecksumUtil checksumUtil;

    @Autowired
    ObjectToHashUtil objectToHashUtil;

    @PostMapping(value = "/fundTransferAxis")
    public ResponseEntity<?> fundTransferAxis(@RequestBody com.paytm.bank.dto.axis.TransferPaymentRequest r) throws Exception {
        TransferPaymentRequestBody h = aesEncryptionDecryptionUtils.aes128Decrypt(r.getTransferPaymentRequestBodyEncrypted(),
                TransferPaymentRequestBody.class);
        TransferPaymentResponse transferPaymentResponse = new TransferPaymentResponse();
        transferPaymentResponse.setSubHeader(r.getSubHeader());

        TransferPaymentResponseBody transferPaymentResponseBody = new TransferPaymentResponseBody();
        transferPaymentResponseBody.setStatus("S");
        transferPaymentResponseBody.setMessage("Request Accepted");

        String encryptedTransferPaymentResponseBody = aesEncryptionDecryptionUtils.aes128Encrypt(transferPaymentResponseBody);
        transferPaymentResponse.setTransferPaymentResponseBodyEncrypted(encryptedTransferPaymentResponseBody);
        System.out.println(transferPaymentResponse);
        System.out.println(aesEncryptionDecryptionUtils);
        return new ResponseEntity<>(transferPaymentResponse, HttpStatus.OK);
    }

    @PostMapping(value = "/statusAxis")
    public ResponseEntity<?> statusAxis(@RequestBody GetStatusRequest r) throws Exception {
        GetStatusRequestBody getStatusRequestBody = aesEncryptionDecryptionUtils.aes128Decrypt(r.getGetStatusRequestBodyEncrypted(),
                GetStatusRequestBody.class);

        GetStatusResponse getStatusResponse = new GetStatusResponse();
        getStatusResponse.setSubHeader(r.getSubHeader());

        GetStatusResponseBody getStatusResponseBody = new GetStatusResponseBody();
        getStatusResponseBody.setStatus("Success");
        getStatusResponseBody.setMessage("Api accepted");

        CURTXNENQ curtxnenq = new CURTXNENQ();
        curtxnenq.setCrn(getStatusRequestBody.getCrn());
        curtxnenq.setTransactionStatus("Pending");
        curtxnenq.setStatusDescription("Transaction is Pending");

        List<CURTXNENQ> e = new ArrayList<>();
        e.add(curtxnenq);
        Data d =new Data();
        d.setCUR_TXN_ENQ(e);
        getStatusResponseBody.setData(d);

        System.out.println(getStatusResponseBody.getData());

        String checksum = checksumUtil.generateCheckSum(objectToHashUtil.convObjectHash(getStatusResponseBody.getData()));
        System.out.println(checksum);
        getStatusResponseBody.getData().setChecksum(checksum);

        String encryptedString = aesEncryptionDecryptionUtils.aes128Encrypt(getStatusResponseBody);

        getStatusResponse.setGetStatusResponseBodyEncrypted(encryptedString);
        System.out.println(getStatusResponse);
        return new ResponseEntity<>(getStatusResponse, HttpStatus.OK);
    }

    @PostMapping(value = "/callbackAxis")
    public ResponseEntity<?> callbackAxis() throws Exception {
        CallbackRequestAxis callbackRequestAxis = new CallbackRequestAxis();

        CURTXNENQCallback curtxnenqCallback = new CURTXNENQCallback();
        curtxnenqCallback.setPaymentMode("PA");
        curtxnenqCallback.setResponseCode("00");
        curtxnenqCallback.setTransactionStatus("Processed");
        curtxnenqCallback.setStatusDescription("Transaction Successful");
        curtxnenqCallback.setCrn("622323267724278722");
        curtxnenqCallback.setTransaction_id("AXIS_123");
        curtxnenqCallback.setUtrNo("8374939374929");

        List<CURTXNENQCallback> t = new ArrayList<>();
        t.add(curtxnenqCallback);

        com.paytm.bank.dto.Data d = new com.paytm.bank.dto.Data();
        d.setCUR_TXN_ENQ(t);

        callbackRequestAxis.setMessage("Success");
        callbackRequestAxis.setStatus("S");
        callbackRequestAxis.setData(d);

        String checksum = checksumUtil.generateCheckSum(objectToHashUtil.convObjectHash(callbackRequestAxis.getData()));
        System.out.println(checksum);
        callbackRequestAxis.getData().setChecksum(checksum);
        System.out.println(callbackRequestAxis);

        String encryptedString = aesEncryptionDecryptionUtils.aes128Encrypt(callbackRequestAxis);

        CallbackRequestEncrypted callbackRequestEncrypted = new CallbackRequestEncrypted();
        callbackRequestEncrypted.setGetStatusResponseBodyEncrypted(encryptedString);

        HttpEntity<CallbackRequestEncrypted> requestEntity=new HttpEntity<>(callbackRequestEncrypted);
        RestTemplate restTemplate=new RestTemplate();
        restTemplate.postForObject("http://localhost:8080/sts/secureresponse/Axis/fund-transfer/callback",requestEntity,Object.class);
        return new ResponseEntity<>(HttpStatus.OK);    }
}
