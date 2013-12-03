import java.util.*;

public class Test1 {
    public static void main(String[] args) {
        FileSystemNode d1,d2,d3,d4;
        ArrayList<FileSystemNode> l1,l2;
        d1 = new FileNode("opg87",120);
        assert d1.accept(new SizeVisitor()) == 120;
        d2 = new FileNode("opg14",125);
        l1 = new ArrayList<FileSystemNode>();
        l1.add(d1); l1.add(d2);
        d3 = new DirectoryNode("obl",l1);
        assert d3.accept(new SizeVisitor()) == 245;
        d4 = new DirectoryNode("B-opgaver",new ArrayList<FileSystemNode>());
        assert d4.accept(new SizeVisitor()) == 0;
        l2 = new ArrayList<FileSystemNode>();
        l2.add(d3); l2.add(d4);
        d3 = new DirectoryNode("dprog2",l2);

        //d3.accept(new ListFileSizeVisitor());
        //d3.accept(new SearchVisitor("opg"));

        try {
            assert false;
            System.out.println("Please enable assertions!");
        } catch (AssertionError e) {
            System.out.println("Success!");
        }
    }
}
