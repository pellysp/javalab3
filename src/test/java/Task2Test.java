import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task2Test {

    @Test
    void cipher() {
        String textToEncrypt = "Test gotcha";
        String exceptedEncryptText = "Tfut iouehb";
        String hash = "abc";
        System.out.println("Text to encrypt: " + textToEncrypt + " with hash: " + hash + "\n");
        String encryptedText = Task2.cipher(textToEncrypt, hash, true);
        System.out.println("Encrypted text: " + encryptedText);
        System.out.print("Checking equals...");
        assertEquals(encryptedText, exceptedEncryptText);
        System.out.println("Equals!\n");

        String decryptText = Task2.cipher(encryptedText, hash, false);
        System.out.println("Decrypt text: " + decryptText);
        System.out.print("Checking equals...");
        assertEquals(decryptText, textToEncrypt);
        System.out.println("Equals!");
    }
}