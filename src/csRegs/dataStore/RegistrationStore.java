package csRegs.dataStore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * stores studInfo records
 */
public class RegistrationStore implements Store {
	private List<Info> regList = Collections.synchronizedList(new ArrayList<Info>());	// thread safe
	

	@Override
	public void displayData() {	// display all the elements in the list
		for(int i=0; i<regList.size(); i++){
			System.out.println(regList.get(i));
		}
	}
	
	@Override
	public Info find(String word){
		StudentInfo tmp = null;
		for(int i=0; i<this.regList.size(); i++){
			StudentInfo inner_tmp = (StudentInfo) this.regList.get(i);
			if((inner_tmp.getSfirst().equals(word))	// hits
					||(inner_tmp.getSlast().equals(word))
					||(inner_tmp.getPfirst().equals(word))){
				tmp = inner_tmp;
				break;
			}
		}
		return tmp;
	}
	
	/**
	 * add elements to regList
	 */
	public void add(Info info){
		regList.add(info);
	}


	@Override
	public String toString() {
		return "RegistrationStore [regList=" + regList + "]";
	}
	
	
}
