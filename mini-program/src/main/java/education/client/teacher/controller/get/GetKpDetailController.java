package education.client.teacher.controller.get;

import education.client.teacher.request.get.GetKpDetailRequest;
import education.client.teacher.response.get.GetKpDetailResponse;
import education.client.teacher.service.TeacherDetailService;
import education.entity.KPDetail;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class GetKpDetailController {
  //根据知识点ID获得知识点细节链表

  @Resource
  TeacherDetailService detailService;
  @RequestMapping(value = "/getKpDetail", method = RequestMethod.POST)
  public @ResponseBody
  GetKpDetailResponse getKpDetail(@RequestBody GetKpDetailRequest request) throws IOException {
    List<Integer> kpDetailIDs=detailService.findDetailIDByID(request.getKnowledgeID());
    List<KPDetail> kpDetails=new ArrayList<>();
    for (int i = 0; i < kpDetailIDs.size(); i++) {
      kpDetails.add(detailService.findDetailByID(kpDetailIDs.get(i)));
    }
    return new GetKpDetailResponse(kpDetails);
  }
}
