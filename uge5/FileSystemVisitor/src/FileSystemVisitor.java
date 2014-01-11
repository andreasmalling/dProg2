public interface FileSystemVisitor<T> {
    public T visitFile(FileNode f);

    public T visitDirectory(DirectoryNode d);
}
