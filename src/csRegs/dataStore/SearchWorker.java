package csRegs.dataStore;

import java.util.ArrayList;
import java.util.List;

import csRegs.util.Logger;

/**
 * spawn MM threads to read from srchFile 
 */
public class SearchWorker implements Worker {
	private List<Thread> thrd_arr = new ArrayList<Thread>();
	private static final int SIZE = 5;
	private int thread_no;
	private static Reader readFile;
	private static Store store;
	private static Store results;
	
	/**
	 * @param readFile
	 * private constructor
	 */
	private SearchWorker() {
		if(Logger.getDebug_value()==4){
			Logger.dump(4,"SearchWorker(private)");
		}
	}

	/**
	 * public constructor
	 */
	public SearchWorker(Store results, Store store, Reader readFile) {
		if(Logger.getDebug_value()==4){
			Logger.dump(4,"SearchWorker(public)");
		}
		SearchWorker.results = results;
		SearchWorker.store = store;
		SearchWorker.readFile = readFile;
	}

	@Override
	public void spawnThread(int thread_no) {
		this.thread_no = thread_no;
		Runnable runner = null;
		Thread t = null;
		
		if(thread_no<1||thread_no>SIZE){
			throw new IllegalArgumentException("thread number is between 1 and 5");
		}
		
		for(int i=0; i<thread_no; i++){
			runner = new SearchWorker();
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
			Logger.dump(3, "SearchWorker");
		}

		String word;
		Info info_found;
		while((word=readFile.readWordFromFile())!=null){
			info_found=store.find(word);
			if(info_found!=null)
				results.add(info_found);
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
		return "SearchWorker [thrd_arr=" + thrd_arr + ", thread_no="
				+ thread_no + "]";
	}


}
