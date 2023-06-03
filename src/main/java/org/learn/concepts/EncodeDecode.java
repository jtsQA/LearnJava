package org.learn.concepts;

import com.google.common.io.BaseEncoding;

import java.util.Base64;

public class EncodeDecode {

    public static void main(String[] args) {

        String data = "1234";

        String encodedData = encode(data);
        System.out.println("Encoded data = " + encodedData);

        String decodedData = decode(encodedData);
        System.out.println("Decoded data = " + decodedData);

    }


    private static String encodeData(String data) {
        return BaseEncoding.base32Hex().encode(data.getBytes());
    }

    public static String decodeData(String data) {
        byte[] decodedBytes = BaseEncoding.base32Hex().decode(data);
        return new String(decodedBytes);
    }

    private static String encode(String data) {
        return Base64.getEncoder().encodeToString(data.getBytes());
    }

    private static String decode(String data) {
        byte[] decodedBytes = Base64.getDecoder().decode(data);
        return new String(decodedBytes);
    }
}
