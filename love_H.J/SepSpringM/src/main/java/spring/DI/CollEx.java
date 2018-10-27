package spring.DI;

import java.util.*;

public class CollEx {	
	List<Integer> l;
	Map<String, String> m;
	Properties p;
	//setter 만들고 각각의 컬렉션의 2개 이상 값 저장하기
	
	public List<Integer> getL() {
		return l;
	}
	public void setL(List<Integer> l) {
		this.l = l;
	}
	public Map<String, String> getM() {
		return m;
	}
	public void setM(Map<String, String> m) {
		this.m = m;
	}
	public Properties getP() {
		return p;
	}
	public void setP(Properties p) {
		this.p = p;
	}
public void printColl() {
	System.out.println(l);
	System.out.println(m);
	System.out.println(p);
	
}
	
}
