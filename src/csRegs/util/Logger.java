package csRegs.util;

/**
 * for different debug value, print different message
 */
public class Logger {
	private static int debug_value;
	
	/**
	 * @return the debug_value
	 */
	public static int getDebug_value() {
		return debug_value;
	}

	/**
	 * @param debug_value the debug_value to set
	 */
	public static void setDebug_value(int debug_value) {
		if(debug_value<0 || debug_value>4){
			throw new IllegalArgumentException("debug value should from 0 to 4.");
		}
		Logger.debug_value = debug_value;
	}


	// String is the user message
	public static void dump(int debug_value, String message){
		switch(Logger.debug_value){
		case 0:
			break;
		case 1:	// print the search results
			System.out.println("search results.");
			System.out.print(message);
			break;
		case 2:	// an entry is added to the Results data structure
			System.out.println(message+" entry is added.");
			break;
		case 3:	// a thread's run() method is called
			System.out.println("run() method of "+message+" is called.");
			break;
		case 4:	// a constructor is called
			System.out.println(message+" constructor is called.");
			break;
		}
	}


	@Override
	public String toString() {
		return "Logger []";
	}
	
}
