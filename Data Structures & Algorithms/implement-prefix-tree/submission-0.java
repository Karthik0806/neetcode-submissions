class PrefixTree {
    Node root;
    public PrefixTree() {
    root = new Node();
    }

    public void insert(String word) {
        Node temp = root;
        for(int i = 0;i<word.length();i++){
            int index = word.charAt(i) - 'a';
            if(temp.links[index] == null){
                temp.links[index] = new Node();

            }

            temp = temp.links[index];
        }
        temp.flag = true;
    }

    public boolean search(String word) {
        Node temp = root;
        for(int i = 0;i<word.length();i++){
            int index = word.charAt(i) - 'a';
            if(temp.links[index] == null) return false;
            temp = temp.links[index];
        }
        return temp.flag;
    }

    public boolean startsWith(String prefix) {
        Node temp = root;
        for(int i = 0;i<prefix.length();i++){
            int index = prefix.charAt(i) - 'a';
            if(temp.links[index] == null) return false;
            temp = temp.links[index];
        }
        return true;
    }
}
class Node{
    Node[] links = new Node[26];
    boolean flag = false;
}
