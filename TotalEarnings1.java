import task2.TotalEarnings;
import task2.thread;

public class TotalEarnings1 extends Thread {
	int total=0;
	public void run() {
		for (int i = 1;i<=10;i++) {
			total +=100;
		}
		synchronized (this) {
			notify();
		}
	}

}
public class movie {
	public static void main (String[]args) {
		TotalEarnings1 te =new TotalEarnings1();
			synchronized (te) {
					te.start();
					
					try {
						te.wait();
					}catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("Total earnings:" + te.total + "Rs");
				}
			}
		}


