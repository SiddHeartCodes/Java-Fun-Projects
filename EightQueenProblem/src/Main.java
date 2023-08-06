import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main
{
    static int n=0;
    static Queen[][] board=new Queen[8][8];//The player board
    static List<Queen> number=new ArrayList<>(); //To store the number of queens placed
    static Scanner scanner=new Scanner(System.in);

    public static void main(String[] args) {
        check(0);
        System.out.println(n);

    }

    public static void check(int rowstart)
    {
        if(rowstart==0)
        {
            for(int i=0;i<8;i++)
            {
                board[rowstart][i]=new Queen(rowstart,i);
                number.add(board[rowstart][i]);
                check(rowstart+1);
                number.remove(board[rowstart][i]);
                board[rowstart][i]=null;
            }
        }
        else if(rowstart<8&&rowstart>0)
        {
            for(int k=0;k<8;k++) {
                int flag=1;
                board[rowstart][k]=new Queen(rowstart,k);
                for (Queen queen : number)
                {
                    if (!queen.canMove(board))
                    {
                        flag=0;
                        break;
                        }
                }
                if (flag==1)
                {
                    number.add(board[rowstart][k]);
                    check(rowstart+1);
                    number.remove(board[rowstart][k]);
                }
                board[rowstart][k]=null;
            }
        }
        else if(rowstart==8)
        {
            n++;
        }
    }


}
