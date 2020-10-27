import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class HelloWorld {
  public static void main(String[] args) {
    HelloWorld s = new HelloWorld();
    char[][] board = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' }, { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
        { '.', '9', '8', '.', '.', '.', '.', '6', '.' }, { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
        { '4', '.', '.', '8', '.', '3', '.', '.', '1' }, { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
        { '.', '6', '.', '.', '.', '.', '2', '8', '.' }, { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
        { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
    s.solveSudoku(board);
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        System.out.print(board[i][j]);
        System.out.print(",");
      }
      System.out.println();
    }

  }

  private List<Set<Integer>> rowSets = new ArrayList<>();
  private List<Set<Integer>> columnSets = new ArrayList<>();
  private List<Set<Integer>> gridSets = new ArrayList<>();

  public void solveSudoku(char[][] board) {
    for (int i = 0; i < 9; i++) {
      rowSets.add(new HashSet<>());
      columnSets.add(new HashSet<>());
      gridSets.add(new HashSet<>());
    }

    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        if (board[i][j] != '.') {
          int num = board[i][j] - '0';
          rowSets.get(i).add(num);
          columnSets.get(j).add(num);
          int gridNumber = (i / 3) * 3 + (j / 3);
          gridSets.get(gridNumber).add(num);
        }
      }
    }

    helper(board, 0, 0);
  }

  private boolean helper(char[][] board, int i, int j) {
    if (i == 9) {
      return true;
    }

    int nexti = i + (j + 1) / 9;
    int nextj = (j + 1) % 9;
    if (board[i][j] != '.') {
      return helper(board, nexti, nextj);
    }
    for (int num = 1; num <= 9; num++) {
      int gridNumber = (i / 3) * 3 + (j / 3);
      if (!rowSets.get(i).contains(num) && !columnSets.get(j).contains(num)
          && !gridSets.get(gridNumber).contains(num)) {
        board[i][j] = (char) (num + '0');
        rowSets.get(i).add(num);
        columnSets.get(j).add(num);
        gridSets.get(gridNumber).add(num);

        if (helper(board, nexti, nextj)) {
          return true;
        }

        board[i][j] = '.';
        rowSets.get(i).remove(num);
        columnSets.get(j).remove(num);
        gridSets.get(gridNumber).remove(num);
      }
    }
    return false;
  }
}