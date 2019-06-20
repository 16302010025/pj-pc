package education.client.teacher.controller.get;

import education.client.teacher.request.get.GetDStringRequest;
import education.client.teacher.response.get.GetDStringReponse;
import education.client.teacher.service.TeacherDetailService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;

@CrossOrigin(origins = "*")
@RestController
public class GetDStringController {
  //根据知识点细节ID获得知识点细节

  @Resource
  TeacherDetailService detailService;
  @RequestMapping(value = "/getDes", method = RequestMethod.POST)
  public @ResponseBody
  GetDStringReponse getDes(@RequestBody GetDStringRequest request) throws IOException {
    System.out.println(request.getKpDetailID());
    return new GetDStringReponse(detailService.findDetailByID(request.getKpDetailID()).getDescription());
  }
}
