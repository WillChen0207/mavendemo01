package com.testsql.pojo;

import lombok.Data;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
@Data
public class Cipher {

    public static String pswoutput;

    public String getPswoutput(String pswinput) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        md.update(pswinput.getBytes(StandardCharsets.UTF_8));
        byte[] res = md.digest();
        pswoutput = new BigInteger(1,res).toString(16);
        return pswoutput;
    }

}
