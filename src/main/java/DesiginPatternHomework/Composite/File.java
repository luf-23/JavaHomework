package DesiginPatternHomework.Composite;

public class File implements FileSystemItem{
    private String name;
    private Long size;
    public File(String name, Long size) {
        this.name = name;
        this.size = size;
    }
    @Override
    public void print(String prefix) {
        System.out.println(prefix + "📄 " + name + " (" + size + "B)");
    }

    @Override
    public Long getSize() {
        return size;
    }
}
