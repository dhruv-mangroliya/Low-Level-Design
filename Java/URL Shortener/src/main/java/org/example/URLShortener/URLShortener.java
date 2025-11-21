package org.example.URLShortener;

public interface URLShortener {
    public String shortenURL(String longUrl);
    public String redirectUrl(String shortUrl);
}
