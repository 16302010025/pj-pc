package education.client.teacher.controller.update;

import education.client.teacher.request.update.UpdateCourseRequest;
import education.client.teacher.response.BooleanResponse;
import education.client.teacher.service.TeacherCourseService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;

@CrossOrigin(origins = "*")
@RestController
public class UpdateCourseController {
  //更新课程信息
  @Resource
  TeacherCourseService courseService;

  @RequestMapping(value = "/updateCourse", method = RequestMethod.POST)
  public @ResponseBody
  BooleanResponse updateCourse(@RequestBody UpdateCourseRequest request) throws IOException {
    boolean isSuccess = courseService.updateCourse(request.getCourseID(),request.getCourseName(),request.getDescription());
    return new BooleanResponse(isSuccess);
  }
}
