package education.client.teacher.controller;

import education.client.teacher.request.GetDetailsRequest;
import education.client.teacher.response.BooleanResponse;
import education.client.teacher.service.TeacherCourseService;
import education.client.teacher.service.TeacherService;
import education.entity.Course;
import education.entity.Teacher;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;

@CrossOrigin(origins = "*")
@RestController
public class getDetails {
  //判断是否这个老师的课
  @Resource
  TeacherCourseService teacherCourseService;
  @Resource
  TeacherService teacherService;

  @RequestMapping(value = "/getDetails", method = RequestMethod.POST)
  public @ResponseBody
  BooleanResponse getDetails(@RequestBody GetDetailsRequest request) throws IOException {
    Course course= teacherCourseService.findCourseByID(request.getCourseID());
    Teacher teacher=teacherService.findTeacherByName(request.getUsername());
    if (course!=null&&teacher!=null&&course.getTeacherid()==teacher.getTeacherid()){
      return new BooleanResponse(true);
    }
    return new BooleanResponse(false);
  }
}
