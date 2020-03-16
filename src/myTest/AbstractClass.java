package myTest;
public class AbstractClass {

	static abstract class parent{
		int n;
		abstract void test();
		void test2() {
			this.n = 3;
		}
	}
	static class child extends parent{
		@Override
		void test() {
			this.n = 1;			
		}
		
	}
	static class myint implements MyInterface{

		@Override
		public void test2() {
			System.out.println("test2");
		}
		
	}
	public static void main(String[] args) {
		child ch = new child();
		ch.test();
		System.out.println(ch.n);
		
		myint in = new myint();
		in.test2();
		
	}
}
