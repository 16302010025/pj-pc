package education.client.teacher.request.update;

public class UpdateChapterRequest {
  private int chapterID;
  private String chapterName;
  private String description;

  public int getChapterID() {
    return chapterID;
  }

  public void setChapterID(int chapterID) {
    this.chapterID = chapterID;
  }

  public String getChapterName() {
    return chapterName;
  }

  public void setChapterName(String chapterName) {
    this.chapterName = chapterName;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
