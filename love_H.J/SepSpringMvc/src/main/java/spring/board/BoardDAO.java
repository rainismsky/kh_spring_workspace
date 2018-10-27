package spring.board;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;


public class BoardDAO extends SqlSessionDaoSupport {

	public List<BoardDTO> select() {
		List<BoardDTO> select = getSqlSession().selectList("board.list"); // 셀렉트문 ID지정 //아이디값, 업로드할 파일명

		return select;
	}
	
	//삽입
	public int insertboard(BoardDTO dto) {
		int insertboard = getSqlSession().insert("board.insert", dto);

		return insertboard;
	}
	
	//읽기
	public BoardDTO read(int num) {
		BoardDTO select = getSqlSession().selectOne("board.detailBoard", num); // 셀렉트문 ID지정 //아이디값, 업로드할 파일명

		return select;
	}
	
	//삭제
	public void delete(int num) {
		int delete = getSqlSession().delete("board.deleteBoard", num);
	}
	
	//수정
	public void update(BoardDTO dto) {
	 int update = getSqlSession().update("board.updateBoard", dto);
	}
	
	//페이징
	public List<BoardDTO> selectpage(Map<String,Integer> map) {
		List<BoardDTO> selectpage = getSqlSession().selectList("board.selectpage", map);

		return selectpage;
	}
	
	public int count() {
		int count = getSqlSession().selectOne("board.count");
		return count;
	}
	
	public List<BoardDTO> search(Map<String,String> map) {
		List<BoardDTO> search = getSqlSession().selectList("board.search", map);
		return search;
	}	
}