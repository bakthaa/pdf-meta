/**
 * 
 */
package pdf.meta;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author power-team
 *
 */
public class Result implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2630928958070401124L;
	
	private String folderName;
	
	private List<FileMeta> files;

	/**
	 * @param files
	 */
	public Result() {
		super();
		this.files = new ArrayList<>();
	}

	/**
	 * @return the files
	 */
	public List<FileMeta> getFiles() {
		return files;
	}

	/**
	 * @param files the files to set
	 */
	public void setFiles(List<FileMeta> files) {
		this.files = files;
	}

	/**
	 * @return the folderName
	 */
	public String getFolderName() {
		return folderName;
	}

	/**
	 * @param folderName the folderName to set
	 */
	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Result [folderName=" + folderName + ", files=" + files + "]";
	}
	
	
	
	

}
