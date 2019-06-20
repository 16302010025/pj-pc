package education.client.teacher.request;

public class GetDetailsRequest {
  private String username;
  private int courseID;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public int getCourseID() {
    return courseID;
  }

  public void setCourseID(int courseID) {
    this.courseID = courseID;
  }
}
