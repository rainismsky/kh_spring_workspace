package spring.DI;

public class Foo {
	Bar bar;
	Baz baz;
	String s;
	int i;
	
	public void start() {
		System.out.println("init메서드 : start!!");
	}
	public void stop() {
		System.out.println("destroy메서드 stop!!");
	}
	
/*	Foo(String s1, String s2){
		System.out.println("String,string::");
	}*/
	
	//lookup메소드
	public Bar getBar() {
		return null;
		//스프링 컨테이너가 Bar타입 객체를 주입해주면 return하게 오버라이딩 처리됨.
	}
	
	public void doFoo() {
		System.out.println(s+""+i);
		bar.doIt();
	}
	
	public void byname() {
		System.out.println();
		bar.doIt();
	}
	
/*	Foo(String s, int i){
		System.out.println("String, int::");
	}
	
	public Foo(Bar bar,Baz baz, String s, int i) {
		this.bar = bar;
		this.baz = baz;
		this.s = s;
		this.i = i;
	}*/

}

