import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class LeetCode752 {
    public int openLock(String[] deadends, String target) {
        Set<String> deadSet = new HashSet();
        Set<String> visitedSet = new HashSet();
        Queue<String> queue = new LinkedList();
        for(String s:deadends){
            deadSet.add(s);
        }
        System.out.println(deadSet.size());
        String start = "0000";
        if(deadSet.contains(start))
            return -1;
        queue.add(start);
        visitedSet.add(start);
        int steps = 0;
        while(!queue.isEmpty()){
            steps++;
            int size = queue.size();
            for(int i=0;i<size;i++){
                String temp = queue.remove();
                for(int j=0;j<4;j++){
                    for(int k=-1;k<=1;k=k+2){
                        String aa = helper(temp, j, k);
                        if(aa.equals(target))
                            return steps;
                        if(!deadSet.contains(aa) && !visitedSet.contains(aa)){
                            // System.out.println(aa + ": " +deadSet.contains(aa));
                            queue.add(aa);
                            visitedSet.add(aa);
                        }
                    }
                }
            }
        }
        return -1;


    }

    public String helper(String temp, int index, int add){
        char[] chars = temp.toCharArray();
        if(add == 1 && chars[index] == '9'){
            chars[index] = '0';
            return String.valueOf(chars);
        }else if(add == -1 && chars[index] == '0'){
            chars[index] = '9';
            return String.valueOf(chars);
        }else{
            int num = (int)chars[index] + add;
            chars[index] =  (char)num;
            // System.out.println(String.valueOf(chars));
            return String.valueOf(chars);
        }
    }
}
