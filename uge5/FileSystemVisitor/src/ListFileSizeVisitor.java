public class ListFileSizeVisitor implements FileSystemVisitor<Void> {
	private static String indent = "";

	@Override
	public Void visitFile(FileNode f) {
		System.out.println(indent + "file " + f.getName() + " of " + f.accept(new SizeVisitor()) + " bytes" );
		return null;
	}

	@Override
	public Void visitDirectory(DirectoryNode d) {
		String oldIndent = indent;
		System.out.println(indent + "directory " + d.getName() + " containing");         // Print name of current dir
		indent += "   ";                                                                 // Increase indent for next level
		for(FileSystemNode n : d) {
			n.accept(new ListFileSizeVisitor());
		}
		indent = oldIndent;                                                              // Decrease indent for current level
		System.out.println(indent + "total " + d.accept(new SizeVisitor()) + " bytes");  // Print size of current dir

		return null;
	}
}
