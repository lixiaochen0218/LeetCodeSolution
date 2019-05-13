import java.util.List;

public class LeetCode120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size()==1){
            return triangle.get(0).get(0);
        }
        int min = Integer.MAX_VALUE;
        for(int i=1;i<triangle.size();i++){
            List<Integer> row = triangle.get(i);
            List<Integer> lastrow = triangle.get(i-1);
            for(int j=0;j<row.size();j++){
                int newValue;
                if (j==0){
                    newValue = row.get(j) + lastrow.get(0);
                }else if (j==row.size()-1){
                    newValue = row.get(j) + lastrow.get(lastrow.size()-1);
                }else{
                    newValue = Math.min(lastrow.get(j),lastrow.get(j-1)) + row.get(j);
                }
                triangle.get(i).remove(j);
                triangle.get(i).add(j,newValue);
                if(i == triangle.size()-1){
                    min = Math.min(newValue,min);
                }
                // System.out.println(newValue + " " + j + " " + i);
            }
        }
        return min;
    }
}
