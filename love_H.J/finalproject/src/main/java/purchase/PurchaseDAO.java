package purchase;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import purchase.PurchaseDTO;


public class PurchaseDAO extends SqlSessionDaoSupport {

	public List<PurchaseDTO> plist() {
		List<PurchaseDTO> plist = getSqlSession().selectList("epurchase.list"); 
		return plist;
	}
	
	public List<PurchaseDTO> selectpage(Map<String,Integer> map) {
		List<PurchaseDTO> selectpage = getSqlSession().selectList("epurchase.selectpage", map);

		return selectpage;
	}
	
	public int count() {
		int count = getSqlSession().selectOne("epurchase.count");
		return count;
	}  

	public int insert(PurchaseDTO dto) {
		int insert = getSqlSession().insert("epurchase.insert", dto);
		return insert;
	}
	

}


