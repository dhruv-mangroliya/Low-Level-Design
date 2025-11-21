package org.example.URLShortener;

import lombok.Getter;
import lombok.Setter;
import org.example.Exceptions.NoValidLongURL;

import java.util.HashMap;
import java.util.Map;


@Setter
@Getter
public class BitlyShortener implements URLShortener{
    private static volatile BitlyShortener  instance = null;
    private Map<String, String> shortToLong = new HashMap<>();
    private Map<String, String> longToShort = new HashMap<>();
    private BitlyEncoder bitlyEncoder = BitlyEncoder.getInstance();
    private int idCounter = 100000;

    private BitlyShortener(){}

    public static synchronized BitlyShortener getInstance(){
        if(instance == null){
            return instance = new BitlyShortener();
        }
        return instance;
    }

    private synchronized int fetchAndIncrement() {
        return idCounter++;   // atomic because method is synchronized
    }

    private String encodeBase62(int id) {
        return bitlyEncoder.encodeBase62(id);
    }

    @Override
    public String shortenURL(String longUrl) {
        if(longToShort.get(longUrl) != null){
            return longToShort.get(longUrl);
        }

        int id = fetchAndIncrement();
        String shortUrl = "www.bitly.com/" + encodeBase62(id);
        shortToLong.put(shortUrl, longUrl);
        longToShort.put(longUrl, shortUrl);
        return shortUrl;
    }

    @Override
    public String redirectUrl(String shortUrl) {
        String longUrl = shortToLong.get(shortUrl);
        if(longUrl == null){
            throw new NoValidLongURL();
        }
        return longUrl;
    }
}
