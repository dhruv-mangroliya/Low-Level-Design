package org.example.URLShortener;


public class BitlyEncoder {
    private static volatile BitlyEncoder instance = null;

    private static final String BASE62 =
            "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private BitlyEncoder(){}

    public static synchronized BitlyEncoder getInstance(){
        if(instance == null){
            return instance = new BitlyEncoder();
        }
        return instance;
    }


    public String encodeBase62(int id) {
        if (id == 0) return "0";

        StringBuilder sb = new StringBuilder();

        while (id > 0) {
            int rem = id % 62;
            sb.append(BASE62.charAt(rem));
            id /= 62;
        }

        return sb.reverse().toString();
    }
}
