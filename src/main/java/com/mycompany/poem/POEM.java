/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poem;

/**
 *
 * @author ENGEDZANI
 * OpenAI. (2023). ChatGPT (Mar 14 version) [Large language model]
 */
import java.util.*;
import javax.swing.*;

public class POEM {

    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
        Login login = new Login();

        // === Registration and Login ===
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phone = scanner.nextLine();

        String regMessage = login.registerUser(username, password, phone);
        System.out.println(regMessage);
        if (!regMessage.equals("User successfully registered.")) return;

        // Prompt for login again
        System.out.print("Login again.\nUsername: ");
        String u = scanner.nextLine();
        System.out.print("Password: ");
        String p = scanner.nextLine();
        if (!login.loginUser(u, p)) {
            System.out.println("Login failed.");
            return;
        }

        System.out.println("Welcome to QuickChat.");
        System.out.print("How many messages to send? ");
        int num = Integer.parseInt(scanner.nextLine());

        int sentCount = 0;

        // Loop to process each message
        for (int i = 0; i < num; i++) {
            System.out.println("\nMenu:\n1) Send Message\n2) Show Recently Sent (Coming Soon)\n3) Quit");
            int choice = Integer.parseInt(scanner.nextLine());

            if (choice == 3) break;
            if (choice != 1) {
                System.out.println("Coming Soon.");
                continue;
            }

            // Collect message details
            System.out.print("Enter recipient number: ");
            String recipient = scanner.nextLine();
            System.out.print("Enter message (max 250 characters): ");
            String msg = scanner.nextLine();

            System.out.println(Message.validateMessage(msg));
            if (msg.length() > 250) continue;

            // Create message object
            Message m = new Message(i + 1, recipient, msg);

            System.out.println("Options: 1) Send  2) Disregard  3) Store");
            int opt = Integer.parseInt(scanner.nextLine());
            String response = m.sendMessage(opt);
            if (opt == 1) sentCount++;

            JOptionPane.showMessageDialog(null, m.printMessage() + "\nStatus: " + response);
        }

        // Show total sent
        System.out.println("Total messages sent: " + sentCount);
    }

}
