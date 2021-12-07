package com.paytm.bank.axis.ecryptdecrypt;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.apache.commons.codec.digest.MessageDigestAlgorithms.MD5;

/**
 * The class Generates the checksum for the given data using SHA256 method
 */
@Service
@Slf4j
public class ChecksumUtil {

    /** Generates the checksum for the given data
     * @param requestMap Data in Key Value pair format
     * @return Generated CheckSum
     */
    public String generateCheckSum(LinkedHashMap<String, Object> requestMap){
        log.info("Initializing generation of Checksum");
        if(null == requestMap) {
            throw new RuntimeException("Data required for checksum is empty");
        }
        StringBuilder finalChkSum = new StringBuilder();
        StringBuilder keys = new StringBuilder();
        try {
            for(Map.Entry<String, Object> entry: requestMap.entrySet()) {
                if(!entry.getKey().equals("checksum")) {
                    if(entry.getValue() instanceof List) {
                        List<Object> tempLst=((List)entry.getValue());
                        if(!CollectionUtils.isEmpty(tempLst) && (tempLst.get(0) instanceof Map)) {
                            List<? extends Map<String, Object>> innerObjectMap
                                    = (List<? extends Map<String, Object>>) entry.getValue();

                            for(Map<String ,Object> innerMap : innerObjectMap) {
                                for(Map.Entry<? extends String, ? extends Object> entryInn :
                                        innerMap.entrySet()) {
                                    keys.append(entryInn.getKey());
                                    finalChkSum.append(getInnerLevel2Map(entryInn.getValue(),finalChkSum));
                                }
                            }
                        }else if(!CollectionUtils.isEmpty(tempLst)) {
                            for(Object strValues : tempLst) {
                                finalChkSum.append(validateInfo(String.valueOf(strValues)));
                            }
                        }

                    } else if(entry.getValue() instanceof Map){
                        Map<? extends String, ? extends Object> innerObjectMap2
                                = (Map<? extends String, ? extends Object>) entry.getValue();
                        for(Map.Entry<? extends String, ? extends Object> entryInn :
                                innerObjectMap2.entrySet()) {
                            keys.append(entryInn.getKey());
                            finalChkSum.append(validateInfo(String.valueOf(entryInn.getValue())));
                        }
                    }else {
                        finalChkSum.append(validateInfo(String.valueOf(entry.getValue())));
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Cannot generate checksum");
        }
        return String.valueOf(encodeCheckSumWithSHA256(finalChkSum.toString().trim()));
    }

    /**
     * @param entryInnLvl2
     * @param finalChkSum123
     * @return finalChkSum
     */
    private String getInnerLevel2Map(Object entryInnLvl2,StringBuilder finalChkSum123) {
        StringBuilder finalChkSum = new StringBuilder();
        StringBuilder keys = new StringBuilder();
        if(entryInnLvl2/**
     * Determine whether given string has value or not
     * @param value Input String
     * @return Value of String if not empty, Otherwise returns EMPTY String
     */ instanceof List) {
            List<Object> tempLst=((List)entryInnLvl2);
            if(!CollectionUtils.isEmpty(tempLst) && (tempLst.get(0) instanceof Map)) {

                List<? extends Map<String, Object>> innerObjectMap =
                        (List<? extends Map<String, Object>>) entryInnLvl2;
                for(Map<String ,Object> innerMap : innerObjectMap) {
                    for(Map.Entry<? extends String, ? extends Object> entryInn : innerMap.entrySet()) {
                        keys.append(entryInn.getKey());
                        finalChkSum.append(
                                validateInfo(String.valueOf(entryInn.getValue())));
                    }
                }
            }else if(!CollectionUtils.isEmpty(tempLst)) {
                for(Object strValues : tempLst) {
                    finalChkSum.append(validateInfo(String.valueOf(strValues)));
                }
            }

        } else if(entryInnLvl2 instanceof Map){
            Map<? extends String, ? extends Object> innerObjectMap2 =
                    (Map<? extends String, ? extends Object>) entryInnLvl2;
            for(Map.Entry<? extends String, ? extends Object> entryInn : innerObjectMap2.entrySet()) {
                keys.append(entryInn.getKey());
                finalChkSum.append(validateInfo(String.valueOf(entryInn.getValue())));
            }
        }else {
            finalChkSum.append(validateInfo(String.valueOf(entryInnLvl2)));
        }
        return finalChkSum.toString();
    }

    /**
     * Encodes Checksum with SHA256 method
     * @param data Checksum data
     * @return Encoded Checksum
     */
    public static String encodeCheckSumWithSHA256(String data) {
        MessageDigest md;
        StringBuilder sb = new StringBuilder();
        String response = null;
        try {
            md = MessageDigest.getInstance(MD5);
            md.update(data.getBytes(StandardCharsets.UTF_8));
            // Get the hashbytes
            byte[] hashBytes = md.digest();
            // Convert hash bytes to hex format
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }
            response = sb.toString();
        }catch (Exception e) {
            throw new RuntimeException("Internal server error");
        }
        return response;
    }

    /**
     * Determine whether given string has value or not
     * @param value Input String
     * @return Value of String if not empty, Otherwise returns EMPTY String
     */
    public static Object validateInfo(String value) {
        return StringUtils.isNotEmpty(value) && "null" != value ? value : StringUtils.EMPTY;
    }
}
