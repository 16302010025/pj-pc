package education.entity.wx;

public class WXStudentCourse {
  private Integer courseID;
  private String courseName;
  private String teacher;

  public Integer getCourseID() {
    return courseID;
  }

  public void setCourseID(Integer courseID) {
    this.courseID = courseID;
  }

  public String getCourseName() {
    return courseName;
  }

  public void setCourseName(String courseName) {
    this.courseName = courseName;
  }

  public String getTeacher() {
    return teacher;
  }

  public void setTeacher(String teacher) {
    this.teacher = teacher;
  }
}
