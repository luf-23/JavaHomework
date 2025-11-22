package DesiginPatternHomework.Composite;

import java.util.List;

public class Folder implements FileSystemItem{
    private String name;
    private List<FileSystemItem> children;

    public Folder(String name, List<FileSystemItem> children) {
        this.name = name;
        this.children = children;
    }

    @Override
    public void print(String prefix) {
        System.out.println(prefix + "📁 " + name + " (" + getSize() + "B)");
        for (FileSystemItem child : children) {
            child.print(prefix + '\t');
        }
    }

    @Override
    public Long getSize() {
        Long size = 0L;
        for (FileSystemItem child : children) {
            size += child.getSize();
        }
        return size;
    }
}
