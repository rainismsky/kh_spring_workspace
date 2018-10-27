package board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//(인터페이스 구현 클래스)

@Repository //현 클래스를 dao bean으로 등록
public class BoardDAOImpl implements BoardDAO{ 
	
	//implements <ex> a = c��� interface�� ���� �ϰڴ� ���̴�.
		
	@Autowired
	SqlSession sqlSession;
	
	//1.게시글 작성
	
	public void create(BoardVO vo)throws Exception{
		sqlSession.insert("board.insert",vo);
	}
	
	//2.게시글 상세보기

	public BoardVO read(int bno)throws Exception{
		return sqlSession.selectOne("board.view",bno);	
	}
	
	//3.게시글 수정

	public void update(BoardVO vo)throws Exception{
		sqlSession.update("board.updateArticle",vo);
	}
	
	//4.게시글 삭제
	
	public void delete(int bno)throws Exception{
		sqlSession.delete("board.deleteArticle",bno);
	}

	//5.게시글 전체 목록
	
	public List<BoardVO>listAll()throws Exception{
		return sqlSession.selectList("board.listAll");
	}
	
	//게시글 조회수 증가
	
	public void increaseViewcnt(int bno)throws Exception{
		sqlSession.update("board.increaseViewcnt",bno);
	}
}