package education.client.teacher.controller.update;

import education.client.teacher.request.update.UpdateKpDetailRequest;
import education.client.teacher.response.BooleanResponse;
import education.client.teacher.service.TeacherDetailService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;

@CrossOrigin(origins = "*")
@RestController
public class UpdateKpDetailController {
  //更新知识点细节信息
  @Resource
  TeacherDetailService detailService;

  @RequestMapping(value = "/updateKpDetail", method = RequestMethod.POST)
  public @ResponseBody
  BooleanResponse updateKpDetail(@RequestBody UpdateKpDetailRequest request) throws IOException {
    boolean isSuccess = detailService.updateDetail(request.getKpDetailID(),request.getDescription());
    return new BooleanResponse(isSuccess);
  }
}
