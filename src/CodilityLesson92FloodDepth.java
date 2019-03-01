public class CodilityLesson92FloodDepth {
    public int solution(int[] A) {

        if (A.length<3) {
            return 0;
        }
        int left = A[1]-A[0]>0?0:A[0];
        int right = 0;
        int bottom = 0;
        int maxDepth = 0;

        boolean climb = A[1]-A[0]>0?false:true; // if climb = false (going down) ; if climb = true (going up)
        for (int i=1;i<A.length;i++) {
            if (A[i -1] == A[i]) {

            } else if (A[i -1] > A[i]) { // going down
                if (climb == true && A[i -1] >= left) {
                    left = A[i-1];
                    bottom = 100000001;
                }
                climb = false;
                bottom = Math.min(A[i],bottom);

            } else { //going up

                right = A[i];

                System.out.println("a[i] : " + A[i] +"=====" + left + bottom + right);
                if (left > bottom && right > bottom && left > 0 && right > 0) {

                    int currentMaxDepth = Math.min(left-bottom,right-bottom);
                    maxDepth = Math.max(currentMaxDepth,maxDepth);
                    System.out.println("maxDepth:" + currentMaxDepth + ";" + left + bottom + right);
                }

                climb = true;
            }
        }
        return maxDepth;
    }
}
