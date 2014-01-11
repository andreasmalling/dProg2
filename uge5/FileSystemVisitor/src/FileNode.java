public class FileNode implements FileSystemNode {
    private String name;
    private int size;

    public FileNode(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

	public <T> T accept(FileSystemVisitor<T> v) {
		return v.visitFile(this);
	}
}
