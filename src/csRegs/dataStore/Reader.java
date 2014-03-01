package csRegs.dataStore;

/**
 * interface for Reader
 * read data from files
 */
public interface Reader {
	/**
	 * read from dataFile
	 * @return
	 */
	public Info readInfoFromFile();
	/**
	 * read from search file
	 * @return
	 */
	public String readWordFromFile();
}
