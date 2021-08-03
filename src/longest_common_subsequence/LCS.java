package longest_common_subsequence;

import java.util.Comparator;
import java.util.stream.Stream;

/**
 * 1143. Longest Common Subsequence
 * Given two strings text1 and text2, return the
 * length of their longest common subsequence.
 * If there is no common subsequence, return 0.
 */
public class LCS {

  /**
   * A version with 2 strings
   * @param text1 the first string
   * @param text2 the second string
   * @return the length of the longest common subsequence.
   */
  public int lcsOf2(String text1, String text2) {
    char[] t1 = text1.toCharArray();
    char[] t2 = text2.toCharArray();

    int m = text1.length();
    int n = text2.length();

    int[][] dp = new int[m + 1][n + 1];

    for (int i = 0; i <= m; i++) {
      for (int j = 0; j <= n; j++) {
        if (i == 0 || j == 0) {
          dp[i][j] = 0;
        } else if (t1[i-1] == t2[j-1]) {
          dp[i][j] = dp[i-1][j-1] + 1;
        } else {
          dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
        }
      }
    }

    return dp[m][n];
  }

  /**
   * A version with 3 input strings
   * @param X the first input string
   * @param Y the second input string
   * @param Z the third input string
   * @return the length of the longest common subsequence
   */
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

  /**
   * A version with the dp table being a 3d String array instead
   * of a 3d int array, and return the longest common subsequence itself
   * instead of the length.
   * @param X the first input string
   * @param Y the second input string
   * @param Z the third input string
   * @return the longest common string
   */
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
