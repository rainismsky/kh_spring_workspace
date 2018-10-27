package board;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JacksonInject;

/*BoardServiceImpl(인터페이스 구현 클래스)
게시글 쓰기 처리(태그 문자 처리,공백 문자 처리,줄 바꿈 문자 처리)
게시글 조회수 증가 처리(일정 시간동안 조회수 증가하지 않도록 처리)
*/

/*Service�� Serviceimpl����������? 
���� ���ϰ� ���� ����(�и� ���� ����) 
Ư¡�� �ְ� �������� ������ ��ɵ��� ��� �ִ� */

@Service
public class BoardServiceImpl implements BoardService {
	//i

	@Autowired
	BoardDAO boardDao;

	// 1.게시글 쓰기
	public void create(BoardVO vo) throws Exception {
		String title = vo.getTitle();
		String content = vo.getContent();
		String writer = vo.getWriter();
		/* 태그 문자 처리(<==> &lt; > ==> &gt;)
		 * replace(A,B) A를 B로 변경
		 */
		title = title.replace("<", "&lt;");
		title = title.replace("<", "&lt;");
		writer = writer.replace("<", "&lt;");
		writer = writer.replace("<", "&gt;");
		//* 공백 문자 처리
		title = title.replace(" ", "&nbsp;&nbsp;");
		writer = writer.replace(" ", "&nbsp;&nbsp;");
		//* 줄바꿈 문자 처리
		content = content.replace("\n", "<br>");
		vo.setTitle(title);
		vo.setContent(content);
		vo.setWriter(writer);
		boardDao.create(vo);
	}

	// 2.게시글 상세 보기
	public BoardVO read(int bno) throws Exception {
		return boardDao.read(bno);
	}

	// 3.게시글 수정
	public void update(BoardVO vo) throws Exception {
		boardDao.update(vo);
	}

	// 4.게시글 삭제
	public void delete(int bno) throws Exception {
		boardDao.delete(bno);
	}

	// 5.게시글 전체 목록
	public List<BoardVO> listAll() throws Exception {
		return boardDao.listAll();
	}

	// 6.게시글 전체 목록
	public void increaseViewcnt(int bno,HttpSession session)throws Exception{
		Object update_time=0;
		
/*		세션에 저장된 조회 시간 검색
		최초로 조회할 경우 세션에 저장된 값이 없기 때문에 if문 실행(X)*/
		
	if(session.getAttribute("update_time_"+bno)!=null){
		// 세션에서 읽어 들이기
	update_time=session.getAttribute("update_time_"+bno);
}
//시스템의 현재 시간을 current_time에 저장
long current_time=System.currentTimeMillis();
	/*일정 시간이 경과 후 조회수 증가 처리 24*60*60*1000(24�ð�)
	시스템 현재 시간  - 열람 시간 > 일정 시간(조회수 증가가 가능하도록 지정한 시간)
*/

/*if(current_time-update_time>5*1000){ */

	boardDao.increaseViewcnt(bno);
	//세션에 시간을 저장 :"update_time_"+bno는 다른 변수와 중복되지 않게 명명한 것 
	session.setAttribute("update_time_"+bno,current_time);
}
}
