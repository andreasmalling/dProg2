public class SizeVisitor implements FileSystemVisitor<Integer>{
	@Override
	public Integer visitFile(FileNode f) {
		return f.getSize();
	}

	@Override
	public Integer visitDirectory(DirectoryNode d) {
		int total = 0;
		for(FileSystemNode f : d) {
			if( f instanceof DirectoryNode)
				total += visitDirectory( (DirectoryNode) f );
			else if( f instanceof FileNode )
				total += visitFile( (FileNode) f );
		}

		return total;
	}
}
