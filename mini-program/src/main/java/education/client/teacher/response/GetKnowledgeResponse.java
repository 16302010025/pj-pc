package education.client.teacher.response;

import education.entity.KnowledgePoint;

import java.util.List;

public class GetKnowledgeResponse {
  List<KnowledgePoint> knowledgePoints;

  public GetKnowledgeResponse(List<KnowledgePoint> knowledgePoints){
    this.knowledgePoints=knowledgePoints;
  }
  public List<KnowledgePoint> getKnowledgePoints() {
    return knowledgePoints;
  }

  public void setKnowledgePoints(List<KnowledgePoint> knowledgePoints) {
    this.knowledgePoints = knowledgePoints;
  }
}
