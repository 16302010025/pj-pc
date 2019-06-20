package education.client.teacher.response;

public class LoginResponse {
  private boolean success;
  private int teacherID;

  public LoginResponse(boolean success,int teacherID){
    this.success=success;
    this.teacherID=teacherID;
  }

  public boolean isSuccess() {
    return success;
  }

  public void setSuccess(boolean success) {
    this.success = success;
  }

  public int getTeacherID() {
    return teacherID;
  }

  public void setTeacherID(int teacherID) {
    this.teacherID = teacherID;
  }
}
