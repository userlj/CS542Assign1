package csRegs.dataStore;

import java.util.ArrayList;
import java.util.List;
import csRegs.util.Logger;

/**
 * spawn NN threads to read data from regInfo file
 * and store the data in to RegistrationStore
 */
public class PopulateWorker implements Worker{
	private List<Thread> thrd_arr = new ArrayList<Thread>();
	private static final int SIZE = 5;
	private static Reader readFile;
	private int thread_no;
	private static Store store; 

	/**
	 * private constructor
	 */
	private PopulateWorker() {
		if(Logger.getDebug_value()==4){
			Logger.dump(4,"PopulateWorker(private)");
		}
	}
	
	/**
	 * public constructor
	 */
	public PopulateWorker(Store store, Reader readFile) {
		if(Logger.getDebug_value()==4){
			Logger.dump(4,"PopulateWorker(public)");
		}
		PopulateWorker.store = store;
		PopulateWorker.readFile = readFile;
	}

	
	@Override
	public void spawnThread(int thread_no) {
		this.thread_no = thread_no;
			if(thread_no<1||thread_no>SIZE){
			throw new IllegalArgumentException("thread number is between 1 and 5");
		}
		
		Thread t = null;
		Runnable runner = null;
		
		for(int i=0; i<thread_no; i++){
			runner = new PopulateWorker();
			t = new Thread(runner);
			thrd_arr.add(t);	
		}
		
		for(int i=0; i<thread_no; i++){
			thrd_arr.get(i).start();
		}
	}

	@Override
	public void run() {
		if(Logger.getDebug_value()==3){
			Logger.dump(3, "PopulateWorker");
		}
		Info info;
		while((info=readFile.readInfoFromFile())!=null){
			store.add(info);
		}
	}
	
	@Override
	public void join() {
			for(int i=0; i<thread_no; i++){
			try {
				thrd_arr.get(i).join();
			} catch (InterruptedException e) {
				e.printStackTrace();
				System.exit(1);
			}
		}
	}


	@Override
	public String toString() {
		return "PopulateWorker [thrd_arr=" + thrd_arr + ", thread_no="
				+ thread_no + "]";
	}
	
}
