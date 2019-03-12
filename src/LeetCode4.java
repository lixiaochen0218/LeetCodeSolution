import java.util.Arrays;

public class LeetCode4 {
    public double findMedianSortedArrays(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;
        int k = (n + m)/2;
        System.out.println("K: " + k);
        if ((n + m)%2==0) {
            return (helper(A,B,k) + helper(A,B,k+1))/2;
        } else {
            return helper(A,B,k+1);
        }

    }
    //solution 1
    public double helper(int[] A,int[] B,int k){
        int m = A.length;
        int n = B.length;
        if (A.length == 0) {
            return (double)B[k-1];
        }
        if (B.length == 0) {
            return (double)A[k-1];
        }
        if (k == 1) {
            return (double)Math.min(A[0] , B[0]);
        }
        int i = Math.min(m,k/2), j = Math.min(n,k/2);

        int valueA = A[i-1];
        int valueB = B[j-1];

        if (valueA < valueB) {
            return helper(Arrays.copyOfRange(A, i, m), B, k - i);
        } else {
            return helper(A, Arrays.copyOfRange(B, j, n), k - j);
        }
    }

    //solution2
    public double helper2(int[] A, int i,int[] B,int j,int k){
        if (A.length <= i) {
            return (double)B[i+k-1];
        }
        if (B.length <= j) {
            return (double)A[j+k-1];
        }
        if (k == 1) {
            return (double)Math.min(A[i],B[j]);
        }
        int midA = (i + k/2 -1 < A.length)? A[i + k/2 -1] : Integer.MAX_VALUE;
        int midB = (j + k/2 -1 < B.length)? B[j + k/2 -1] : Integer.MAX_VALUE;
        if (midA < midB) {
            return helper2(A, i+k/2, B, j, k/2);
        } else {
            return helper2(A, i, B, j+k/2, k/2);
        }
    }
}
