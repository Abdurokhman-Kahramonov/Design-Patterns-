package designPatterns.structural.composite;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CompositeExample {
    public static void main(String[] args) {
        File f1 = new File("file 1");
        File f2 = new File("file 2");
        Folder root = new Folder(" /");
        Folder games = new Folder("games");

        root.add(games);
        games.add(f1);
        games.add(f2);

        root.showDetails();

    }
}
interface FileSystemItem{
    void showDetails();
}

class File implements FileSystemItem{
    private String name;

    public File(String name){
        this.name = name;
    }
    @Override
    public void showDetails() {
        System.out.println(this.name);
    }
}
class Folder implements FileSystemItem{
    private String name;
    private List<FileSystemItem> fileSystemItemList = new ArrayList<>();

    public Folder(String name){
        this.name = name;
    }

    public void add(FileSystemItem fio){
        fileSystemItemList.add(fio);
    }

    @Override
    public void showDetails() {
        System.out.println("This name:" + this.name);
        for(FileSystemItem i : fileSystemItemList){
            i.showDetails();
        }
    }

}




