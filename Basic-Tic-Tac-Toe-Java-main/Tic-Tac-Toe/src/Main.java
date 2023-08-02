import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static int turn=1;
    public static void main(String[] args) {
        char[][] mark=new char[3][3];
        fillArrayWithNull(mark);
        while(true) {
            printBoard(mark);
            if (tieChecker()) break;
            if (TakeNextMarkAndCheckIfWin(mark)) break;
            System.out.println(); //Add extra line
        }
    }
    
     /*This takes the input, and checks if one wins, although 
        I should have made 2 methods */
    public static boolean TakeNextMarkAndCheckIfWin(char[][]mark) { 
        int row, column;
        Scanner scanner=new Scanner(System.in);
        if(turn%2!=0) {
            System.out.println("It is X' turn, enter the row first, then the column");
            row=scanner.nextInt()-1;
            column=scanner.nextInt()-1;
            if(mark[row][column]=='_') {
                mark[row][column]='X';
                turn++;
                if(Checker(mark,'X')) {
                    System.out.println("X has won!");
                    printBoard(mark);
                    return true;
                }
            } else {
                System.out.println("It is already filled, let's try again...\n");
            }
        } else {
            System.out.println("It is O's turn, enter the row first, then the column");
            row=scanner.nextInt()-1;
            column=scanner.nextInt()-1;
            if(mark[row][column]=='_') {
                mark[row][column]='O';
                turn++;
                if(Checker(mark,'O')) {
                    System.out.println("O has won!");
                    printBoard(mark);
                    return true;
                }
            } else {
                System.out.println("It is already filled, let's try again...");
                return false;
            }
        }
        return false;
    }
    public static void fillArrayWithNull(char[][] arr) { //For making the board fill with null values
        for (char[] chars : arr) {
            Arrays.fill(chars, '_');
        }
    }

    public static boolean Checker(char[][] array, char symbol) {
        if(RowMatch(array, symbol)) {
            return true;
        } else if (ColumnMatch(array, symbol)) {
            return true;
        } else return DiagonalMatch(array);
    }
    public static boolean RowMatch(char[][] array, char symbol) {
        int matchfound=0;
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                if(array[i][j]==symbol) {
                    matchfound++;
                } else break;
            }
            if(matchfound==3) {
                return true;
            } else {
                matchfound=0;
            }
        }
        return false;
    }
    public static boolean ColumnMatch(char[][] array, char symbol) {
        int matchfound=0;
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                if(array[j][i]==symbol) {
                    matchfound++;
                } else break;
            }
            if(matchfound==3) {
                return true;
            } else {
                matchfound=0;
            }
        }
        return false;
    }
    public static boolean DiagonalMatch(char[][] array) {
        return (array[0][0] == 'X' && array[1][1] == 'X' && array[2][2] == 'X') ||
                (array[0][0] == 'O' && array[1][1] == 'O' && array[2][2] == 'O') ||
                (array[0][2] == 'X' && array[1][1] == 'X' && array[2][0] == 'X') ||
                (array[0][2] == 'O' && array[1][1] == 'O' && array[2][0] == 'O');
        // It will return true if only the above conditions are true, so no need of if-else
    }
    public static void printBoard(char[][] array) {
        System.out.println("This is the current board");
        for (int i = 0; i < 3; i++) {
            for(int j=0; j<3; j++) {

                if (j==0) System.out.print(" ".repeat(5));
                System.out.print(array[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static boolean tieChecker() {
        if(turn==10) {
            System.out.println("It is a tie :(");
            return true;
        }
        return false;
    }
}
