package education.client.teacher.controller;

import education.client.teacher.request.GetClassesRequest;
import education.client.teacher.response.GetClassesResponse;
import education.client.teacher.service.CourseService;
import education.entity.Course;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class GetClassController {
  @Resource
  CourseService courseService;

  @RequestMapping(value = "/getClasses", method = RequestMethod.POST)
  public @ResponseBody
  GetClassesResponse login(@RequestBody GetClassesRequest request) throws IOException{
    List<Integer> courseIDs=courseService.findCourseIDByID(request.getTeacherID());
    List<Course> courses=new ArrayList<>();
    for (int i = 0; i < courseIDs.size() ; i++) {
      courses.add(courseService.findCourseByID(courseIDs.get(i)));
    }
    return new GetClassesResponse(courses);
  }
}
