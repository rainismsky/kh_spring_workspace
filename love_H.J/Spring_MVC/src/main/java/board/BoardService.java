package board;

import java.util.List;

import javax.servlet.http.HttpSession;

//���� ���� Service���̶�� ���̸� Service�ܿ��� interface ������ �ߴٸ� ������ ServiceImpl���� interface����� ���� �ؾ� �Ѵ�

public interface BoardService { //interface�� ����̸� ��� ������ ���� ����Ѵ�.
	//1.게시글 작성
	public void create(BoardVO vo)throws Exception;
	//2.게시글 상세 보기
	public BoardVO read(int bno)throws Exception;
	//3.게시글 수정
	public void update(BoardVO vo)throws Exception;
	//4.게시글 삭제
	public void delete(int bno)throws Exception;
	//5.게시글 전체 목록
	public List<BoardVO>listAll()throws Exception;
	//6.게시글 조회
	public void increaseViewcnt(int bno,HttpSession session)throws Exception;
}