package disposal;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import disposal.DisposalDTO;


public class DisposalDAO extends SqlSessionDaoSupport {

	public List<DisposalDTO> dlist() {
		List<DisposalDTO> dlist = getSqlSession().selectList("edisposal.list");
		return dlist;
	}

	public List<DisposalDTO> selectpage(Map<String, Integer> map) {
		List<DisposalDTO> selectpage = getSqlSession().selectList("edisposal.selectpage", map);

		return selectpage;
	}

	public int count() {
		int count = getSqlSession().selectOne("edisposal.count");
		return count;
	}
}
