package Plan.Decorator;

public class Decorator {
    public static void main(String[] args) {
        storeCreditCard(new EncryptedCloudStream(new CompressedCloudStream(new CloudStream())));
        
    }
    public static void storeCreditCard(Stream stream){
        stream.write("12312312-213-123");
    }
}
class CloudStream implements Stream{
    public void write(String data){
        System.out.println("Storing " + data);
    }
}
class EncryptedCloudStream implements Stream{
    private Stream stream;

    public EncryptedCloudStream(Stream stream) {
        this.stream = stream;
    }
    @Override
    public void write(String data) {
        var encrypted = encrypt(data);
        stream.write(encrypted);
    }
    private String encrypt(String data){
        return "!@)!(&@)(!@())!@#)@$**$!(@#)";
    }
}
class CompressedCloudStream implements Stream{
    private Stream stream;

    public CompressedCloudStream(Stream stream) {
        this.stream = stream;
    }

    @Override
    public void write(String data) {
        var compressed = compress(data);
        stream.write(compressed);
    }
    private String compress(String data){
        return data.substring(0,5);
    }

}

interface Stream{
    void write(String data);
}