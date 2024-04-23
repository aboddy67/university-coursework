/*
Name: Abdulrahman Adnan Thigah
*/
package Labs_CPCS203.Lab7_InheritanceAndPolymorphism;

import java.util.*;

public class DailyBookReport {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double currentDayIncome = 0;
        Book[] storedBooks = new Book[10]; // Assumed number of expected books per day

        System.out.print("Enter number of Books for the current day: ");
        int currentDayBooksNum = in.nextInt();

        for (int i = 0; i < currentDayBooksNum; i++) {
            System.out.println("-------------------------------------------------------------------");

            in.nextLine(); // Consume the newline character left by next() so we can read title
            System.out.print("Enter Book's Title: ");
            String title = in.nextLine();
            System.out.print("Enter Book's Purchase Cost: ");
            double purchaseCost = in.nextDouble();
            System.out.print("Enter Book's Type (C for children, M for Motivational and B for Biographies): ");
            char bookType = in.next().toLowerCase().charAt(0);

            switch (bookType) {
                case 'c':
                    Book childrenBook = new ChildrenBook(title, purchaseCost);
                    storedBooks[Book.bookCounter - 1] = childrenBook;
                    break;

                case 'm':
                    Book motivationalBook = new MotivationalBook(title, purchaseCost);
                    storedBooks[Book.bookCounter - 1] = motivationalBook;
                    break;

                case 'b':
                    Book biographiesBook = new BiographiesBook(title, purchaseCost);
                    storedBooks[Book.bookCounter - 1] = biographiesBook;
                    break;
            }
        }

        System.out.println("-------------------------------------------------------------------");
        for (Book books : storedBooks) {
            if (books == null)
                break;
            System.out.println(books.toString());
            currentDayIncome += books.getPurchasesCost();
        }

        System.out.println("-------------------------------------------------------------------");
        System.out.println("Current Day Income = " + currentDayIncome + "SR.");

    }
}
