package csRegs.dataStore;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import csRegs.util.Logger;

/**
 *	read data from dataFile and searchFile
 */
public class ReaderFile implements Reader{
	private File dataFile;
	private BufferedReader br;
	private String[] regInfoLine;
	
	/**
	 * constructor
	 */
	public ReaderFile(String fileName) throws FileNotFoundException {
		if(Logger.getDebug_value()==4){
			Logger.dump(4,"ReaderFile");
		}
		dataFile = new File(fileName);
		br = new BufferedReader(new FileReader(dataFile));
	}
	
	@Override
	// read registration records from dataFile
	public synchronized Info readInfoFromFile(){	// synchronized method: thread safe
		Info new_StudInfo = null;
		try{
				String newLine = br.readLine();	// read a line from file
				if(newLine!=null){
					// split a record into 3 strings and an integer
					regInfoLine = newLine.split(" ");	
					new_StudInfo = new StudentInfo(
										regInfoLine[0],
										regInfoLine[1],
										regInfoLine[2],
										(Integer.parseInt(regInfoLine[3])));
				}
		}
		catch(IOException e)
		{
			System.out.println(e);
			System.exit(1);
		}
		return new_StudInfo;
	}

	@Override
	public synchronized String readWordFromFile(){	// synchronized method: thread safe
		String new_Word = null;
		try{
				String newLine = br.readLine();
				if(newLine!=null){
					new_Word = newLine;
				}
		}
		catch(IOException e)
		{
			System.out.println(e);
			System.exit(1);
		}
		return new_Word;
	}


	@Override
	public String toString() {
		return "ReaderFile [dataFile=" + dataFile + ", br=" + br
				+ ", regInfoLine=" + Arrays.toString(regInfoLine) + "]";
	}
	
}
