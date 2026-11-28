class Solution {
    class TrieNode{
        TrieNode[] children = new TrieNode[26];
        String word;
    }
    TrieNode root = new TrieNode();
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();

        for(String word: words){
            TrieNode node = root;
            for(char ch : word.toCharArray()){
                int index = ch - 'a';
                if(node.children[index] == null){
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
            }
            node.word = word;
        }
        int rows = board.length;
        int cols = board[0].length;
        for(int i = 0;i< rows;i++){
            for(int j = 0;j<cols;j++) dfs(board, i, j, root, result);
        }
        return result;

        
    }
    private void dfs(char[][] board, int r, int c, TrieNode node, List<String> result){
        if(r<0||c<0||r>=board.length || c>= board[0].length) return;
        if(board[r][c] == '#' ) return;
        char ch = board[r][c];
        int index = ch-'a';
        if(node.children[index] == null) return;

        TrieNode nextNode = node.children[index];

        if(nextNode.word!=null){
            result.add(nextNode.word);
            nextNode.word = null;
        }
        board[r][c] = '#';
        dfs(board, r+1, c, nextNode, result);
        dfs(board, r-1, c, nextNode, result);
        dfs(board, r, c+1, nextNode, result);
        dfs(board, r, c-1, nextNode, result);

        board[r][c] = ch;
    }
}
