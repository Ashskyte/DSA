package recursion.string;

public class PalindromeString {
  public static void main(String[] args) {
    String str = "abbaabba";
    System.out.println(palindromeString(str, 0, str.length() - 1));
  }

  private static boolean palindromeString(String str, int l, int r) {

    if (l >= r) {
      return true;
    } else if (str.charAt(l) != str.charAt(r)) {
      return false;
    }
    palindromeString(str, l + 1, r - 1);
    return true;
  }
}
