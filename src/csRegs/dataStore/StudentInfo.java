package csRegs.dataStore;

import csRegs.util.Logger;

/**
 * stores StudentInfo records
 */
public class StudentInfo implements Info {
	private String sfirst;
	private String slast;
	private String pfirst;
	private int course_no;
	
	/**
	 * empty constructor
	 */
	public StudentInfo() {
		super();
		if(Logger.getDebug_value()==4){
			Logger.dump(4,"StudentInfo(empty)");
		}
	}
	
	/**
	 * constructor
	 */
	public StudentInfo(String sfirst, String slast, String pfirst, int course_no) {
		super();
		if(Logger.getDebug_value()==4){
			Logger.dump(4,"StudentInfo");
		}
		this.sfirst = sfirst;
		this.slast = slast;
		this.pfirst = pfirst;
		this.course_no = course_no;
	}
	
	/**
	 * @return the sfirst
	 */
	public String getSfirst() {
		return sfirst;
	}
	/**
	 * @param sfirst the sfirst to set
	 */
	public void setSfirst(String sfirst) {
		this.sfirst = sfirst;
	}
	/**
	 * @return the slast
	 */
	public String getSlast() {
		return slast;
	}
	/**
	 * @param slast the slast to set
	 */
	public void setSlast(String slast) {
		this.slast = slast;
	}
	/**
	 * @return the pfirst
	 */
	public String getPfirst() {
		return pfirst;
	}
	/**
	 * @param pfirst the pfirst to set
	 */
	public void setPfirst(String pfirst) {
		this.pfirst = pfirst;
	}
	/**
	 * @return the course_no
	 */
	public int getCourse_no() {
		return course_no;
	}
	/**
	 * @param course_no the course_no to set
	 */
	public void setCourse_no(int course_no) {
		this.course_no = course_no;
	}


	@Override
	public String toString() {
		return "sfirst=" + sfirst + ", slast=" + slast
				+ ", pfirst=" + pfirst + ", course_no=" + course_no;
	}	
}
