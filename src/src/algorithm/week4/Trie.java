package algorithm.week4;

public class Trie {

    private Trie[] children;

    private boolean isLeaf;

//    issue 208
    public Trie() {
        this.children = new Trie[26];
        this.isLeaf = false;
    }

    public void insert(String word) {
//        root is this
        var current = this;
        for (int i = 0; i < word.length(); i++) {
            if (current.children[word.charAt(i) - 'a'] == null) {
                current.children[word.charAt(i) - 'a'] = new Trie();
            }
            if (i == word.length() - 1) {
                current.isLeaf = true;
            }
            current = current.children[word.charAt(i) - 'a'];
        }
    }

    public boolean search(String word) {
        Trie current = this;
        for (int i = 0; i < word.length() ; i++) {
            if (current.children[word.charAt(i) - 'a'] == null) {
                return false;
            }
            if (i == word.length() - 1 && !current.isLeaf) {
                return false;
            }
            current = current.children[word.charAt(i) - 'a'];
        }
        return true;
    }

    public boolean startsWith(String prefix) {
        Trie current = this;
        for (int i = 0; i < prefix.length() ; i++) {
            if (current.children[prefix.charAt(i) - 'a'] == null) {
                return false;
            }
            current = current.children[prefix.charAt(i) - 'a'];
        }
        return true;
    }

    public static void main(String[] args) {
        Trie dict = new Trie();
        dict.insert("and");
        dict.insert("ant");
        dict.insert("baby");
        System.out.println(dict.search("baby"));
        System.out.println(dict.search("an"));
        System.out.println(dict.startsWith("an"));
        System.out.println(dict.search("ant"));
        System.out.println(dict.search("ann"));


//        dict.insert("apple");
//        System.out.println(dict.search("apple"));
//        System.out.println(dict.search("app"));
//        System.out.println(dict.startsWith("app"));
//        dict.insert("app");
//        System.out.println(dict.search("app"));
        System.out.println("debug");
    }
}
