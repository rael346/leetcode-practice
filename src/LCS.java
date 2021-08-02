import java.util.Comparator;
import java.util.stream.Stream;

public class LCS {
  public int lcsOf3(String X, String Y, String Z) {
    int m = X.length();
    int n = Y.length();
    int p = Z.length();
    int[][][] dp = new int[m+1][n+1][p+1];

    for (int i = 0; i <= X.length(); i++) {
      for (int j = 0; j <= Y.length(); j++) {
        for (int k = 0; k <= Z.length(); k++) {
          if (i == 0 || j == 0 || k == 0) {
            dp[i][j][k] = 0;
          } else if (X.charAt(i-1) == Y.charAt(j-1)
              && Y.charAt(j-1) == Z.charAt(k-1)) {
            dp[i][j][k] = dp[i-1][j-1][k-1] + 1;
          } else {
            dp[i][j][k] = Math.max(
                Math.max(dp[i-1][j][k], dp[i][j-1][k]), dp[i][j][k-1]);
          }
        }
      }
    }

    return dp[m][n][p];
  }

  public String StringLCSOf3(String X, String Y, String Z) {
    int m = X.length();
    int n = Y.length();
    int p = Z.length();
    String[][][] dp = new String[m+1][n+1][p+1];

    for (int i = 0; i <= X.length(); i++) {
      for (int j = 0; j <= Y.length(); j++) {
        for (int k = 0; k <= Z.length(); k++) {
          if (i == 0 || j == 0 || k == 0) {
            dp[i][j][k] = "";
          } else if (X.charAt(i-1) == Y.charAt(j-1)
              && Y.charAt(j-1) == Z.charAt(k-1)) {
            dp[i][j][k] = dp[i-1][j-1][k-1] + X.charAt(i-1);
          } else {
            String[] triple = {dp[i-1][j][k], dp[i][j-1][k], dp[i][j][k-1]};

            dp[i][j][k] = Stream.of(triple).max(Comparator.comparingInt(String::length)).get();
          }
        }
      }
    }

    return dp[m][n][p];
  }
}
