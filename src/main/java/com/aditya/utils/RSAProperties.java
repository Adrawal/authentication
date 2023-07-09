package com.aditya.utils;

import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;

import java.security.KeyPair;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

@Component
public class RSAProperties {
 private RSAPublicKey rsaPublicKey;
 private RSAPrivateKey rsaPrivateKey;

 public RSAProperties(){
     KeyPair keypair = KeyGeneratorUtility.generatRSKey();
     this.rsaPublicKey = (RSAPublicKey) keypair.getPublic();
     this.rsaPrivateKey = (RSAPrivateKey) keypair.getPrivate();
 }

    public RSAPublicKey getRsaPublicKey() {
        return rsaPublicKey;
    }

    public void setRsaPublicKey(RSAPublicKey rsaPublicKey) {
        this.rsaPublicKey = rsaPublicKey;
    }

    public RSAPrivateKey getRsaPrivateKey() {
        return rsaPrivateKey;
    }

    public void setRsaPrivateKey(RSAPrivateKey rsaPrivateKey) {
        this.rsaPrivateKey = rsaPrivateKey;
    }
}
