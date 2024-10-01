import com.education.ztu.*;

import java.io.Console;
import java.lang.ref.Reference;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // initialize input
        Scanner scan = new Scanner(System.in);

        System.out.println("Task 1");
        Task1.printHelloWorld();

        System.out.println("Task 2");

        System.out.println("Enter 2 numbers to compute their sum: ");
        int num1 = scan.nextInt();
        int num2 = scan.nextInt();

        System.out.println("Sum: " + Task2.sum(num1, num2));

        System.out.println("Task 3");
        Task3.main(new String[]{"2", "3", "4", "5"});

        System.out.println("Task 4");
        System.out.println("Enter 2 numbers to compute their gcd: ");
        num1 = scan.nextInt();
        num2 = scan.nextInt();

        System.out.printf("gcd of(%s, %s) = %s%n", num1, num2, Task4.gcd(num1, num2));

        System.out.println("Task 5");
        System.out.println("Enter number to compute digit sum: ");
        int num = scan.nextInt();
        System.out.printf("Digit sum of %s = %s%n", num, Task5.sumDigits(num));

        System.out.println("Task 6");
        System.out.println("Enter size of fibonacci sequence: ");
        int n = scan.nextInt();
        Task6.printFibonacci(n);

        System.out.println("Task 7");
        Task7.printASCIICodes(new char[]{'A', 'B', 'C'});
    }
}