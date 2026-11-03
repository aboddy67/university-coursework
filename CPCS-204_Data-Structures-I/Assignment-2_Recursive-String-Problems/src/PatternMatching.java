/*
Course: CPCS 204
Name: Abdulrahman Thigah
Section: CS11
Name of lab instructor: Ayman Yafoz
Problem number: 4
Assignment number: #2
*/

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class PatternMatching {
    // ------------------------------------------------------------------------------------
    public static Set<String> patternMatch(Set<String> words, String pattern) {
        // base case if the set is empty return an empty set
        if (words.isEmpty()) {
            return new HashSet<>();
        }

        // get the first word from the set
        String word = words.iterator().next();
        words.remove(word);

        // recursive call to process the rest of the words
        Set<String> matchingWords = patternMatch(words, pattern);

        // check if the current word matches the pattern
        if (extractUpperCaseChar(word).startsWith(pattern)) {
            matchingWords.add(word);
        }

        return matchingWords;
    }

    // ------------------------------------------------------------------------------------
    // will get the upperCase Characters from a String
    private static String extractUpperCaseChar(String word) {
        // make stringBuilder to store extracted characters
        StringBuilder upperCaseChars = new StringBuilder();

        // whenever you get to an uppercase char append it
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (Character.isUpperCase(c)) {
                upperCaseChars.append(c);
            }
        }
        return upperCaseChars.toString();
    }

    // ------------------------------------------------------------------------------------
    // to ease the input process
    public static Set<String> parseStringToSet(String words) {
        String[] splitWords = words.split(",\\s*"); // comma followed by a zero or more spaces
        return new HashSet<>(Arrays.asList(splitWords)); // to return the split words as a hashset
    }
}
