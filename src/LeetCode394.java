public class LeetCode394 {
    private int index = 0;
    public String decodeString(String s) {
        s+="]";
        return DFS(s);
    }

    public String DFS(String s){
        String res = "";
        while(true){
            if(s.charAt(index) == ']'){
                index++;
                return res;
            }else if (Character.isDigit(s.charAt(index))) {
                String number = s.charAt(index) +"";
                index++;
                while(s.charAt(index) !='['){
                    number += s.charAt(index);
                    index++;
                }
                int count = Integer.parseInt(number);
                // System.out.println(count);
                index++;
                String temp = DFS(s);
                for(int i=0;i<count;i++)
                    res += temp;
            }else{
                res+= s.charAt(index);
                index++;
            }
        }
    }
}

