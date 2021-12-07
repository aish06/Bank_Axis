package com.paytm.bank.axis.ecryptdecrypt;

import com.paytm.bank.dto.axis.TransferPaymentRequestBody;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AESEncryptionDecryptionUtilsTest {


        @Test
        void contextLoads1() throws Exception {
            AESEncryptionDecryptionUtils a1 = new AESEncryptionDecryptionUtils();
            String s1 = "jhI5nAdyb1qOEjmcB3JvWlSSjVRpeop0cdiGPDEbn0dp6WWslvPCpVCuoDYAejELLhKzTpGR5T7H\n" +
                    "8d9f3F4R0LUkBEmzPGue4urnYaLdJ9wuQjnLDxVMjLgf/FtB2Ra16ogs7Lf1QjBIac/vQIOTR+Yi\n" +
                    "nW54pf89onDsWkEGX+z/G7uEXXOb+dKWTi/PPVwUozkdjhXoo6ZsN6D419E8jEwyPrpidvHv00Sm\n" +
                    "p2uSiI3DUT4PznuK9hJ7dzCJeYWGO+xRXvOP4w7FUiF0f3h3Q8X8G7Xjh/KH76NGWYL2BF9wXsV7\n" +
                    "hcOo5lqbaLt91yg6phi4Sf+uDKLMnvHvlfgt3U8FFC9ik9JYCAxao6PkoVYX17DEBj+7JhHuj78e\n" +
                    "60DU+GZ166sINmO3UGCroQqjUQX/n/e9mZLEfynFU5f6KVgNxmeEkEkohzOf6pHtQTj6czpY59CW\n" +
                    "c+Bxkhref4rXLUImKhRE+jicyGGnAzyk5LANnG5SgqwlvsuPtsZ08My15z7qGncNFVJzOCMvbJaZ\n" +
                    "KXC/XwnmXd7FANIGTyYDF5PrdhnOpmBGuuqFoxnexQFeYDpQt7PrkE5o5KYw9sje63RdgEUVGH2I\n" +
                    "hxMWUGNE8rDun2m3xKG23S1aYtfw3u4BU3+A10nxQnJnFxHJFQAhZAQQSHVUUXr85T7vWAML28iz\n" +
                    "lu1Z/PXLbbcfHv5TLsSO8CSAaW/ezxXkVeFfjCLt22GBzclNvGvPL4dBCukkCQvJMVUiRfgg1UNx\n" +
                    "mrOtLSEKWhYSVcoFZgb3/JaCgfu5YfgmivHF26ZJF7//EnnxczvAuVf8ij5gZFX3Pe02rCkOw9Qu\n" +
                    "HHWtGrA+t4rkhLbc5hDLyg7Kw3/qsu4t/DoQkRvIPiY6oqpuPgg9d9iRU49Oy1ARAUNXKg2mmKQs\n" +
                    "wIxhh5A8quWQkYRLPJ8Zy+reRF1G5Rr6pbUkH22d5rXA1TLtHJPS1hHIoj6qcmIg+C9FKe6POCjO\n" +
                    "OVNux+5885+RMR6T5BhT5B4U+Zk6uurvQw8+UHDAVijUKmpUdFOx6ncrFg==";
            TransferPaymentRequestBody t = a1.aes128Decrypt(s1, TransferPaymentRequestBody.class);
            System.out.println(t);
        }

        @Test
        void contextLoads2() throws Exception {
            AESEncryptionDecryptionUtils a1 = new AESEncryptionDecryptionUtils();
            TransferPaymentRequestBody transferPaymentRequestBody = new TransferPaymentRequestBody();
            transferPaymentRequestBody.setChecksum("67");
            transferPaymentRequestBody.setCorpCode("sa");
            transferPaymentRequestBody.setChannelId("sak");
            String s1 = a1.aes128Encrypt(transferPaymentRequestBody);
            System.out.println(s1);
            TransferPaymentRequestBody t = a1.aes128Decrypt(s1, TransferPaymentRequestBody.class);
            System.out.println(t);
        }

        @Test
        void contextLoads5() throws Exception {
            String apiencryption = "jhI5nAdyb1qOEjmcB3JvWlSSjVRpeop0cdiGPDEbn0dp6WWslvPCpVCuoDYAejEL5O91SWim8+Lb\n" +
                    "X5tDaavmNJSMm2bigEr5rwFzHojvjthbCZpptdPgNhn0ZYAI3lpk";

            String generatedKey = "jhI5nAdyb1qOEjmcB3JvWoUHjvp8k0VIMpa76E2fEO1GvGr3woACKn/LzB9FhVO5LfU/6c/RnIW7\n" +
                    "PNvMDKeDvUWWPMfv66+Dt/hXfjMT3CQ=";
                    System.out.println(apiencryption.equals(generatedKey));
        }

        @Test
        void contextLoads() throws Exception {
            AESEncryptionDecryptionUtils a1 = new AESEncryptionDecryptionUtils();
            List<TestData1> y = new ArrayList<>();
            y.add(new TestData1("56","34"));
            y.add(new TestData1("tr","ww"));
            TestData t1 = new TestData("12","123","1234", y);
            String s1 =a1.aes128Encrypt(t1);
            System.out.println("encrypted :" + s1);
            System.out.println(t1);
            //String s1 = "jhI5nAdyb1qOEjmcB3JvWho03W4eE37ddOfl0ZzbkRWKN8OyvNpyYLZkjqmYnuSNgNjHUVSOOrCorOSm0mMCAGM8xzr5Pc1exY6wOfbElrU=";
            TestData t2 = a1.aes128Decrypt(s1, TestData.class);
            System.out.println(t2);
            System.out.println(t2.getB());
        }
}