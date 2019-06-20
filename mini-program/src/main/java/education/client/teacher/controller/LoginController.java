package education.client.teacher.controller;

import education.client.teacher.request.LoginRequest;
import education.client.teacher.response.BooleanResponse;
import education.client.teacher.response.LoginResponse;
import education.client.teacher.service.TeacherService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;

@CrossOrigin(origins = "*")
@RestController
public class LoginController {
  @Resource
  TeacherService teacherService;
  @RequestMapping(value = "/login", method = RequestMethod.POST)
  public @ResponseBody
  LoginResponse login(@RequestBody LoginRequest request) throws IOException {

   if(teacherService.isPasswordMatch(request.getUsername(),request.getPassword())){
     return new LoginResponse(true,teacherService.findTeacherByName(request.getUsername()).getTeacherid());
    }else {
     return new LoginResponse(false,-1);//失败ID就是-1
   }
  }
}
