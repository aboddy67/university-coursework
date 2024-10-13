/*
Course: CPCS 204
Name: Abdulrahman Thigah
Section: CS11
Name of lab instructor: Ayman Yafoz
Problem number: 1
Assignment number: #2
*/

class Palindrome {
    // ------------------------------------------------------------------------------------
    public static boolean isPalindrome(String s) {
        String reversedString = reverseString(s);
        // if they are equal true will return
        return reversedString.equals(s);
    }

    // ------------------------------------------------------------------------------------
    public static String reverseString(String originalS) {
        // Base case if the string is empty or has one character return the string itself
        if (originalS.length() <= 1) {
            return originalS;
        }
        // Recursive case append the last character to the result of the recursive call
        return originalS.charAt(originalS.length() - 1) + reverseString(originalS.substring(0, originalS.length() - 1));
    }
    // ------------------------------------------------------------------------------------
}
