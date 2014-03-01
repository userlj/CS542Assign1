/**
 * 
 */
package csRegs.util;

import java.io.FileNotFoundException;

import csRegs.dataStore.Reader;
import csRegs.dataStore.ReaderFile;

/**
 * class ExceptionHandlerImp
 */
public class ExceptionHandlerImp implements ExceptionHandler {

	@Override
	public Reader handleIO(String filename) {
		Reader reader = null;
		try {
			reader = new ReaderFile(filename);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}
		return reader;
	}
	
	@Override
	public int handle(String value){
		int v = -1;
		try {
			v = Integer.parseInt(value);
		} catch (NumberFormatException e) {
			System.err.println("NN, MM and debug value must be integer.");
			System.exit(1);
		}
		return v;
	}
	
	@Override
	public void handle(int arg_num){
		if(arg_num!=5){
			throw new IllegalArgumentException("Usage: inputDataFileName NN searchFileName MM DEBUG_VALUE");
		}
	}

	@Override
	public String toString() {
		return "ExceptionHandlerImp []";
	}

	
}
