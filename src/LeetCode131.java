import java.util.ArrayList;
import java.util.List;

public class LeetCode131 {
    List<List<String>> set = new ArrayList();
    public List<List<String>> partition(String s) {
        helper(new ArrayList(),0,s);
        return set;
    }

    public void helper(List<String> list, int start, String s){
        if(start == s.length()){
            set.add(new ArrayList(list));
        }
        for(int i=start;i<s.length();i++){
            if(isPalindrome(s,start,i)){
                list.add(s.substring(start,i+1));
                helper(list,i+1,s);
                list.remove(list.size()-1);
            }
        }
    }

    public boolean isPalindrome(String s,int start,int end){
        while(start<end){
            if(s.charAt(start++)!=s.charAt(end--)) return false;
        }
        return true;
    }
}
