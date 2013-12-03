public class SearchVisitor implements FileSystemVisitor<Void> {
	String searchKey;
	String path = "";

	public SearchVisitor(String searchKey) {
		this.searchKey = searchKey;
	}

	@Override
	public Void visitFile(FileNode f) {
		if(f.getName().contains(searchKey)) {           // If file contains string
		path += f.getName();                            //      - append filename
			System.out.println(path);                   //      - Print out path
		}
		return null;
	}

	@Override
	public Void visitDirectory(DirectoryNode d) {
		String oldPath = "";
		for(FileSystemNode f : d) {
			if( f instanceof DirectoryNode) {
				oldPath = path;
				path += d.getName() + "/";
				visitDirectory( (DirectoryNode) f );
				path = oldPath;
			} else if( f instanceof FileNode ) {
				oldPath = path;
				visitFile( (FileNode) f );
				path = oldPath;
			}
		}
		return null;
	}
}
