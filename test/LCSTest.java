import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class LCSTest {

  @Test
  public void lcsOf3() {
    assertEquals(4, new LCS().lcsOf3("ABCBDAB", "BDCABA", "BADACB"));
  }

  @Test
  public void testString1() {
    // 5 x 8 x 13 = 520
    assertEquals("geeks", new LCS().StringLCSOf3("geeks", "geeksfor", "geeksforgeeks"));
  }

  @Test
  public void testString2() {
    //
    String test = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
    assertEquals(test, new LCS().StringLCSOf3(test, test, test));
//    assertEquals(79, test.length());
  }
}