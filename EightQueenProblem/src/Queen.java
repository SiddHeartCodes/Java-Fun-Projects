public class Queen {
    private int row;

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    private int column;

    public Queen(int row, int column)
    {
        this.row=row;
        this.column = column;
    }
    public boolean canMoveVertically(Queen[][] board)
    {
        for(int i=0;i<8;i++)
        {
            if(i==column)
            {
                continue;
            }
            else if(board[row][i]!=null) {
                return false;
            }
        }
        return true;
    }
    public boolean canMoveHorizontally(Queen[][] board)
    {
        for(int i=0;i<8;i++)
        {
            if(i==row)
            {
                continue;
            }
            else if(board[i][column]!=null) {
                return false;
            }
        }
        return true;
    }

    public boolean canMoveDiagonallyNE(Queen[][] board)
    {
        int i,j;
        i=row+1;
        j=column+1;
        while(true)
        {
            if(i<8&&j<8&&i>-1&&j>-1&&board[i][j]==null)
            {
                i++;
                j++;
                continue;
            }
            else if(i==8||j==8||i==-1||j==-1)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
    }

    public boolean canMoveDiagonallySE(Queen[][] board)
    {
        int i,j;
        i=row-1;
        j=column+1;
        while(true)
        {
            if(i<8&&j<8&&i>-1&&j>-1&&board[i][j]==null)
            {
                i--;
                j++;
                continue;
            }
            else if(i==8||j==8||i==-1||j==-1)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
    }

    public boolean canMoveDiagonallySW(Queen[][] board)
    {
        int i,j;
        i=row-1;
        j=column-1;
        while(true)
        {
            if(i<8&&j<8&&i>-1&&j>-1&&board[i][j]==null)
            {
                i--;
                j--;
                continue;
            }
            else if(i==8||j==8||i==-1||j==-1)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
    }

    public boolean canMoveDiagonallyNW(Queen[][] board)
    {
        int i,j;
        i=row+1;
        j=column-1;
        while(true)
        {
            if(i<8&&j<8&&i>-1&&j>-1&&board[i][j]==null)
            {
                i++;
                j--;
                continue;
            }
            else if(i==8||j==8||i==-1||j==-1)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
    }

    public boolean canMove(Queen[][] board)
    {
        if(canMoveDiagonallySE(board) && canMoveVertically(board) && canMoveDiagonallyNE(board)
                && canMoveDiagonallySW(board) && canMoveHorizontally(board) && canMoveDiagonallyNW(board))
        {
            return true;
        }
        return false;
    }



}
