package example.spring.rest.data.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Course_Master")
public class Course {
	@Id
	@Column(name = "course_id", length=5)
	private String courseId;
	
	@Column(name = "course_title", length=50)
	private String title;
	
	@Column(name = "course_duration")
	private int duration;
	
	@Column(name = "course_fees")
	private int fees;

	public Course() {
		
	}

	public Course(String courseId, String title, int duration, int fees) {
		super();
		this.courseId = courseId;
		this.title = title;
		this.duration = duration;
		this.fees = fees;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getDuratiob() {
		return duration;
	}

	public void setDuratiob(int duration) {
		this.duration = duration;
	}

	public int getFees() {
		return fees;
	}

	public void setFees(int fees) {
		this.fees = fees;
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", title=" + title + ", duratiob=" + duration + ", fees=" + fees + "]";
	}

}