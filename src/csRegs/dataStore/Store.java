package csRegs.dataStore;

/**
 * interface for Store
 * stores data read from file
 */
public interface Store {
	/**
	 * add an info to arrayList
	 * @param info
	 */
	void add(Info info);
	/**
	 * print all the data it has to stdout
	 */
	void displayData();
	/**
	 * search to find if words from searchFile
	 * matches the records in RegistrationStore
	 * @param word
	 * @return
	 */
	Info find(String word);
}
