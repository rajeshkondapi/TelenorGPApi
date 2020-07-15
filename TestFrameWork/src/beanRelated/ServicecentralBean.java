package beanRelated;

public class ServicecentralBean implements java.io.Serializable{
	/**
	 * 
	 */
	
	private int id;
	private String projectsdropdown;
	private String Categorydropdown;
	private String Taskdropdown;
	private String Subtaskdropdown;
	private String FromHours;
	private String ToHours;
	
	
	public String getProjectsdropdown() {
		return projectsdropdown;
	}
	public void setProjectsdropdown(String projectsdropdown) {
		this.projectsdropdown = projectsdropdown;
	}
	
	public String getTaskdropdown() {
		return Taskdropdown;
	}
	public void setTaskdropdown(String taskdropdown) {
		Taskdropdown = taskdropdown;
	}
	public String getCategorydropdown() {
		return Categorydropdown;
	}
	public void setCategorydropdown(String categorydropdown) {
		Categorydropdown = categorydropdown;
	}
	public String getSubtaskdropdown() {
		return Subtaskdropdown;
	}
	public void setSubtaskdropdown(String subtaskdropdown) {
		Subtaskdropdown = subtaskdropdown;
	}
	public String getFromHours() {
		return FromHours;
	}
	public void setFromHours(String fromHours) {
		FromHours = fromHours;
	}
	public String getToHours() {
		return ToHours;
	}
	public void setToHours(String toHours) {
		ToHours = toHours;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	

}


