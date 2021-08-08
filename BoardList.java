
public class BoardList {

  static final int MAX_LENGTH = 5;

  Board[] boards = new Board[MAX_LENGTH];
  int size = 0;
  
  public void add(Board board) {
 
    this.boards[this.size++] = board;
    
    public Board[] toArray() {
      Board[]arr = new Board[this.size];
      
      for(int i = 0; i < this.size; i++) {
        arr[i] = boards[i];
      }
    return arr; 
    }
    
    public Board findByNo(int no) {
      for (int i = 0; i < this.size; i++) {
        if (this.boards[i].no == no) {
          return this.boards[i];
        }
      }
      return null; //반복문이 끝난후(반복문동안 못찾았을때) 또는 해당되지 않을때 null값을 리턴함
    }
    
    private int indexOf(Board board) {
      for (int i = 0; i < this.size; i++) {
        if (boards.[i] == board) {
          return i;
        }
      }
      return -1; // 반복문에 끝났거나 해당되지 않을땐 -1 유효하지 않는 배열값을 리턴함
    }
    
    public boolean remove(Board board) {
      
      int index = indexOf(board); 
      
      for (int i = index + 1; i < this.size; i++) {
        this.boards[i - 1] = this.boards[i];
      }
      this.boards[--this.size] = null;
    }
    
} 
