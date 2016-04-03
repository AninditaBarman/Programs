import java.util.HashMap;

/*
Trie is a rooted tree. Each path down from the root contains one or more words. 
A node(called TrieNode) contains: one character, a boolean depicting if or not it is the end of the word, and, a hashmap of <Character,TrieNode> that stored all it's children.
Children here means succeeding characters
*/ 

public class Trie {

	public boolean exists(TrieNode root, String word)//checks if word exists in the trie rooted at root
	{
		if(word!=null && (word=word.trim()).length()!=0)
		{
			TrieNode node= root;
			char c;
			int i;
			for(i=0; i<word.length();i++)
			{
				c= word.charAt(i);
				if(node.getChildren().containsKey(c))
					node= node.getChildren().get(c);
				else
					return false;
			}
			if(i==word.length()&& node.isLeaf())
				return true;			
		}
		return false;
	}

	public void insert(TrieNode root, String word)
	{
		if(word!=null && (word=word.trim()).length()!=0)
		{
			char c;
			TrieNode node= root;
			for(int i=0; i<word.length(); i++)
			{
				c=word.charAt(i);
				if(node.getChildren()!=null && node.getChildren().containsKey(c))
				{
					node= node.getChildren().get(c);
					if(i==word.length()-1)
					{
						if(node.isLeaf())
							System.out.println("word "+word+" already exists");
						else
						{
							node.setLeaf(true);
							System.out.println("word "+word+" successfully inserted");
						}							
					}
				}
				else
				{
					HashMap<Character, TrieNode> children= new HashMap<Character, TrieNode>();
					TrieNode n= new TrieNode(c);
					children.put(c, n);
					node.setChildren(children);					
					node= node.getChildren().get(c);
					if(i==word.length()-1)
					{
						node.setLeaf(true);
						System.out.println("Word "+word+" successfully inserted.");
					}
						
				}				
			}
		}
	}

	public static void main(String args[])
	{	
		Trie t= new Trie();

		TrieNode root= new TrieNode();

		t.insert(root, "job");
		t.insert(root, "jobseeker");
		t.insert(root, "jo");
		t.insert(root, "jobs");
		t.insert(root, "jobs");
		
		System.out.println("jo exists: "+t.exists(root, "jo"));
		System.out.println("joanna exists: "+t.exists(root, "joanna"));
		System.out.println("j exists: "+t.exists(root, "j"));
		System.out.println(" exists: "+t.exists(root, "  "));
	}
}
