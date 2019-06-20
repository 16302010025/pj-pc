package education.client.teacher.request.update;

public class UpdateKpDetailRequest {
  private int kpDetailID;
  private String description;

  public int getKpDetailID() {
    return kpDetailID;
  }

  public void setKpDetailID(int kpDetailID) {
    this.kpDetailID = kpDetailID;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
