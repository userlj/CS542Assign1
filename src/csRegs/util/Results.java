package csRegs.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import csRegs.dataStore.Info;
import csRegs.dataStore.Store;

/**
 * store results
 */
public class Results implements Store {
	private List<Info> results_arr = Collections.synchronizedList(new ArrayList<Info>());	// thread safe

	@Override
	public void displayData() {
		for(int i=0; i<results_arr.size(); i++){
			System.out.println(results_arr.get(i));
		}
	}

	@Override
	public void add(Info info) {
		results_arr.add(info);
		if(Logger.getDebug_value()==2){
			Logger.dump(2, info.toString());
		}
	}

	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		int i;
		for(i=0; i<results_arr.size() - 1; i++){
			sb.append(results_arr.get(i));
			sb.append(System.getProperty("line.separator"));
		}
		sb.append(results_arr.get(i));
		return sb.toString();
	}

	@Override
	public Info find(String word) {
		throw new UnsupportedOperationException("Illegal invocation.");
	}
}
