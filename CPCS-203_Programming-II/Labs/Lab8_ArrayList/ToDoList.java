/* 
Abdulrahman Thigah
*/
package Lab8_ArrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Task> list = new ArrayList<>();

        char addCondition;

        do {
            System.out.print("Enter the Title of the Task: ");
            String title = in.nextLine();
            System.out.print("Enter the Task Due Date: ");
            String dueDate = in.nextLine();
            System.out.print("Enter the Status: ");
            int status = in.nextInt();


            Task task = new Task(title, dueDate, status);
            list.add(task);

            System.out.print("Continue Adding (y/n)? ");
            addCondition = in.next().charAt(0);
            in.nextLine(); // consume newline from char
        } while (addCondition == 'y');

        System.out.println("\nTo Do List Contains:\n------------------------------------------------------------------");
        for (Task task : list) {
            System.out.println(task.toString());
        }
    }
}
