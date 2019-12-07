public class LeetCode223 {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int I = Math.max(A, E);
        int J = Math.max(B, F);
        int K = Math.min(C, G);
        int L = Math.min(D, H);
        return squareArea(A, B, C, D) + squareArea(E, F, G, H) - squareArea(I, J, K, L);
    }

    private int squareArea(int x1, int y1, int x2, int y2) {
        if (x1 >= x2 || y1 >= y2)
            return 0;
        return Math.abs(x1-x2)*Math.abs(y1-y2);
    }
}
