package DesiginPatternHomework.Composite;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        File file1 = new File("file1.txt", 128L);
        File file2 = new File("file2.txt", 256L);
        File file3 = new File("file3.txt", 8L);
        Folder emptyFolder = new Folder("emptyFolder", List.of());
        List<FileSystemItem> children1 = List.of(file1, file2, file3, emptyFolder);
        Folder folder1 = new Folder("folder1", children1);
        File file4 = new File("file4.txt", 512L);
        File file5 = new File("file5.txt", 8L);
        List<FileSystemItem> children2 = List.of(file4, file5);
        Folder folder2 = new Folder("folder2", children2);
        File file6 = new File("file6.txt", 1L);
        List<FileSystemItem> children3 = List.of(folder1, folder2, file6);
        Folder folder3 = new Folder("folder3", children3);
        folder3.print("");
    }
}
