package education.client.teacher.controller;

import education.client.teacher.request.ModifyRequest;
import education.client.teacher.response.BooleanResponse;
import education.client.teacher.service.TeacherService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;

@CrossOrigin(origins = "*")
@RestController
public class ModifyController {
  @Resource
  TeacherService teacherService;
  @RequestMapping(value = "/modify", method = RequestMethod.POST)
  public @ResponseBody
  BooleanResponse modify(@RequestBody ModifyRequest request) throws IOException {
    if (teacherService.findTeacherByName(request.getUsername())!=null){
      teacherService.updatePassword(request.getUsername(),request.getNewPassword());
      return new BooleanResponse(true);
    }else {
      return new BooleanResponse(false);
    }
  }
}
