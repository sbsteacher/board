package hrd;

public class InsertMain {
	public static void main(String[] args) {
		String title = "zxcvzs222"; //제목
		String content = "1dsdfsdf21212333"; //내용
		
		BoardVO vo = new BoardVO();
		vo.setTitle(title);
		vo.setContent(content);
		
		int result = BoardDAO.boardInsert(vo);
		
		if(result == 1) {
			System.out.println("저장 성공!");
		} else {
			System.out.println("저장 실패!");
		}
	}
}
