/*
Course: CPCS 204
Name: Abdulrahman Thigah
Section: CS11
Name of lab instructor: Ayman Yafoz
Problem number: 3
Assignment number: #2
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashMap;

class lexicographicSorting {
    // ------------------------------------------------------------------------------------
    public static String lexicographicSort(List<String> words) {
        // make hashmap to store occurrences for each value
        HashMap<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // using recursion find max occurrences
        return findMaxOccurrence(wordCount, new ArrayList<>(wordCount.keySet()), 0, new ArrayList<>(), 0);
    }

    // ------------------------------------------------------------------------------------
    private static String findMaxOccurrence(HashMap<String, Integer> wordCount, List<String> keys, int index, List<String> maxWords, int maxCount) {
        // if all keys are checked
        if (index == keys.size()) {
            return maxWords.get(0);  // return the first word
        }

        // getting current word and its count
        String currentWord = keys.get(index);
        int currentCount = wordCount.get(currentWord);

        // change maxWords and maxCount if currentCount is greater
        if (currentCount > maxCount) {
            maxWords.clear();  // clear list because we found a higher occurrence word
            maxWords.add(currentWord);
            maxCount = currentCount;
        } else if (currentCount == maxCount && !maxWords.contains(currentWord)) {
            maxWords.add(currentWord);  // add the word if it’s not in maxWords
        }

        // recursive case to check the next word
        return findMaxOccurrence(wordCount, keys, index + 1, maxWords, maxCount);
    }

    // ------------------------------------------------------------------------------------
    // to ease the input process and parse the line string into a list
    public static List<String> parseStringToList(String s) {
        String[] wordsArray = s.split(",\\s*");
        return Arrays.asList(wordsArray);
    }
    // ------------------------------------------------------------------------------------
}
