package education.client.teacher.controller;

import education.client.teacher.request.GetKnowledgeRequest;
import education.client.teacher.response.GetKnowledgeResponse;
import education.client.teacher.service.TeacherKnowledgeService;
import education.entity.KnowledgePoint;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class GetKnowledgeController {
  //获得章节所有知识点
  @Resource
  TeacherKnowledgeService knowledgeService;
  @RequestMapping(value = "/getKnowledge", method = RequestMethod.POST)
  public @ResponseBody
  GetKnowledgeResponse getKnowledge(@RequestBody GetKnowledgeRequest request) throws IOException {
    List<Integer> kpIDs=knowledgeService.findKnowledgeIDByID(request.getChapterID());
    List<KnowledgePoint> knowledgePoints=new ArrayList<>();
    for (int i = 0; i < kpIDs.size(); i++) {
      knowledgePoints.add(knowledgeService.findKnowledgeByID(kpIDs.get(i)));
    }
    return new GetKnowledgeResponse(knowledgePoints);
  }
}
