package Trie;


public class insertAndsearch {
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
    }
}
