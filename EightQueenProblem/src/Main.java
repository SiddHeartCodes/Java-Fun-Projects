import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main
{
    static int n=0;
    static Queen[][] board=new Queen[8][8];//The player board
    static List<Queen> number=new ArrayList<>(); //To store the number of queens placed
    static Scanner scanner=new Scanner(System.in);

    public static void main(String[] args)
    {
       checkPlace(number,board);
        System.out.println(n/(8 * 7 * 6 * 5 * 4 * 3 * 2)); //We are dividing by 8! as there would be 8! ways to place
        // same arrangement again
    }

    public static void checkPlace(List<Queen> number, Queen[][] board) {
        if (number.size() != 8) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    int flag = 1;
                    if(number.size()!=0)
                    {
                        for (Queen queen : number) {
                            if (i == queen.getRow() || j == queen.getColumn()) {
                                flag = 0;
                                break;
                            }
                        }
                    }
                    if (flag == 0)
                        continue;
                    board[i][j] = new Queen(i, j);

                    for (Queen queen : number) {
                        if (!queen.canMove(board)) {
                            flag = 0;
                            break;
                        }
                    }
                    if (flag == 0) {
                        board[i][j] = null;
                    } else {
                        number.add(board[i][j]);
                        checkPlace(number, board);// Recursively continue searching for other solutions
                        number.remove(board[i][j]);
                        board[i][j] = null;
                    }
                }
            }
        } else {
            n++;
        }
    }

}
