package myTest;

public interface MyInterface {
	default void test() {
		System.out.println("default를 사용하여 인터페이스에서 구현 가능");
	}
	void test2();
}
