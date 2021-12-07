package com.paytm.bank.axis.ecryptdecrypt;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.org.apache.xml.internal.security.utils.Base64;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.ByteArrayOutputStream;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * This class Encrypts and Decrypts the data using AES128 method
 */
@Service
@Slf4j
public class AESEncryptionDecryptionUtils {
    private static final String ALGORITHM = "AES";
    private static final String CIPHER_ALGORITHM = "AES/CBC/PKCS5PADDING";
    private static final String KEY = "29C1EB633ECAB0CA0F52B588AE92EA31";
    private static final byte[] ENCRYPTING_BYTES = new byte[] { (byte) 0x8E, 0x12, 0x39, (byte) 0x9C, 0x07,
            0x72, 0x6F, 0x5A, (byte) 0x8E, 0x12, 0x39, (byte) 0x9C, 0x07,
            0x72, 0x6F, 0x5A };

    /**
     * Encrypts the object using aes 128 bit.
     *
     * @param plainText Data that has to encrypted
     * @return Encrypted String
     * @throws Exception throws Exception while encrypting.
     */
    public String aes128Encrypt(Object plainText)
    {
        log.info("Encryption method initiated");
        if(plainText == null){
            throw new RuntimeException("Object to be encrypted is null");
        }
        String encryptedResult = "";
        try {
            AlgorithmParameterSpec paramSpec = new IvParameterSpec(ENCRYPTING_BYTES);
            SecretKeySpec skeySpec = getSecretKeySpecFromHexString(ALGORITHM, KEY);
            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, paramSpec);
            System.out.println(plainText.toString());
            byte[] encrypted = cipher.doFinal(plainText.toString().getBytes("UTF-8"));

            byte[] encryptedWithIV = copyIVAndCipher(encrypted, ENCRYPTING_BYTES);
            encryptedResult = Base64.encode(encryptedWithIV);
            log.info("Encrypted String Generated");
        }
        catch (Exception e) {
            System.out.println("Cannot encrypt");
        }
        return encryptedResult;
    }

    /**
     * Decrypts encrypted string in object.
     * @param encryptedText Encrypted String that has to be Decrypted
     * @return Decrypted data
     * @throws Exception throws exception while decrypting.
     */
    public <T>T aes128Decrypt(String encryptedText, Class<T> tClass) throws Exception
    {
        log.info("Decryption method initiated");
        SecretKeySpec skeySpec = getSecretKeySpecFromHexString(ALGORITHM, KEY);
        byte[] encryptedIVandTextAsBytes = Base64.decode(encryptedText);
        byte[] iv = Arrays.copyOf(encryptedIVandTextAsBytes, 16);
        byte[] ciphertextByte = Arrays.copyOfRange(encryptedIVandTextAsBytes, 16,
                                    encryptedIVandTextAsBytes.length);
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, skeySpec, new IvParameterSpec(iv));
        byte[] decryptedTextBytes = cipher.doFinal(ciphertextByte);
//        String decryptedResult = new String(decryptedTextBytes, "UTF-8");
        log.info("String Decrypted");
        return new ObjectMapper().readValue(decryptedTextBytes, tClass);
    }

//    public <T> T aes128Decrypt(String encryptedText,Class<T> tClass) throws Exception {
//        log.info("Decryption method initiated");
//        if(StringUtils.isEmpty(encryptedText)){
//            throw new NoSuchElementException("Encrypted string is null or empty");
//        }
//        byte[] encryptedIVAndTextAsBytes = Base64.decode(encryptedText);
//        byte[] iv = Arrays.copyOf(encryptedIVAndTextAsBytes, 16);
//
//        byte[] ciphertextByte = Arrays.copyOfRange(encryptedIVAndTextAsBytes, 16,
//                encryptedIVAndTextAsBytes.length);
//        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
//        SecretKeySpec secretKeySpec = new SecretKeySpec(hexStrToByteArray(), ALGORITHM);
//        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, new IvParameterSpec(iv));
//        byte[] decryptedTextBytes = cipher.doFinal(ciphertextByte);
//        log.info("Object Decrypted");
//        return new ObjectMapper().readValue(decryptedTextBytes, tClass);
//    }

    /**
     * @param algoCommonName
     * @param hexString
     * @throws Exception
     */
    private static SecretKeySpec getSecretKeySpecFromHexString(String algoCommonName,String hexString) throws Exception {
        byte [] encodedBytes = hexStrToByteArray(hexString) ;
        return new SecretKeySpec(encodedBytes, algoCommonName);
    }

    /**
     * @param hex
     * @return Byte Array
     */
    private static byte[] hexStrToByteArray(String hex) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream(hex.length() / 2);

        for (int i = 0; i < hex.length(); i += 2) {
            String output = hex.substring(i, i + 2);
            int decimal = Integer.parseInt(output, 16);
            baos.write(decimal);
        }
        return baos.toByteArray();
    }

    /**
     * @param encryptedText
     * @param iv
     * @return Byte Array
     * @throws Exception
     */
    public static byte[] copyIVAndCipher(byte[] encryptedText, byte[] iv) throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(iv);
        byteArrayOutputStream.write(encryptedText);
        return byteArrayOutputStream.toByteArray();
    }
}
