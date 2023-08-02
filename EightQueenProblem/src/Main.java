import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main
{
    static Queen[][] board=new Queen[8][8];
    static List<Queen> number=new ArrayList<>();
    static Scanner scanner=new Scanner(System.in);

    public static void main(String[] args)
    {
        while(true)
        {
            System.out.println("Do you want to add a queen, 1 for yes or 2 for no (exit)?");
            int choice = scanner.nextInt();
            if (choice == 1)
            {
                System.out.println("Enter the row first, then column!");
                int row = scanner.nextInt();
                int column = scanner.nextInt();
                Queen queen = new Queen(row - 1, column - 1);
                board[row-1][column-1]=queen;
                boolean check=true;
                for(int i=0;i<number.size();i++)
                {   check=number.get(i).canMove(board);
                    if(!check)
                    {
                        break;
                    }
                }
                if(check)
                {
                    number.add(queen);
                    board[row - 1][column - 1] = queen;
                    System.out.println("The new queen no." + number.size() + " is placed at row " +
                            (number.get(number.size() - 1).getRow() + 1) + " and column " + (number.get(number.size() - 1).getColumn() + 1));
                }
                else
                {
                    board[row-1][column-1]=null;
                    System.out.println("Sorry, queen can't be placed!");
                }
            }
            else break;
        }
    }
}
