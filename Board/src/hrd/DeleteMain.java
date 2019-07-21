package hrd;

public class DeleteMain {
	public static void main(String[] args) {
		int deleteI = 1;
		
		int result = BoardDAO.boardDelete(deleteI);
		
		if(result == 1) {
			System.out.println("삭제 성공!");
		} else {
			System.out.println("삭제 실패!");
		}
	}
}
