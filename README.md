# University coursework

Labs, assignments and practice from my Computer Science courses at King Abdulaziz University (KAU), Jeddah.
Each project used to live in its own repository. They are collected here, sorted by course, with their original
commit history kept.

The code is shown as I wrote and submitted it at the time. It hasn't been updated since.

## Contents

### CPCS-203: Programming II (Java, 2024)
Object-oriented programming: classes, inheritance, interfaces, file I/O.

| Project | What it does | Concepts |
|---|---|---|
| [Labs](CPCS-203_Programming-II/Labs) | Weekly lab exercises: Tic-tac-toe, product ID generator, file I/O, quadrilaterals, products and people, a book report system, a to-do list, shapes, a generic pair | Classes and objects, inheritance and polymorphism, abstract classes and interfaces, ArrayList, generics, file I/O |
| [Assignment 1: Airline Ticket Reservation](CPCS-203_Programming-II/Assignment-1_Airline-Ticket-Reservation) | Reads flights and passengers from files, books tickets by class and seat, and generates invoices into `output.txt` | Classes, arrays of objects, file input and output |
| [Assignment 2: Employee Management System](CPCS-203_Programming-II/Assignment-2_Employee-Management-System) | Adds managers, developers and designers, handles leave requests and approvals, changes employee states, prints records | Abstract classes, inheritance, interfaces (`Approver`), polymorphism, file I/O |

### CPCS-204: Data Structures I (Java, 2024)
Building the classic data structures by hand.

| Project | What it does | Concepts |
|---|---|---|
| [Labs](CPCS-204_Data-Structures-I/Labs) | Arrays and a deck of cards, binary vs linear search, a linked list, recursion, a binary search tree | Arrays, searching, linked lists, recursion, BSTs |
| [Assignment 1: Linked Lists](CPCS-204_Data-Structures-I/Assignment-1_Linked-Lists) | Menu program: delete n nodes after skipping m, swap the k-th node from the start and end, sorted intersection of two lists, sorting a doubly linked list | Singly and doubly linked lists |
| [Assignment 2: Recursive String Problems](CPCS-204_Data-Structures-I/Assignment-2_Recursive-String-Problems) | Palindrome check, removing adjacent duplicates, lexicographic sorting by frequency, pattern matching on capital letters | Recursion, strings, sets and maps |
| [Assignment 3: Train Ticket Booking](CPCS-204_Data-Structures-I/Assignment-3_Train-Ticket-Booking) | Reads commands from `input.txt`: trains, passengers, booking with a waiting list, cancelling | Hand-built queue and stack (linked nodes) |

### Web
| Project | What it does |
|---|---|
| [HTML & CSS crash course](Web/HTML-CSS-Crash-Course) | First HTML and CSS practice: a product page and styled buttons |

## Running the Java projects
Each assignment is a standalone Java project (JDK 17 or newer). From the assignment's folder:

```bash
javac -d out src/*.java
java -cp out MainSystem
```

The main class is `MainSystem` (Employee Management, Train Ticket Booking), `BookingSystem` (Airline Ticket
Reservation) or `Main` (CPCS-204 Assignments 1 and 2). The file-based ones read their input from the
`.txt` files in the same folder and write `output.txt`.

The labs use one package per lab: compile from the `Labs` folder, for example
`javac -d out Lab1_TicTacToe/*.java && java -cp out Lab1_TicTacToe.Lab1_TicTacToe`.

## Academic integrity
These are my own submissions, published as a record of my coursework. If you are taking these courses, don't
copy them.

Abdulrahman Thigah
