package AlgoritmProgram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeAnagramPalindrome {

    // Function to check if a number is prime
    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        if (num <= 3) {
            return true;
        }
        if (num % 2 == 0 || num % 3 == 0) {
            return false;
        }
        for (int i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    // Function to check if a number is a palindrome
    public static boolean isPalindrome(int num) {
        int original = num;
        int reversed = 0;
        while (num > 0) {
            int remainder = num % 10;
            reversed = reversed * 10 + remainder;
            num /= 10;
        }
        return original == reversed;
    }

    // Function to check if two numbers are anagrams
    public static boolean areAnagrams(int num1, int num2) {
        char[] num1Chars = Integer.toString(num1).toCharArray();
        char[] num2Chars = Integer.toString(num2).toCharArray();
        Arrays.sort(num1Chars);
        Arrays.sort(num2Chars);
        return Arrays.equals(num1Chars, num2Chars);
    }

    public static void main(String[] args) {
        int n = 1000; // Set the range to search for prime numbers (e.g., 1 to 1000)
        List<Integer> primeAnagramPalindromeNumbers = new ArrayList<>();

        for (int i = 2; i <= n; i++) {
            if (isPrime(i) && isPalindrome(i)) {
                primeAnagramPalindromeNumbers.add(i);
            }
        }

        for (int i = 0; i < primeAnagramPalindromeNumbers.size(); i++) {
            for (int j = i + 1; j < primeAnagramPalindromeNumbers.size(); j++) {
                int num1 = primeAnagramPalindromeNumbers.get(i);
                int num2 = primeAnagramPalindromeNumbers.get(j);
                if (areAnagrams(num1, num2)) {
                    System.out.println(num1 + " and " + num2 + " are anagrams and palindromes.");
                }
            }
        }
    }
}
