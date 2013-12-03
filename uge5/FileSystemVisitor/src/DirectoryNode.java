import java.util.*;

public class DirectoryNode implements FileSystemNode, Iterable<FileSystemNode> {
    private String name;
    private List<FileSystemNode> nodes;

    public DirectoryNode(String name, List<FileSystemNode> nodes) {
        this.name = name;
        this.nodes = nodes;
    }

    public String getName() {
        return name;
    }

    public Iterator<FileSystemNode> iterator() {
        return nodes.iterator();
    }

	public <T> T accept(FileSystemVisitor<T> v) {
		 return v.visitDirectory(this);
	}
}
