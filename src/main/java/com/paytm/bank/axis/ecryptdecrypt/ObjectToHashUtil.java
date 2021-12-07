package com.paytm.bank.axis.ecryptdecrypt;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;

/**
 * This class converts the object data to Linked Hashmap data type
 */
@Service
@Slf4j
public class ObjectToHashUtil {

    /**
     * This method converts the Object to Linked Hashmap data type
     * @param object JSON object
     * @return Converted Linked Hashmap object
     */
    public LinkedHashMap<String,Object> convObjectHash(Object object){
        log.info("Initialized Conversion of JSON data to Linked Hashmap");
        ObjectMapper mapper = new ObjectMapper();
        LinkedHashMap map = mapper.convertValue(object,LinkedHashMap.class);
        log.info("Conversion completed");
        return map;
    }
}
