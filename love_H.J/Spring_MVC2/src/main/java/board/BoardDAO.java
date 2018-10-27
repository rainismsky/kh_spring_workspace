package board;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository //현 클래스를 dao bean으로 등록
public class BoardDAO {
	
	//implements <ex> a = c��� interface�� ���� �ϰڴ� ���̴�.
		
	@Autowired
	SqlSession sqlSession;
	
	//1.게시글 작성
	
	public void create(BoardDTO dto)throws Exception{ 	//메소드가 void타입으로 선언되면 return 타입이 없다는 얘기다. 
		  												//즉 아무것도 return되지 않는다는 뜻이며 에러가 발생하지 않는다는 뜻이다. 
		
		sqlSession.insert("board.insert",dto);
	}
	
	//2.게시글 상세보기

	public BoardDTO read(int bno)throws Exception{
		return sqlSession.selectOne("board.view",bno);	
	}
	
	//3.게시글 수정

	public void update(BoardDTO dto)throws Exception{
		sqlSession.update("board.updateArticle",dto);
	}
	
	//4.게시글 삭제
	
	public void delete(int bno)throws Exception{
		sqlSession.delete("board.deleteArticle",bno);
	}

	//5.게시글 전체 목록

	public List<BoardDTO>listAll()throws Exception{
		return sqlSession.selectList("board.listAll");
	}
	
	//6.게시글 조회수 증가

	public void increaseViewcnt(int bno)throws Exception{
		sqlSession.update("board.increaseViewcnt",bno);
	}
	
	/*//7.페이징
	public List<BoardDTO> selectpage(Map<String,Integer> map) {
		List<BoardDTO> selectpage = getSqlSession().selectList("board.selectpage", map);

		return selectpage;
	}
	
	public int count() {
		int count = getSqlSession().selectOne("board.count");
		return count;
	}
	
	
	//8.search
	public List<BoardDTO> search(Map<String,String> map) {
		List<BoardDTO> search = getSqlSession().selectList("board.search", map);
		return search;
	}


	
	private SqlSession getSqlSession() {
		// TODO Auto-generated method stub
		return null;
	}*/
	
}