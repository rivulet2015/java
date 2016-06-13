

/*
 * 模式 #1：状态标志
 */
public class Demo01 {
	
	public static void main(String[] args) throws InterruptedException {
		
		final Worker worker = new Worker();
		
        for (int i = 0; i < 1000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                	worker.doWork();
                }
            }).start();
        }
        Thread.sleep(5000);
        worker.shutdown();
	}
	
}

class Worker{
	
	volatile  boolean shutdownRequested;

	public void shutdown() { shutdownRequested = true; }

	public  void doWork() { 
	    while (!shutdownRequested) { 
	        
	    	System.out.println("thread id : "+Thread.currentThread().getId() + " is running");
	    }
    	System.out.println("thread id : "+Thread.currentThread().getId() + " is stopped");

	}
	
}
