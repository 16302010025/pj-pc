package education.client.teacher.request.add;

public class AddKnowledgeRequest {
  private int chapterID;
  private String knowledgeName;

  public int getChapterID() {
    return chapterID;
  }

  public void setChapterID(int chapterID) {
    this.chapterID = chapterID;
  }

  public String getKnowledgeName() {
    return knowledgeName;
  }

  public void setKnowledgeName(String knowledgeName) {
    this.knowledgeName = knowledgeName;
  }
}
