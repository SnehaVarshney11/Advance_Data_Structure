package Trie;

public class implementation {
    //Trie Node
    static class TrieNode{
        TrieNode[] children = new TrieNode[26];
        // isEndOfWord is true if the node representsend of a word
        boolean isEndOfWord;

        TrieNode(){
            isEndOfWord = false;
            for(int i = 0; i < 26; i++){
                children[i] = null;
            }
        }
    };
    static TrieNode root;
    //Insertion
    private static void insert(String string){
        int length = string.length();
        int index;
        TrieNode node = root;
        for(int i = 0; i < length; i++){
            index = string.charAt(i) - 'a';
            if(node.children[index] == null){
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        //Mark leaf node as true
        node.isEndOfWord = true;
    }

    //Search
    private static boolean search(String string){
        int length = string.length();
        int index;
        TrieNode node = root;

        for(int i = 0; i < length; i++){
            index = string.charAt(i) - 'a';

            if(node.children[index] == null){
                return false;
            }
        }
        return (node.isEndOfWord);
    }

    // Returns true if root has no children, else false
    private static boolean isEmpty(TrieNode root)
    {
        for (int i = 0; i < 26; i++)
            if (root.children[i] != null)
                return false;
        return true;
    }

    //Delete
    private static TrieNode delete(TrieNode root, String string, int depth){
        if(root == null)
            return null;
        
        if(depth == string.length()){
            if(root.isEndOfWord)
                root.isEndOfWord = false;
            if(isEmpty(root)){
                root = null;
            }
            return root;
        }
        int index = string.charAt(depth) - 'a';
        root.children[index] = delete(root.children[index], string, depth + 1);

        if(isEmpty(root) && root.isEndOfWord == false){
            root = null;
        }
        return root;
    }
    public static void main(String[] args) {
        String input[] = {"the", "a", "there", "answer", "any","by", "bye", "their"};
     
        String output[] = {"Not present in trie", "Present in trie"};
    
        for(int i = 0; i < input.length; i++)
            insert(input[i]);

            if(search("the") == true)
                System.out.println("the --- " + output[1]);
            else 
                System.out.println("the --- " + output[0]);
        
            if(search("these") == true)
                System.out.println("these --- " + output[1]);
            else 
                System.out.println("these --- " + output[0]);

            delete(root, "answer", 0);
            if(search("answer") == true)
                System.out.println("Yes");
            else
                System.out.println("No");

    }

}
