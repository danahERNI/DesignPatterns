package DIY.Composite;

import java.util.ArrayList;
import java.util.List;

public class Composite {
    public static void main(String[] args) {
        var folder = new Folder("Personal");
        
        File sample = new File("accounts.txt");
        File sample2 = new File("notes.txt");
        File sample3 = new File("todolist.txt");

        folder.add(sample);
        folder.add(sample2);

        var folder2 = new Folder("Chores");
        folder.add(folder2);
        folder2.add(sample3);

        System.out.println("=== FOLDER STRUCTURE ===");
        folder.list();

    }

}
interface Component{
    void add(Component item);
    void remove(Component item);
    void delete();
    void clear();
    void list(String indent);
    default void list(){
        list(" ");
    }
    String toString();
}
class Folder implements Component{
    private String folderName;

    public Folder(String folderName) {
        this.folderName = folderName;
        System.out.println("=== FOLDER CREATED ===");
        System.out.println("Created " + folderName + " folder.\n");
    }

    private List<Component> components = new ArrayList<>();

    @Override
    public void add(Component item) {
        components.add(item);
        System.out.println("=== MOVED ===");
        System.out.println("Added " + item + " to " + folderName + " folder .\n");
    }

    @Override
    public void remove(Component item) {
        components.remove(item);
        System.out.println("=== REMOVED ===");
        System.out.println("Removed " + item + " from " + folderName + " folder.\n");

    }

    @Override
    public void delete() {
        System.out.println("=== DELETING COMPONENT " + folderName + " FOLDER... ===");
        clear();
        System.out.println(folderName + " folder has been deleted.\n");

    }

    @Override
    public void clear() {
        for (var component : components){
            component.delete();
            System.out.println("Deleted " + component + " from " + folderName + " folder.\n");
        }
        components.clear();

    }

    @Override
    public void list(String indent) {
        System.out.println(indent + " " + folderName);
        for (var component : components){
            component.list(indent + "  ");
        }

    }

    @Override
    public String toString() {
        return folderName;
    }
        
    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }
    
}
class File implements Component{
    private String fileName;
    
    public File(String fileName) {
        this.fileName = fileName;
        System.out.println("=== FILE CREATED ===");
        System.out.println(fileName + " was created.\n");
    }
    
    @Override
    public void add(Component item) {
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }
    
    @Override
    public void remove(Component item) {
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }
        
    @Override
    public void delete() {
        System.out.println(fileName + " has been deleted.");

    }
    
    @Override
    public void clear() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'clear'");
    }
    
    @Override
    public void list(String indent) {
        System.out.println(indent + "- " + fileName);
    }
    @Override
    public String toString() {
        return fileName;
    }

    public String getFileName() {
        return fileName;
    }
    
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    
}
