package spring.member;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.sun.org.apache.bcel.internal.generic.RETURN;

public class jdbcDao extends JdbcDaoSupport {
	
	/*JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate=jdbcTemplate;
	}
	*/
	
	//메소드-쿼리 실행
	public List<User> selectAll() {
		String sql="select * from member";
		UserRowMapper mapper = new UserRowMapper();
		List<User> list = getJdbcTemplate().query(sql, mapper);
		return list;
	}
	public Integer count() {
		Integer count = getJdbcTemplate().queryForObject(
				"select count(*) from member",Integer.class);
	return count;
	}
	
	//insert
	public int insertMember() {
		String sql = "insert into member values(?,?,?,?)";
		Object[] arr = new String[] {"1021","효댕1","효댕2","효댕3"};
		int x = getJdbcTemplate().update(sql,arr);
		return x;
	}
	
/*	public User selectId() {
		
		UserRowMapper mapper = new UserRowMapper();
		User user = get.JdbcTemplate().queryForObject
		getJdbcTemplate().queryForObject("select * from member where memberid=?",new Object[]{"hyo"});
		
		return user;
	}*/
	
/*	public int updateMember() {
		String sql = "update set where "
	}
	
	public int deleteMember() {
		String sql = "delete"
	}*/
	
	//select-one
	
	//update
	//delete
}