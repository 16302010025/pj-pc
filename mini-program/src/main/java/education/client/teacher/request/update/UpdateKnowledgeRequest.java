package education.client.teacher.request.update;

public class UpdateKnowledgeRequest {
  private int knowledgeID;
  private String name;

  public int getKnowledgeID() {
    return knowledgeID;
  }

  public void setKnowledgeID(int knowledgeID) {
    this.knowledgeID = knowledgeID;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
