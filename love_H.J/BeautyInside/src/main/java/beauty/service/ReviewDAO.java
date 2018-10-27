package beauty.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import beauty.model.ReviewDTO;

@Repository // �� Ŭ������ dao bean���� ���
public class ReviewDAO {

	@Autowired
	SqlSession sqlSession;

	// �� ���
	public void create(ReviewDTO dto) throws Exception {  //�޼ҵ尡 voidŸ������ ����Ǹ� return Ÿ���� ���ٴ� ����. 
														  //�� �ƹ��͵� return���� �ʴ´ٴ� ���̸� ������ �߻����� �ʴ´ٴ� ���̴�. 
		sqlSession.insert("Review.create", dto);
	}

	// �� �󼼺���

	public List<ReviewDTO> read(ReviewDTO dto) throws Exception {
		return sqlSession.selectList("Review.read", dto);
	}
	
	// �� ����
	public void update(ReviewDTO dto) throws Exception {
		sqlSession.update("Review.update", dto);
	}

	// �� ����

	public void delete(ReviewDTO dto) throws Exception {
		sqlSession.delete("Review.delete", dto);
	}

	// �� ��ü ���

	public List<ReviewDTO> listAll() throws Exception {
		return sqlSession.selectList("Review.listAll");
	}

	/* // �Խñ� ��ȸ�� ����
	  
	 public void increaseView(int rno)throws Exception{
	 sqlSession.update("Review.increaseView",rno); */
	 
}	 
