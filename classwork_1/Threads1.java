package classwork_1;

public class Threads1 {
	public static void threadStart1() {
		Counter thread = new Counter();
        KindNeighbor thread2 = new KindNeighbor();
        
        thread.start();
        thread2.start();
	}
	
	public static void threadStart2() {
		Thread thread3 = new Thread(new Counter2());
        Thread thread4 = new Thread(new KindNeighbor2());
        
        thread3.start();
        thread4.start();
	}
	
	public static void threadStart3() {
		Thread thread5 = new Thread() {
            @Override
            public void run() {
            	for(int i = 1; i <= 50; i++) {
        			System.out.println(i);
        		}
            }
        };
        
        Thread thread6 = new Thread() {
            @Override
            public void run() {
                for (int i = 1; i <= 5; i++) {
                    System.out.println("Hello!");
                }
            }
        };
        
        thread5.start();
        thread6.start();
	}
	
	public static void threadStart4() {
		Thread thread7 = new Thread(() -> {
            for(int i = 1; i <= 50; i++) {
        		System.out.println(i);
        	}
        });
        
        Thread thread8 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Hello!");
            }
        });
        
        thread7.start();
        thread8.start();
	}

	public static void main(String[] args) {
		System.out.println("--------------Ex 1:-------------");
        threadStart1();
        System.out.println("--------------Ex 2:-------------");
        threadStart2();
        System.out.println("--------------Ex 3:-------------");
        threadStart3();
        System.out.println("--------------Ex 4:-------------");
        threadStart4();
    }
}


class Counter extends Thread {
	public void run() {
		for(int i = 1; i <= 50; i++) {
			System.out.println(i);
		}
	}
}

class KindNeighbor extends Thread {
	public void run() {
		for(int i = 1; i <= 5; i++) {
			System.out.println("Hello!");
		}
	}
}

class Counter2 implements Runnable {
	public void run() {
		for(int i = 1; i <= 50; i++) {
			System.out.println(i);
		}
	}
}

class KindNeighbor2 implements Runnable {
	public void run() {
		for(int i = 1; i <= 5; i++) {
			System.out.println("Hello!");
		}
	}
}