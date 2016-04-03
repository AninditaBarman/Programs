import java.util.HashMap;

public class TrieNode {

	private char c;
	private boolean isLeaf;
	private HashMap<Character, TrieNode> children;
	
	public TrieNode()
	{}
	
	public TrieNode(char c)
	{
		this.c= c;
	}
	
	public char getC() {
		return c;
	}
	public void setC(char c) {
		this.c = c;
	}
	public boolean isLeaf() {
		return isLeaf;
	}
	public void setLeaf(boolean isLeaf) {
		this.isLeaf = isLeaf;
	}
	public HashMap<Character, TrieNode> getChildren() {
		return children;
	}
	public void setChildren(HashMap<Character, TrieNode> children) {
		this.children = children;
	}	
}
