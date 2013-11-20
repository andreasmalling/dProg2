import java.util.Scanner;

public class Test2 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.print("Skriv et tal: ");
    int age = in.nextInt();
    System.out.print("Skriv endnu et tal: ");
    in = new Scanner(System.in);
    age += in.nextInt();
    System.out.println("Summen af de to tal er: " + (age));
  }
}
