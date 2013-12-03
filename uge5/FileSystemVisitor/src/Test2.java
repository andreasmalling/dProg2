import java.util.*;

public class Test2 {
    public static FileSystemNode buildFileTree(java.io.File rootFile) {
        if (rootFile.isDirectory()) {
            List<FileSystemNode> entries = new ArrayList<FileSystemNode>();
            for (java.io.File i : rootFile.listFiles()) {
                if (!i.getName().startsWith(".")) {
                    entries.add(buildFileTree(i));
                }
            }
            return new DirectoryNode(rootFile.getName(), entries);
        } else {
            return new FileNode(rootFile.getName(), (int)(rootFile.length()));
        }
    }
    
    public static void main(String[] args) {
        String rootDirName;
        if (args.length > 0) {
            rootDirName = args[0];
        } else {
            rootDirName = System.getProperty("user.dir"); //Current dir
        }
        FileSystemNode d = buildFileTree(new java.io.File(rootDirName));
        d.accept(new ListFileSizeVisitor());
        //System.out.println("SizeVisitor says size is: " + d.accept(new SizeVisitor()));
        //d.accept(new SearchVisitor("Test"));
    }
}
