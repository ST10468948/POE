/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import com.mycompany.poem.Message;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author ENGEDZANI
 */
public class MessageTest {
    @Test
    public void testValidMessage() {
        // Test message under 250 characters
        String msg = "Hi Mike, can you join us for dinner tonight";
        assertEquals("Message ready to send.", Message.validateMessage(msg));
    }

    @Test
    public void testTooLongMessage() {
        // Test message longer than 250 characters
        String msg = "a".repeat(260);
        assertTrue(Message.validateMessage(msg).contains("Message exceeds 250 characters by"));
    }

    @Test
    public void testRecipientFormatSuccess() {
        // Valid recipient format
        Message m = new Message(1, "+27718693002", "Hello");
        assertTrue(m.checkRecipientCell());
    }

    @Test
    public void testRecipientFormatFail() {
        // Invalid recipient format
        Message m = new Message(1, "08575975889", "Hello");
        assertFalse(m.checkRecipientCell());
    }

    @Test
    public void testMessageHash() {
        // Ensure hash contains first and last words
        Message m = new Message(0, "+27718693002", "Hi Mike, can you join us for dinner tonight");
        String hash = m.createMessageHash();
        assertTrue(hash.contains("HI"));
        assertTrue(hash.contains("TONIGHT"));
    }

    @Test
    public void testSendOptions() {
        // Test message send/store/disregard outputs
        Message m = new Message(1, "+27718693002", "Test");
        assertEquals("Message successfully sent.", m.sendMessage(1));
        assertEquals("Press 0 to delete message.", m.sendMessage(2));
        assertEquals("Message successfully stored.", m.sendMessage(3));
    }
  
    
}
