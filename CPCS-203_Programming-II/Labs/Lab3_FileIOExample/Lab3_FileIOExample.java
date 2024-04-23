/* 
Abdulrahman Thigah
*/
package Lab3_FileIOExample;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Lab3_FileIOExample {

    public static void main(String[] args) throws FileNotFoundException {
        File F1 = new File("/Users/aboddy/Desktop/fileGetTest/file1.txt");
        checkFileExist(F1);
        File F2 = new File("/Users/aboddy/Desktop/fileGetTest/file2.txt");
        checkFileExist(F2);
        File outputF = new File("/Users/aboddy/Desktop/fileGetTest/file1 - file2 output.txt");

        Scanner inputF1 = new Scanner(F1);
        Scanner inputF2 = new Scanner(F2);
        PrintWriter outputIn = new PrintWriter(outputF);

        String[] fullNamesArray = new String[3];
        int count = 0;

        while (inputF1.hasNext() && inputF2.hasNext()) {
            StringBuilder fullName = new StringBuilder();
            fullName.append(inputF1.nextLine()).append(" ").append(inputF2.nextLine());

            outputIn.println(fullName);
            outputIn.flush();

            fullNamesArray[count] = fullName.toString();
            count++;
        }

        inputF1.close();
        inputF2.close();
        outputIn.close();

        countOccurrences(fullNamesArray);
    }

    public static void checkFileExist(File input) {
        if (!input.exists()) {
            System.out.println("The file " + input.getName() + " is not found "
                    + "\nCheck in " + input.getAbsolutePath());
            System.exit(0);
        }
    }

    public static void countOccurrences(String[] names) {
        int[] letterCounts = new int[26];

        for (String name : names) {
            for (char ch : name.toUpperCase().toCharArray()) {
                if (Character.isLetter(ch)) {
                    letterCounts[ch - 'A']++;
                }
            }
        }


        for (int i = 0; i < letterCounts.length; i++) {
            char letter = (char) ('A' + i);
            System.out.println("Number of " + letter + "'s: " + letterCounts[i]);
        }
    }

}
