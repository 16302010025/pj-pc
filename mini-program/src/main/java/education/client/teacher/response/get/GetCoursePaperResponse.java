package education.client.teacher.response.get;

import education.entity.Paper;

import java.util.List;

public class GetCoursePaperResponse {
  private List<Paper> papers;

  public GetCoursePaperResponse(List<Paper> papers) {
    this.papers = papers;
  }

  public List<Paper> getPapers() {
    return papers;
  }

  public void setPapers(List<Paper> papers) {
    this.papers = papers;
  }
}
