package education.client.teacher.controller;

import education.client.teacher.request.LoginRequest;
import education.client.teacher.response.IDResponse;
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
  IDResponse login(@RequestBody LoginRequest request) throws IOException {

   if(teacherService.isPasswordMatch(request.getUsername(),request.getPassword())){
     System.out.println("111111");
     return new IDResponse(true,teacherService.findTeacherByName(request.getUsername()).getTeacherid());
    }else {
     return new IDResponse(false,-1);//失败ID就是-1
   }
  }
}
