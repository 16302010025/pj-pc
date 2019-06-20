package education.client.teacher.controller.add;

import education.client.teacher.request.add.AddKnowledgeRequest;
import education.client.teacher.response.BooleanResponse;
import education.client.teacher.service.TeacherKnowledgeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;

@CrossOrigin(origins = "*")
@RestController
public class AddKnowledgeController {
  //添加知识点
  @Resource
  TeacherKnowledgeService knowledgeService;

  @RequestMapping(value = "/addKnowledge", method = RequestMethod.POST)
  public @ResponseBody
  BooleanResponse addKnowledge(@RequestBody AddKnowledgeRequest request) throws IOException {
    boolean isSuccess = knowledgeService.addKnowledge(request.getChapterID(),request.getKnowledgeName());
    return new BooleanResponse(isSuccess);
  }
}
