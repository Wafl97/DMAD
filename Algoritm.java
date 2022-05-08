public class Algoritm {

    public static void main(String[] args) {
        Algoritm strassen = new Algoritm();

        int[][] A = { { 1, 2, 3, 4 },
                      { 4, 3, 0, 1 },
                      { 5, 6, 1, 1 },
                      { 0, 2, 5, 6 } };
 
        int[][] B = { { 1, 0, 5, 1 },
                      { 1, 2, 0, 2 },
                      { 0, 3, 2, 3 },
                      { 1, 2, 1, 2 } };

        int[][] C = strassen.multiply(A, B);
        strassen.print(C);
    }

    public void print(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }
    }
    

    public int[][] multiply(int[][] A, int[][] B) {
        int n = A.length;
        int[][] C = new int[n][n];
        if (n == 1) {
            C[0][0] = A[0][0] * B[0][0];
            return C;
        }
        int[][] A11 = new int[n/2][n/2];
        int[][] A12 = new int[n/2][n/2];
        int[][] A21 = new int[n/2][n/2];
        int[][] A22 = new int[n/2][n/2];
        int[][] B11 = new int[n/2][n/2];
        int[][] B12 = new int[n/2][n/2];
        int[][] B21 = new int[n/2][n/2];
        int[][] B22 = new int[n/2][n/2];

        split(A, A11, 0, 0);
        split(A, A12, 0, n/2);
        split(A, A21, n/2, 0);
        split(A, A22, n/2, n/2);

        split(B, B11, 0, 0);
        split(B, B12, 0, n/2);
        split(B, B21, n/2, 0);
        split(B, B22, n/2, n/2);

        int[][] S1 = sub(B12,B22);
        int[][] S2 = add(A11,A22);
        int[][] S3 = add(A21,A22);
        int[][] S4 = sub(B21,B11);
        int[][] S5 = add(A11,A22);
        int[][] S6 = add(B11,B22);
        int[][] S7 = sub(A12,A22);
        int[][] S8 = add(B21,B22);
        int[][] S9 = sub(A11,A21);
        int[][] S10 = add(B11,B12);

        int[][] P1 = multiply(A11, S1);
        int[][] P2 = multiply(S2, B22);
        int[][] P3 = multiply(S3, B11);
        int[][] P4 = multiply(A22, S4);
        int[][] P5 = multiply(S5, S6);
        int[][] P6 = multiply(S7, S8);
        int[][] P7 = multiply(S9, S10);

        int[][]C11 = add(sub(add(P5,P4),P2),P6);
        int[][]C12 = add(P1,P2);
        int[][]C21 = add(P3,P4);
        int[][]C22 = sub(sub(add(P5,P1),P3),P7);

        join(C11,C,0,0);
        join(C12,C,0,n/2);
        join(C21,C,n/2,0);
        join(C22,C,n/2,n/2);

        return C;
    }

    private void split(int[][] A, int[][] B, int iB, int jB) {
        for (int i1 = 0, i2 = iB; i1 < B.length; i1++, i2++) {
            for (int j1 = 0, j2 = jB; j1 < B.length; j1++, j2++) {
                B[i1][j1] = A[i2][j2];
            }
        }
    }

    private int[][] add(int[][] A, int[][] B) {
        int n = A.length;
        int[][] C = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                C[i][j] = A[i][j] + B[i][j];
            }
        }
        return C;
    }

    private int[][] sub(int[][] A, int[][] B) {
        int n = A.length;
        int[][] C = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                C[i][j] = A[i][j] - B[i][j];
            }
        }
        return C;
    }

    private void join(int[][] A, int[][] B, int iB, int jB) {
        for (int i1 = 0, i2 = iB; i1 < A.length; i1++, i2++) {
            for (int j1 = 0, j2 = jB; j1 < A.length; j1++, j2++) {
                B[i2][j2] = A[i1][j1];
            }
        }
    }
}
