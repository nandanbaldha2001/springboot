public class PasswordGenerator {

  public static long countPasswords(int n, int k) {
    int  MOD = 1000000007;
    if(n==k){
      int x=power(26,n,MOD);

      ;
      return (int)x;
    }
    return countPasswords(n,k+1)-26*(n-k+1);


  }
  static int power(int x, int y, int p)
  {
    int res = 1; // Initialize result

    while (y > 0) {

      // If y is odd, multiply x with result
      if ((y & 1) != 0)
        res = res * x;

      // y must be even now
      y = y >> 1; // y = y/2
      x = x * x; // Change x to x^2
    }
    return res % p;
  }

  public static void main(String[] args) {
    int n = 3; // Length of the password
    int k = 3; // Maximum consecutive equal characters allowed
    long result = countPasswords(n, k);
    System.out.println("Number of passwords: " + result);
  }
}
