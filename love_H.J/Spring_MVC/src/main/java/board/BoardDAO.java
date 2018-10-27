package board;

import java.util.List;

/*
DAO 와 DTO(=vo) 정의

DAO (Data Access Object) DB 접근 객체 
DAO 설명
웹서버는 DB와 연결하기 위해서 매번 커넥션 객체를 생성하는데, 이것을 해결하기 위해 나온것이 컨넥션 풀입니다. 
ConnectionPool 이란 connection 객체를 미리 만들어 놓고 그것을 가져다 쓰는것입니다. 
또 다쓰고 난 후에는 반환해 놓는 것. 
하지만 유저 한명이 접속해서 한번에 하나의 커넥션만 일으키지 않고 게시판
 하나만 봐도 목록볼때 한번, 글읽을때마다 한번, 글쓸때 한번 등등… 
 엄청나게 많은 커넥션이 일어나기에, 커넥션풀은 커넥션을 또 만드는 오버헤드를 효율적으로 하기 위해 DB에 접속하는 
 객체를 전용으로 하나만 만들고, 모든 페이지에서 그 객체를 호출해다 사용한다면? 이렇게 커넥션을 하나만 가져오고 
 그 커넥션을 가져온 객체가 모든 DB와의 연결을 하는것이 바로 DAO 객체입니다

DAO(Data Access Object)는 DB를 사용해 데이터를 조화하거나 조작하는 기능을 전담하도록 만든 오브젝트를 말한다.

사용자는 자신이 필요한 Interface를 DAO에게 던지고 DAO는 이 인터페이스를 구현한 객체를 사용자에게 편리하게 사용 할 수 있도록 반환해줍니다.

DB에 대한 접근을 DAO가 담당하도록 하여 데이터베이스 엑세스를 DAO에서만 하게 되면 다수의 원격호출을 통한 오버헤드를 VO나 DTO를 통해 줄일 수 있고 다수의 DB 호출문제를 해결할 수 있습니다. 또한 단순히 읽기만 하는 연산이므로 트랜잭션 간의 오버헤드를 감소할 수 있습니다.
** DTO(Data Transfer Object)는 VO(Value Object)로 바꿔 말할 수 있는데 
계층간 데이터 교환을 위한 자바빈즈를 말합니다.
여기서 말하는 계층간의 Controller, View, Business Layer, Persistent Layer를 말하며 
각 계층간 데이터 교환을 위한 객체를 DTO 또는 VO라고 부릅니다 
그런데 VO는 DTO와 동일한 개념이지만 read only 속성을 가짐
일반적인 DTO는 로직을 갖고 있지 않는 순수한 데이터 객체이며 속성과 그 속성에 접근하기 위한 getter, setter 
메소드만 가진 클래스를 말합니다
*/

public interface BoardDAO {
	// 1.게시글 작성
	public void create(BoardVO vo) throws Exception;

	// 2.게시글 상세 보기
	public BoardVO read(int bno) throws Exception;

	// 3.게시글 수정
	public void update(BoardVO vo) throws Exception;

	// 4.게시글 삭제
	public void delete(int bno) throws Exception;

	// 5.게시글 전체 목록
	public List<BoardVO> listAll() throws Exception;

	// 6.게시글 조회 증가
	public void increaseViewcnt(int bno) throws Exception;
}