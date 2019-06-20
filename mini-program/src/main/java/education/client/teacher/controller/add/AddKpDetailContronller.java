package education.client.teacher.controller.add;

import education.client.teacher.request.add.AddKpDetailRequest;
import education.client.teacher.response.BooleanResponse;
import education.client.teacher.service.TeacherDetailService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;

@CrossOrigin(origins = "*")
@RestController
public class AddKpDetailContronller {
  //添加知识点细节
  @Resource
  TeacherDetailService detailService;

  @RequestMapping(value = "/addKpDetail", method = RequestMethod.POST)
  public @ResponseBody
  BooleanResponse addKpDetail(@RequestBody AddKpDetailRequest request) throws IOException {
    boolean isSuccess = detailService.addDetail(request.getKnowledgeID(),request.getDescription());
    return new BooleanResponse(isSuccess);
  }
}
