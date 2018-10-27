package Ajax.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class CityServiceImpl implements CityService {
	
	@Autowired
	private CityDAO dao;

	public void setDao(CityDAO dao) {
		this.dao = dao;
	}

	@Override
	public List<String> listSido() {
		List<String> list = null;

		try {
			list = dao.getListData("city.listSido");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		System.out.println(list);
		return list;
	}

	@Override
	public List<Map<String, Object>> listCity(String city) {
		List<Map<String,Object>> list = null;

		try {
			list = dao.getListData("city.listCity", city);
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return list;
	}

	/*public List<String> listSido() {
		List<String> list = null;

		try {
			list = dao.getListData("city.listSido");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		System.out.println(list);
		return list;
	}
 
	public List<Map<String,Object>> listCity(String city) {
		List<Map<String,Object>> list = null;

		try {
			list = dao.getListData("city.listCity", city);
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return list;
	}*/

}
