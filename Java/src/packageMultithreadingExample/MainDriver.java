package packageMultithreadingExample;

public class MainDriver {

	public MainDriver() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		Multithreading t1 = new Multithreading("India");
		Multithreading t2 = new Multithreading("USA");

		t1.start();
		t2.start();
	}
}
