class WordDictionary {

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {

        TrieNode current = root;

        for(int i = 0; i < word.length(); i++){

            int index = word.charAt(i) - 'a';

            if(current.children[index] == null){
                current.children[index] = new TrieNode();
            }

            current = current.children[index];
        }

        current.isEndOfWord = true;
    }

    public boolean search(String word) {
        return dfs(0, word, root);
    }

    private boolean dfs(int index, String word, TrieNode node){

        if(index == word.length()){
            return node.isEndOfWord;
        }

        char ch = word.charAt(index);

        if(ch != '.'){

            int charIndex = ch - 'a';

            if(node.children[charIndex] == null){
                return false;
            }

            return dfs(index + 1, word, node.children[charIndex]);
        }

        for(int i = 0; i < 26; i++){

            if(node.children[i] != null){

                if(dfs(index + 1, word, node.children[i])){
                    return true;
                }
            }
        }

        return false;
    }
}

class TrieNode {

    TrieNode[] children;
    boolean isEndOfWord;

    public TrieNode(){
        children = new TrieNode[26];
        isEndOfWord = false;
    }
}