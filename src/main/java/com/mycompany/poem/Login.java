/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poem;

/**
 *
 * @author ENGEDZANI
 * OpenAI. (2023). ChatGPT (Mar 14 version) [Large language model]
 */
public class Login {
    
    private String username;
    private String password;
    private String phoneNumber;
    private String firstName = "Sedzani"; 
    private String lastName = "Sikhwari"; 

    //Checks if the username contains an underscore and is no more than 5 characters long.
     
    public boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    /*
     * Checks if the password meets complexity requirements:
     * - At least 8 characters
     * - At least one uppercase letter
     * - At least one number
     * - At least one special character
     */
    public boolean checkPasswordComplexity(String password) {
        return password.matches("^(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*(),.?\":{}|<>]).{8,}$");
    }

    /*
     * Checks if the phone number includes the international code (+27)
     * and is followed by 9 digits.
     */
    public boolean checkCellPhoneNumber(String phoneNumber) {
        // AI-generated regex: validates international format for South African numbers
        //OpenAI. (2023). ChatGPT (Mar 14 version) [Large language model]
        return phoneNumber.matches("^\\+\\d{1,3}\\d{9}$"); 
    }

    /*
     * Registers the user if all fields pass validation.
     */
    public String registerUser(String username, String password, String phoneNumber) {
        if (!checkUserName(username)) {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.";
        }

        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }

        if (!checkCellPhoneNumber(phoneNumber)) {
            return "Cell phone number incorrectly formatted or does not contain international code.";
        }

        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;

        return "User successfully registered.";
    }

    //Validates login credentials.
        public boolean loginUser(String inputUsername, String inputPassword) {
        return inputUsername.equals(this.username) && inputPassword.equals(this.password);
    }

    //Returns a user-friendly message based on login status.
         public String returnLoginStatus(String inputUsername, String inputPassword) {
        if (loginUser(inputUsername, inputPassword)) {
            return "Welcome " + firstName + ", " + lastName + " it is great to see you again."; //TRUE
        } else {
            return "Username or password incorrect, please try again."; //FALSE
        }
    }

    
}
