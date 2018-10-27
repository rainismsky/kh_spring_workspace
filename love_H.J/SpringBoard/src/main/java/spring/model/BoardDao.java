package spring.model;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;


public class BoardDao extends SqlSessionDaoSupport {
	public int insertBoard(BoardDto boardDto) {
		return getSqlSession().insert("board.insert",boardDto);
	}
	
	public List<BoardDto> boardList(Map map) {
		return getSqlSession().selectList("board.list", map);
	}
	public List<BoardDto> boardSearchList(Map map) {
		return getSqlSession().selectList("board.searchList", map);
	}
	
	public BoardDto boardDetail(String no) {
		return getSqlSession().selectOne("board.detail", no);
	}
	
	public void boardViewUpdate(String no) {
		getSqlSession().update("board.viewUpdate",no);
	}
	
	public int boardUpdate(BoardDto boardDto) {
		return getSqlSession().update("board.update", boardDto);
	}
	
	public int boardDelete(String no) {
		return getSqlSession().delete("board.delete", no);
	}
	public int boardCount() {
		return getSqlSession().selectOne("board.count");
	}
	public int boardSearchCount(String search) {
		return getSqlSession().selectOne("board.searchCount",search);
	}
}
