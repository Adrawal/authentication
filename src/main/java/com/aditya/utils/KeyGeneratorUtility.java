package com.aditya.utils;

import java.security.KeyPair;
import java.security.KeyPairGenerator;

public class KeyGeneratorUtility {

    public static KeyPair generatRSKey(){

        KeyPair keyPair;
        try{
            KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
            generator.initialize(2048);
            keyPair = generator.generateKeyPair();

        }catch (Exception exp){
throw new IllegalStateException();
        }
        return keyPair;
    }
}
