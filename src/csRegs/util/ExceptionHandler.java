package csRegs.util;

import csRegs.dataStore.Reader;

/**
 * interface for ExceptionHandler
 */
public interface ExceptionHandler {
	/**
	 * IO ExceptionHandler
	 * @param filename
	 * @return
	 */
	Reader handleIO(String filename);
	
	/**
	 * handle string from int
	 * @param debug_value
	 * @return
	 */
	int handle(String value);

	/**
	 * handler for arguments number
	 * @param arg_num
	 */
	void handle(int arg_num);
}
