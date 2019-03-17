/**
 * 
 */
package pdf.meta;

import java.io.Serializable;

/**
 * @author power-team
 *
 */
public class FileMeta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5426045969139302936L;
	
	private String idx, name, title, tagged, lan;

	/**
	 * 
	 */
	public FileMeta() {
		
	}
	public FileMeta(String name) {
		super();
		this.name = name;
	}
	/**
	 * @param idx
	 * @param name
	 * @param title
	 * @param tagged
	 * @param lan
	 */
	public FileMeta(String idx, String name, String title, String tagged, String lan) {
		super();
		this.idx = idx;
		this.name = name;
		this.title = title;
		this.tagged = tagged;
		this.lan = lan;
	}



	/**
	 * @return the idx
	 */
	public String getIdx() {
		return idx;
	}

	/**
	 * @param idx the idx to set
	 */
	public void setIdx(String idx) {
		this.idx = idx;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the tagged
	 */
	public String getTagged() {
		return tagged;
	}

	/**
	 * @param tagged the tagged to set
	 */
	public void setTagged(String tagged) {
		this.tagged = tagged;
	}

	/**
	 * @return the lan
	 */
	public String getLan() {
		return lan;
	}

	/**
	 * @param lan the lan to set
	 */
	public void setLan(String lan) {
		this.lan = lan;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FileMeta [idx=" + idx + ", name=" + name + ", title=" + title + ", tagged=" + tagged + ", lan=" + lan
				+ "]";
	}
	

}
