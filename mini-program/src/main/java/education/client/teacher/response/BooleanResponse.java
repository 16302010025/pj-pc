package education.client.teacher.response;

//返回成功失败信息
public class BooleanResponse {
  private boolean success;

  public BooleanResponse(boolean success){
    this.success=success;
  }
  public boolean isSuccess() {
    return success;
  }

}
