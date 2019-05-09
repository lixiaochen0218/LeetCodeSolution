public class LeetCode006 {
    public String convert(String s, int numRows) {
        if(numRows == 1 || s.length() <= numRows) return s;

        String[] ss = new String[numRows];
        int gap = numRows*2-2;

        for(int i=0;i<s.length();i++){
            int index = i%gap;
            if(index>=numRows){
                index = numRows -1 -1 - (index-numRows);
            }
            // System.out.println(index);
            if(ss[index]==null){
                ss[index] = s.charAt(i) + "";
            }else{
                ss[index] = ss[index] + s.charAt(i);
            }

        }
        StringBuilder sb = new StringBuilder();
        for(String str:ss){
            sb.append(str);
        }
        return sb.toString();
    }
}
