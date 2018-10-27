package spring.DI;

public class Foo1 {

	//lookup메서드
		public Bar getBar() {
			return null; //스프링 컨테이너가 Bar타입 객체를 주입해주면 return 오러라이딩 처리됨.
		
		}

}
