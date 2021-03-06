package beauty.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import beauty.model.ReviewDTO;

@Repository // 현 클래스를 dao bean으로 등록
public class ReviewDAO {

	@Autowired
	SqlSession sqlSession;

	// 글 등록
	public void create(ReviewDTO dto) throws Exception {  //메소드가 void타입으로 선언되면 return 타입이 없다는 얘기다. 
														  //즉 아무것도 return되지 않는다는 뜻이며 에러가 발생하지 않는다는 뜻이다. 
		sqlSession.insert("Review.create", dto);
	}

	// 글 상세보기

	public List<ReviewDTO> read(ReviewDTO dto) throws Exception {
		return sqlSession.selectList("Review.read", dto);
	}
	
	// 글 수정
	public void update(ReviewDTO dto) throws Exception {
		sqlSession.update("Review.update", dto);
	}

	// 글 삭제

	public void delete(ReviewDTO dto) throws Exception {
		sqlSession.delete("Review.delete", dto);
	}

	// 글 전체 목록

	public List<ReviewDTO> listAll() throws Exception {
		return sqlSession.selectList("Review.listAll");
	}

	/* // 게시글 조회수 증가
	  
	 public void increaseView(int rno)throws Exception{
	 sqlSession.update("Review.increaseView",rno); */
	 
}	 
