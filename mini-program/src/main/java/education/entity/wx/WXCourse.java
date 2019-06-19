package education.entity.wx;

public class WXCourse {
  private Integer courseid;

  private String courseName;


  private String teacher;


  private String description;

  public Integer getCourseid() {
    return courseid;
  }

  public void setCourseid(Integer courseid) {
    this.courseid = courseid;
  }


  public String getTeacher() {
    return teacher;
  }

  public void setTeacher(String teacher) {
    this.teacher = teacher;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getCourseName() {
    return courseName;
  }

  public void setCourseName(String courseName) {
    this.courseName = courseName;
  }
}
