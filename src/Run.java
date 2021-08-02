import java.util.Arrays;
import java.util.Scanner;

public class Run {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int n = scan.nextInt();

    int[] C = new int[n];
    for (int i = 0; i < n; i++) {
      C[i] = scan.nextInt();
    }

    int[] B = new int[n];
    for (int i = 0; i < n; i++) {
      B[i] = scan.nextInt();
    }

    int S = scan.nextInt();

    int[] M_C = new int[n];
    int[] M_B = new int[n];

    M_C[0] = C[0];
    M_B[0] = B[0];

    for (int i = 1; i < n; i++) {
      M_C[i] = Math.max(M_B[i-1] + C[i] - S, M_C[i-1] + C[i]);
      M_B[i] = Math.max(M_B[i-1] + B[i], M_C[i-1] + B[i] - S);
    }

//    System.out.print(Math.max(M_C[n-1], M_B[n-1]));
    System.out.println(Arrays.toString(M_C));
    System.out.println(Arrays.toString(M_B));
  }
}
