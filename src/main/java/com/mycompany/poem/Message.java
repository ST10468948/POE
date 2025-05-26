/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poem;

import java.util.Random;

/**
 *
 * @author ENGEDZANI
 * OpenAI. (2023). ChatGPT (Mar 14 version) [Large language model]
 */
public class Message {
    
    private String messageID;
    private int messageCount;
    private String recipient;
    private String messageText;

    // Constructor to initialize message properties
    public Message(int count, String recipient, String messageText) {
        this.messageID = generateMessageID();
        this.messageCount = count;
        this.recipient = recipient;
        this.messageText = messageText;
    }

    // Generates a unique 10-digit message ID
    private String generateMessageID() {
        Random rand = new Random();
        long id = 1000000000L + (long)(rand.nextDouble() * 8999999999L);
        return Long.toString(id);
    }

    public boolean checkMessageID() {
        return messageID.length() == 10;
    }

    // Validates recipient phone format (+ followed by digits)
    public boolean checkRecipientCell() {
        return recipient.matches("^\\+\\d{1,3}\\d{7,9}$");
    }

    // Creates a custom hash string from message details
    public String createMessageHash() {
        String[] words = messageText.trim().split("\\s+");
        String firstWord = words.length > 0 ? words[0] : "";
        String lastWord = words.length > 1 ? words[words.length - 1] : firstWord;
        return messageID.substring(0, 2) + ":" + messageCount + ":" +
               firstWord.toUpperCase() + lastWord.toUpperCase();
    }

    // Responds based on user’s send/store/discard input
    public String sendMessage(int option) {
        switch (option) {
            case 1: return "Message successfully sent.";
            case 2: return "Press 0 to delete message.";
            case 3: return "Message successfully stored.";
            default: return "Invalid Option";
        }
    }

    // Displays all message details
    public String printMessage() {
        return "Message ID: " + messageID +
               "\nMessage Hash: " + createMessageHash() +
               "\nRecipient: " + recipient +
               "\nMessage: " + messageText;
    }

    public int returnTotalMessages() {
        return messageCount;
    }

    // Formats message into a JSON string
    public String storeMessageToJson() {
        return String.format("{\"id\":\"%s\",\"recipient\":\"%s\",\"text\":\"%s\"}",
                messageID, recipient, messageText);
    }

    // Static method to validate message length
    public static String validateMessage(String messageText) {
        if (messageText.length() > 250) {
            int overBy = messageText.length() - 250;
            return "Message exceeds 250 characters by " + overBy + ", please reduce size.";
        }
        return "Message ready to send.";
    }

    
}
