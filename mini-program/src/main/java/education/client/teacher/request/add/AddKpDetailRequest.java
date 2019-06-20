package education.client.teacher.request.add;

public class AddKpDetailRequest {
  private int knowledgeID;
  private String description;

  public int getKnowledgeID() {
    return knowledgeID;
  }

  public void setKnowledgeID(int knowledgeID) {
    this.knowledgeID = knowledgeID;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
