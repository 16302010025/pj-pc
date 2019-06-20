package education.client.teacher.controller.add;

import education.client.teacher.request.add.AddCourseRequest;
import education.client.teacher.response.BooleanResponse;
import education.client.teacher.service.TeacherCourseService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;

@CrossOrigin(origins = "*")
@RestController
public class AddCourseController {
  //添加课程
  @Resource
  TeacherCourseService courseService;

  @RequestMapping(value = "/addCourse", method = RequestMethod.POST)
  public @ResponseBody
  BooleanResponse addCourse(@RequestBody AddCourseRequest request) throws IOException {
    boolean isSuccess = courseService.addCourse(request.getTeacherID(), request.getCourseName(), request.getDescription());
    return new BooleanResponse(isSuccess);
  }
}
