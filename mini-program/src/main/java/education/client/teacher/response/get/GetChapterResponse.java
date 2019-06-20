package education.client.teacher.response.get;

import education.entity.Chapter;

import java.util.List;

public class GetChapterResponse {
  private List<Chapter> chapters;

  public GetChapterResponse(List<Chapter> chapters){
    this.chapters=chapters;
  }

  public List<Chapter> getChapters() {
    return chapters;
  }

  public void setChapters(List<Chapter> chapters) {
    this.chapters = chapters;
  }
}
