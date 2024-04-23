/* 
Abdulrahman Thigah
*/
package Labs_CPCS203.Lab2_ProductGenerator;

import java.util.Scanner;

public class Lab2_ProductIdGenerator {
    public static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {

        System.out.println("Product ID Generator");
        System.out.println("------------------------");
        System.out.println("Please Enter Product Information");

        String pCategory = pCategoryCheck();
        String pCode = pCodeCheck();
        int mYear = mYearCheck();
        int SRN = SRNCheck();

        StringBuilder GPID = new StringBuilder();
        GPID.append(pCategory);
        GPID.append(pCode).append("-");
        GPID.append(mYear).append("-");
        GPID.append(SRN);

        System.out.println("------------------------");
        System.out.println("Generated Product ID: " + GPID);

    }

    public static String pCategoryCheck() {
        String pCat;
        do {
            System.out.print("Product Category (only letters with a length more than 2): ");
            pCat = in.next();

            if (pCat.length() < 2) {
                System.out.println("Product Category length was not more than 2, Please try again");
            } else if (!pCat.matches("[a-zA-Z]+")) {
                System.out.println("Product Category must only contain letters. Please try again.");
            }
        } while (pCat.length() < 2 || !pCat.matches("[a-zA-Z]+"));

        return pCat;
    }

    public static String pCodeCheck() {
        String pCode;
        do {
            System.out.print("Product Code (consists only of 3 digits): ");
            pCode = in.next();

            if (pCode.length() != 3) {
                System.out.println("Product Code length was not 3. Please try again.");
            }
        } while (pCode.length() != 3);

        return pCode;
    }

    public static int mYearCheck() {
        System.out.print("Manufacturing Year: ");
        int mYear = in.nextInt();
        return mYear;
    }

    public static int SRNCheck() {
        System.out.print("Stock Reference Number: ");
        int SRN = in.nextInt();
        return SRN;
    }

}
