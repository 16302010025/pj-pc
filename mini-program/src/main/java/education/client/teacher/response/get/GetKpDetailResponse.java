package education.client.teacher.response.get;

import education.entity.KPDetail;

import java.util.List;

public class GetKpDetailResponse {
  List<KPDetail> kpDetails;

  public GetKpDetailResponse(List<KPDetail> kpDetails) {
    this.kpDetails = kpDetails;
  }

  public List<KPDetail> getKpDetails() {
    return kpDetails;
  }

  public void setKpDetails(List<KPDetail> kpDetails) {
    this.kpDetails = kpDetails;
  }
}
