/*
Course: CPCS 204
Name: Abdulrahman Thigah
Section: CS11
Name of lab instructor: Ayman Yafoz
Problem number: MAIN CLASS
Assignment number: #2
*/

// ----- THIS CLASS GIVES YOU MENU FUNCTIONALITY -----
// -----   RUN MAIN METHOD TO TEST ALL CLASSES   _____

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("\n---- Welcome to the Assignment 2 Program ----\n");
        int userChoice;
        int TimeoutCounter = 0;

        do {
            System.out.println("\nWhat would you like to try? \nChoose a command from the list: ");
            System.out.println("""
                    
                    | 1. isPalindrome, check if a String is a Palindrome or not.                       |
                    | 2. removeAdjacentDuplicates, remove duplicates beside each other from a String.  |
                    | 3. lexicographicSort, return the maximum occurring word in a String.             |
                    | 4. patternMatch, find CamelCase matching words given uppercase pattern.          |
                    | 0. Exit Program                                                                  |
                    """);
            System.out.print("Choice: ");
            userChoice = input.nextInt();


            switch (userChoice) {
                case 0:
                    System.out.println("\nGOODBYE!");
                    System.exit(0);
                    break;
                // ------------------------------------------------------------------------------------
                // Problem Number: 1
                case 1:

                    System.out.print("Enter a String to check if it's a Palindrome: ");
                    String palinString = input.next();
                    if (Palindrome.isPalindrome(palinString)) {
                        System.out.println("\nTrue, The String you entered IS a palindrome.");
                        System.out.println("Original: " + palinString
                                + "\nReversed: " + Palindrome.reverseString(palinString));
                    } else {
                        System.out.println("\nFalse, The String you entered IS NOT a palindrome.");
                        System.out.println("Original: " + palinString
                                + "\nReversed: " + Palindrome.reverseString(palinString) + "\n");
                    }
                    break;
                // ------------------------------------------------------------------------------------
                // Problem Number: 2
                case 2:
                    System.out.print("\nEnter a String to remove its adjacent duplicates: ");
                    String removeAdjDupString = input.next();
                    System.out.println("\nString Adjacent Duplicates REMOVED!\nNew String: "
                            + RemoveDuplicates.removeAdjacentDuplicates(removeAdjDupString) + "\n");
                    break;
                // ------------------------------------------------------------------------------------
                // Problem Number: 3
                case 3:
                    System.out.print("""
                            
                            Choose one of the following:
                            
                            1. Use a sample example to see how the code works.
                            2. Enter the test String manually for various input.
                            
                            Choice:""");
                    int sortChoice = input.nextInt();

                    if (sortChoice == 1) {
                        String sampleInput = "code, coder, coding, codable, codec, codecs, coded, codeless, " +
                                "codecs, codependence, codex, codify, codependents, codes, code, coder, codesign," +
                                " codec, codeveloper, codrive, codec, codecs, codiscovered";
                        System.out.println("Sample input: \n" + sampleInput);
                        System.out.println("\nMaximum Occurring Word:\n" +
                                lexicographicSorting.lexicographicSort(lexicographicSorting.parseStringToList(sampleInput)));
                    } else if (sortChoice == 2) {
                        input.nextLine();
                        System.out.print("Enter a string of words seperated by comma ',' e.g \"word1, word2, ...\" : ");
                        String userSortInput = input.nextLine();
                        System.out.println("\nMaximum Occurring Word:\n" +
                                lexicographicSorting.lexicographicSort(lexicographicSorting.parseStringToList(userSortInput)));
                    }
                    break;
                // ------------------------------------------------------------------------------------
                // Problem Number: 4
                case 4:
                    System.out.print("""
                            
                            Choose one of the following:
                            
                            1. Choose between 3 sample examples to see how the code works.
                            2. Enter the pattern and the String you want to be tested manually.
                            
                            Choice:""");
                    int patternMatchChoice = input.nextInt();

                    if (patternMatchChoice == 1) {
                        System.out.println("\nChoose one of these 3 patterns to see what will be picked from this sample word Set: ");
                        System.out.print("""
                                words = {Hi, HiTech, HiTechCity, Hello, HelloWorld, HiTechLab}
                                
                                1. Input: pattern = HT
                                2. Input: pattern = HTC
                                3. Input: pattern = H
                                
                                Choice:""");
                        int samplePatternChoice = input.nextInt();
                        String sampleWordSet = "Hi, HiTech, HiTechCity, Hello, HelloWorld, HiTechLab";
                        String pattern;

                        System.out.println("Matching CamelCases: ");
                        // sample cases
                        if (samplePatternChoice == 1) {
                            pattern = "HT";
                            System.out.println(PatternMatching.patternMatch(PatternMatching.parseStringToSet(sampleWordSet), pattern));
                        } else if (samplePatternChoice == 2) {
                            pattern = "HTC";
                            System.out.println(PatternMatching.patternMatch(PatternMatching.parseStringToSet(sampleWordSet), pattern));
                        } else if (samplePatternChoice == 3) {
                            pattern = "H";
                            System.out.println(PatternMatching.patternMatch(PatternMatching.parseStringToSet(sampleWordSet), pattern));
                        }
                    } else if (patternMatchChoice == 2) {
                        input.nextLine();
                        System.out.print("\nEnter a string of words with CamelCases seperated by comma ',' e.g \"WordOne, WordTwo, ...\": ");
                        String userWordsSetInput = input.nextLine();
                        System.out.print("\nEnter the uppercase pattern for CamelCases e.g \"HTC\": ");
                        String pattern = input.next();
                        System.out.println("Matching CamelCases: ");
                        // convert the input string to a Set and pass it to the method
                        System.out.println(PatternMatching.patternMatch(PatternMatching.parseStringToSet(userWordsSetInput), pattern));
                    }
                    break;
                // ------------------------------------------------------------------------------------
                default:
                    System.out.println("Invalid Command, Please try again!");
                    // fail case for too much invalid inputs
                    TimeoutCounter++;
                    System.out.println();

            }
        } while (TimeoutCounter != 3);

    }

}
