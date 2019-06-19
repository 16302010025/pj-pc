package education.client.teacher.controller;

import education.client.teacher.request.RegisterRequest;
import education.client.teacher.response.BooleanResponse;
import education.client.teacher.service.TeacherService;
import education.entity.Teacher;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;

@CrossOrigin(origins = "*")
@RestController
public class RegisterController {
  @Resource
  TeacherService teacherService;
  @RequestMapping(value = "/register", method = RequestMethod.POST)
  public @ResponseBody
  BooleanResponse register(@RequestBody RegisterRequest request) throws IOException {
    Teacher teacher=teacherService.findTeacherByName(request.getUsername());
    if (teacher==null){
      teacherService.addTeacher(request.getUsername(),request.getPassword(),request.isGender(),request.getDescription());
      return new BooleanResponse(true);
    }else {
      return new BooleanResponse(false);
    }
  }
}
