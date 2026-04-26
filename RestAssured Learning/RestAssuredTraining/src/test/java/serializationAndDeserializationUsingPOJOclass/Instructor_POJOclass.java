package serializationAndDeserializationUsingPOJOclass;

public class Instructor_POJOclass {
	private String url;
	private String services;
	private String expertise;	
	private CoursesPOJOclass courses;
	private String linkedIn;
	private String instructor;
	
	public String getExpertise() {
		return expertise;
	}
	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}
	
	
	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getServices() {
		return services;
	}
	public void setServices(String services) {
		this.services = services;
	}
	public CoursesPOJOclass getCourses() {
		return courses;
	}
	public void setCourses(CoursesPOJOclass courses) {
		this.courses = courses;
	}
	public String getLinkedIn() {
		return linkedIn;
	}
	public void setLinkedIn(String linkedIn) {
		this.linkedIn = linkedIn;
	}
	

}
