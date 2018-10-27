package spring.DI;

public class Baz {
	
	Bar bar;
	Baz baz;
	
	public void doBar() {
		bar.doIt();
	}
}
