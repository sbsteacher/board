package hrd;

import java.util.List;

public class SelectMain {

	public static void main(String[] args) {
		List<BoardVO> result = BoardDAO.selectAll();
		
		System.out.println("i \t title \t content");
		for(BoardVO vo : result) {
			System.out.printf("%d \t %s \t %s \n", vo.getI(), vo.getTitle(), vo.getContent());
		}
	}

}
