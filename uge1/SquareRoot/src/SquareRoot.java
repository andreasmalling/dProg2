public class SquareRoot {
  public static int intSquareRoot(int n) {
    int a = n;
    int b = 1;
    while (a>b) {
      a = (a+b)/2;
      b = n/a;
    }
    assert (a*a <= n   &&   n < (a+1)*(a+1));
    return a;
  }

  public static void main(String[] args) {
    int n = Integer.parseInt(args[0]);
    int r = intSquareRoot(n);
    System.out.println(r);
  }
}

