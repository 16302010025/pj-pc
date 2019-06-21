package education.client.teacher.response;

public class IDResponse {
  private boolean success;
  private int ID;

  public IDResponse(boolean success, int ID){
    this.success=success;
    this.ID=ID;
  }

  public int getID() {
    return ID;
  }

  public void setID(int ID) {
    this.ID = ID;
  }

  public boolean isSuccess() {
    return success;
  }

  public void setSuccess(boolean success) {
    this.success = success;
  }


}
