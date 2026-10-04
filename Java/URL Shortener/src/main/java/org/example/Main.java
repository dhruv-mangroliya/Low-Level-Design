package org.example;

import org.example.URLShortener.BitlyShortener;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        BitlyShortener bitlyShortener = BitlyShortener.getInstance();
        String google = "www.google.com/id=0001/message=hello";
        String shortGoogle = bitlyShortener.shortenURL(google);
        System.out.println(shortGoogle);

        String chatGpt = "https://chatgpt.com/c/692018d7-a458-8322-a2d9-20929319749d";
        String shortGpt = bitlyShortener.shortenURL(chatGpt);
        System.out.println(shortGpt);

        String originalGoogle = bitlyShortener.redirectUrl(shortGoogle);
        System.out.println(originalGoogle);

        Runnable task1 = () -> {
            String facebook = "www.facebook.com/id=000qefd1/message=heedallo";
            String shortFacebook = bitlyShortener.shortenURL(facebook);
            System.out.println(Thread.currentThread().getName() + " → " + shortFacebook);
        };

        Runnable task2 = () -> {
            String whatsapp = "https://whatsapp.com/c/69201daedaecda8d7-a458awdae-8322-a2d9-20929319749d";
            String shortWhatsapp = bitlyShortener.shortenURL(whatsapp);
            System.out.println(Thread.currentThread().getName() + " → " + shortWhatsapp);
        };

        Thread t1 = new Thread(task1, "Thread-1");
        Thread t2 = new Thread(task2, "Thread-2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}