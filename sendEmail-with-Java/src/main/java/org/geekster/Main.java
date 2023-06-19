package org.geekster;


public class Main {
    public static void main(String[] args) {

        System.out.println("Starting to send Mail");

        MailHandler mailHandler = new MailHandler();
        mailHandler.sendMail();

    }
}