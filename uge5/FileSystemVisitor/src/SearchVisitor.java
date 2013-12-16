public class SearchVisitor implements FileSystemVisitor<Void> {
	private String searchKey;
	private static String path = "";

	public SearchVisitor(String searchKey) {
		this.searchKey = searchKey;
	}

	@Override
	public Void visitFile(FileNode f) {
		if(f.getName().contains(searchKey)) {           // If file contains string
		path += f.getName();                            //  append filename to path
			System.out.println(path);                   //  and print out path
		}
		return null;
	}

	@Override
	public Void visitDirectory(DirectoryNode d) {
		String oldPath = "";
		oldPath = path;                                 // "Backup" path
		path += d.getName() + "/";                      // Append dir
		for(FileSystemNode n : d) {
			n.accept(new SearchVisitor(searchKey));
		}
		path = oldPath;                                 // "Restore" path  ~ go one recursive call back
		return null;
	}
}
