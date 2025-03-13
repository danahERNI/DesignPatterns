package DesignPatterns.Behavioural.DIY.Strategy;

interface EncryptionTool{
    String encrypt(String data);
    String decrypt(String encryptedData);
}

class AESEncryption implements EncryptionTool{

    @Override
    public String encrypt(String data) {
        System.out.println("Encrypting data with AES...");
        return data + " (encrypted with AES) ";
    }

    @Override
    public String decrypt(String encryptedData) {
        System.out.println("Decrypting file using AES...");
        return encryptedData.replace(" (encrypted with AES) ", "");
    }

}

class RSAEncryption implements EncryptionTool{

    @Override
    public String encrypt(String data) {
        System.out.println("Encrypting data with RSA...");
        return data + " (encrypted with RSA) ";
    }

    @Override
    public String decrypt(String encryptedData) {
        System.out.println("Decrypting file using RSA...");
        return encryptedData.replace(" (encrypted with RSA)", "");
    }


}

class UnencryptedData{

    private EncryptionTool tool;
    
    public UnencryptedData(EncryptionTool tool) {
        this.tool = tool;
    }

    public void setencrypt(EncryptionTool tool){
        this.tool = tool;
    }
    public String encrypt(String data){
        return tool.encrypt(data);
    }
    
    public String decrypt(String data){
        return tool.decrypt(data);
    }
}

public class Strategy {
    public static void main(String[] args) {
        
        String unencryptedString = "This string is unencrypted.";
        System.out.println("Unencrypted: "+ unencryptedString);
        System.out.println();

        // encrypted with AES
        UnencryptedData data = new UnencryptedData(new AESEncryption());
        String encryptedWithAES = data.encrypt(unencryptedString);
        System.out.println("Encrypted with AES: " + encryptedWithAES);
        System.out.println();

        // decrypted using AES
        String decryptedUsingAES = data.decrypt(encryptedWithAES);
        System.out.println("Decrypted with AES: " + decryptedUsingAES);
        System.out.println();

        System.out.println("----------------------------------------------------");

        // encrypted with RSA
        data = new UnencryptedData(new RSAEncryption());
        String encryptedWithRSA = data.encrypt(unencryptedString);
        System.out.println("Encrypted with RSA: " + encryptedWithRSA);
        System.out.println();

        // decrypted using RSA
        String decryptedUsingRSA = data.decrypt(encryptedWithRSA);
        System.out.println("Decrypted with RSA: " + decryptedUsingRSA);
        System.out.println();
        
    }

}
