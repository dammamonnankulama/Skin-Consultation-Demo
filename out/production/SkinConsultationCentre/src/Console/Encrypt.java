package Console;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Encrypt {

    private static int key = 6;

    //---------------------------------------------------------
    // Encrypting a text message
    //---------------------------------------------------------
    public String encryptData(String str) {

        String x = "";

        char[] chars = str.toCharArray();

        for (char c : chars) {
            c += key;
            x += c;
        }

        return x;
    }

    //---------------------------------------------------------
    // Decrypting a text message
    //---------------------------------------------------------
    public String decryptData(String str) {

        String x = "";
        char[] chars = str.toCharArray();

        for (char c : chars) {
            c -= key;
            x += c;
        }

        return x;
    }

    //---------------------------------------------------------
    // Image Encryption and Decryption
    //---------------------------------------------------------
    public void EncryptDecryptImage(String path) {

        int i = 0;

        try {
            FileInputStream fis = new FileInputStream(path);

            //Convert into byte array
            byte data[] = new byte[fis.available()];

            fis.read(data);
            for (byte b : data) {
                data[i] = (byte)(b ^ key);
                i++;
            }

            // Opening a file for writing purpose
            FileOutputStream fos = new FileOutputStream(path);

            // Writing new byte array value to image which
            fos.write(data);

            // Closing file
            fos.close();
            fis.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

}