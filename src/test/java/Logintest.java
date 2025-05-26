/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import com.mycompany.poem.Login;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author ENGEDZANI
 */
public class Logintest {
                
    @Test
    public void testUsernameIncorrectFormat() {
        Login login = new Login();
        assertFalse(login.checkUserName("kyle!!!!!!!"));
    }
    
    @Test
    public void testUsernameCorrectFormat() {
        Login login = new Login();
        assertTrue(login.checkUserName("kyl_1"));
    }
        
    @Test
    public void testPasswordCorrectFormat() {
        Login login = new Login();
        assertTrue(login.checkPasswordComplexity("Ch&&sec@ke99!"));    
    }
    
    @Test
    public void testPasswordIncorrectFormat() {
        Login login = new Login();
        assertFalse(login.checkPasswordComplexity("password"));
    }
    @Test
    public void testCellPhoneCorrectFormat() {
        Login login = new Login();
        assertTrue(login.checkCellPhoneNumber("+27838968976"));
    }
    
    @Test
    public void testLoginSuccess() {
        Login login = new Login();
        login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976");
        assertTrue(login.loginUser("kyl_1", "Ch&&sec@ke99!"));
    }
    
     @Test
    public void testLoginFail() {
        Login login = new Login();
        login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976");
        assertFalse(login.loginUser("wrong", "pass"));
    }
    
    @Test
    public void testReturnLoginStatusSuccess() {
        Login login = new Login();
        login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976");
        assertEquals("Welcome Mthobisi, Nyembe it is great to see you again.",
                login.returnLoginStatus("kyl_1", "Ch&&sec@ke99!"));
    }
    
    @Test
    public void testReturnLoginStatusFail() {
        Login login = new Login();
        login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976");
        assertEquals("Username or password incorrect, please try again.",
                login.returnLoginStatus("wrong", "pass"));
    }
}
