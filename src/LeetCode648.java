import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode648 {
    public String replaceWords(List<String> dict, String sentence) {
        TrieNode tire = new TrieNode();
        for(String word: dict){
            TrieNode curr = tire;
            for(char letter: word.toCharArray()){
                if(curr.children[letter - 'a'] == null){
                    curr.children[letter - 'a'] = new TrieNode();
                }
                curr = curr.children[letter - 'a'];
            }
            curr.word = word;
        }

        StringBuilder ans = new StringBuilder();

        for(String word: sentence.split("\\s+")){
            TrieNode curr = tire;
            for(char letter: word.toCharArray()){
                if(curr.children[letter - 'a'] == null || curr.word != null){
                    break;
                }
                curr = curr.children[letter - 'a'];
            }
            ans.append(curr.word == null ? word: curr.word).append(" ");
        }


        return ans.substring(0,ans.length() -1);


    }

    public String replaceWords2(List<String> dict, String sentence) {
        Set<String> set = new HashSet(dict);
        StringBuilder ans = new StringBuilder();
        String[] words = sentence.split("\\s+");
        for(int i = 0; i< words.length ; i++){
            for(int j = 1; j<= words[i].length();j++){
                if(set.contains(words[i].substring(0,j))){
                    words[i] = words[i].substring(0,j);
                }
            }
            ans.append(words[i] + " ");
        }
        return ans.substring(0,ans.length() -1);

    }

    class TrieNode {
        TrieNode[] children;
        String word;
        TrieNode() {
            children = new TrieNode[26];
        }
    }

}
