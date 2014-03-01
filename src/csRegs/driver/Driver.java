package csRegs.driver;

import csRegs.dataStore.Reader;
import csRegs.dataStore.PopulateWorker;
import csRegs.dataStore.RegistrationStore;
import csRegs.dataStore.SearchWorker;
import csRegs.dataStore.Store;
import csRegs.util.ExceptionHandler;
import csRegs.util.ExceptionHandlerImp;
import csRegs.util.Logger;
import csRegs.util.Results;

/**
 * driver
 */
public class Driver {
	public static void main(String[] args){
		
		ExceptionHandler handler = new ExceptionHandlerImp();	// new exception hander
		
		handler.handle(args.length);	// make sure the arguments are in proper format
		
		// handle and pass arguments
		String inputDataFileName = args[0];
		int NN = handler.handle(args[1]);
		String SearchFileName = args[2];
		int MM = handler.handle(args[3]);
		int debug_value = handler.handle(args[4]);
		
		Logger.setDebug_value(debug_value);	// set debug value
		
		
		Store store = new RegistrationStore();	// to store data from dataFile
		Reader reader = handler.handleIO(inputDataFileName);	// reader to read dataFile
		PopulateWorker pop = new PopulateWorker(store, reader);	// create a PopulateWorker instance
		pop.spawnThread(NN);	// spawn NN threads and read from file
		pop.join();	// join on the threads that are created
		
		
		Reader srch_reader = handler.handleIO(SearchFileName);	// reader to read searchFile
		Store results = new Results();	// to store search results
		// create a searchWorker instance
		SearchWorker srch = new SearchWorker(results, store, srch_reader);	
		srch.spawnThread(MM);	// spawn MM threads to read from file
		srch.join();	// join on the threads that are created
		
		
		// if debug value is 1, print search results
		if(Logger.getDebug_value()==1){
			Logger.dump(1,results.toString());
		}
		
		System.out.println();
		System.out.println("===========Results from Driver===========");
		
		results.displayData();	// print search results
	}
	
}
