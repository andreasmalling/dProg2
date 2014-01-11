public interface FileSystemNode {
	public <T> T accept(FileSystemVisitor<T> v);
}
