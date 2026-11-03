/*
Course: CPCS 204
Name: Abdulrahman Thigah
Section: CS11
Name of lab instructor: Ayman Yafoz
Problem number: 2
Assignment number: #2
*/

class RemoveDuplicates {
    // ------------------------------------------------------------------------------------
    public static String removeAdjacentDuplicates(String s) {
        // Base case if the string is empty or has only one character
        if (s.length() <= 1) {
            return s;
        }
        // Recursive case compare the first character with the second character
        if (s.charAt(0) == s.charAt(1)) {
            // If they are the same skip the first character and call again on the substring
            return removeAdjacentDuplicates(s.substring(1));
        } else {
            // If they are different keep the first character and call again on the substring
            return s.charAt(0) + removeAdjacentDuplicates(s.substring(1));
        }
    }
    // ------------------------------------------------------------------------------------
}
