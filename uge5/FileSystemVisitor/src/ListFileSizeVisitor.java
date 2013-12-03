public class ListFileSizeVisitor implements FileSystemVisitor<Void> {
	String indent = "";

	@Override
	public Void visitFile(FileNode f) {
		System.out.println( indent + "file " + f.getName() + " of " + f.accept(new SizeVisitor()) + " bytes" );
		return null;
	}

	@Override
	public Void visitDirectory(DirectoryNode d) {
		String s = "";
		for(FileSystemNode f : d) {
			String oldIndent = indent;
			if( f instanceof DirectoryNode) {
				indent += "   ";
				System.out.println(indent + "directory " + d.getName() + " containing");
				visitDirectory( (DirectoryNode) f );
				indent = oldIndent;
			} else if( f instanceof FileNode ) {
				indent += "   ";
				visitFile( (FileNode) f );
				indent = oldIndent;
			}
		}

		return null;
	}
}
