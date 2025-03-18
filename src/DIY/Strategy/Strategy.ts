// Strategy.ts

interface EncryptionTool {
    encrypt(data: string): string;
    decrypt(encryptedData: string): string;
  }
  
  class AESEncryption implements EncryptionTool {
    encrypt(data: string): string {
      console.log("Encrypting data with AES...");
      return data + " (encrypted with AES) ";
    }
  
    decrypt(encryptedData: string): string {
      console.log("Decrypting file using AES...");
      return encryptedData.replace(" (encrypted with AES) ", "");
    }
  }
  
  class RSAEncryption implements EncryptionTool {
    encrypt(data: string): string {
      console.log("Encrypting data with RSA...");
      return data + " (encrypted with RSA) ";
    }
  
    decrypt(encryptedData: string): string {
      console.log("Decrypting file using RSA...");
      return encryptedData.replace(" (encrypted with RSA) ", "");
    }
  }
  
  class UnencryptedData {
    private tool: EncryptionTool;
  
    constructor(tool: EncryptionTool) {
      this.tool = tool;
    }
  
    public setEncrypt(tool: EncryptionTool): void {
      this.tool = tool;
    }
  
    public encrypt(data: string): string {
      return this.tool.encrypt(data);
    }
  
    public decrypt(data: string): string {
      return this.tool.decrypt(data);
    }
  }
  
  // main
  (function main() {
    const unencryptedString = "This string is unencrypted.";
    console.log("Unencrypted: " + unencryptedString);
    console.log();
  
    // Encrypted with AES
    let data = new UnencryptedData(new AESEncryption());
    const encryptedWithAES = data.encrypt(unencryptedString);
    console.log("Encrypted with AES: " + encryptedWithAES);
    console.log();
  
    // Decrypted using AES
    const decryptedUsingAES = data.decrypt(encryptedWithAES);
    console.log("Decrypted with AES: " + decryptedUsingAES);
    console.log();
  
    console.log("----------------------------------------------------");
  
    // Encrypted with RSA
    data = new UnencryptedData(new RSAEncryption());
    const encryptedWithRSA = data.encrypt(unencryptedString);
    console.log("Encrypted with RSA: " + encryptedWithRSA);
    console.log();
  
    // Decrypted using RSA
    const decryptedUsingRSA = data.decrypt(encryptedWithRSA);
    console.log("Decrypted with RSA: " + decryptedUsingRSA);
    console.log();
  })();
  