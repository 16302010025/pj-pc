package education.client.teacher.request.get;

public class GetCPIDRequest {
  private int courseID;
  private int paperID;

  public int getCourseID() {
    return courseID;
  }

  public void setCourseID(int courseID) {
    this.courseID = courseID;
  }

  public int getPaperID() {
    return paperID;
  }

  public void setPaperID(int paperID) {
    this.paperID = paperID;
  }
}
