package education.client.teacher.response.get;

public class GetDStringReponse {
  private String description;

  public GetDStringReponse(String description){
    this.description=description;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
