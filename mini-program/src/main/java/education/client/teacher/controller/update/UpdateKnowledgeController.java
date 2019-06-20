package education.client.teacher.controller.update;

import education.client.teacher.request.update.UpdateKnowledgeRequest;
import education.client.teacher.response.BooleanResponse;
import education.client.teacher.service.TeacherKnowledgeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;

@CrossOrigin(origins = "*")
@RestController
public class UpdateKnowledgeController {
  //更新知识点信息
  @Resource
  TeacherKnowledgeService knowledgeService;

  @RequestMapping(value = "/updateKnowledge", method = RequestMethod.POST)
  public @ResponseBody
  BooleanResponse updateKnowledge(@RequestBody UpdateKnowledgeRequest request) throws IOException {
    boolean isSuccess = knowledgeService.updateKnowledge(request.getKnowledgeID(),request.getName());
    return new BooleanResponse(isSuccess);
  }
}
