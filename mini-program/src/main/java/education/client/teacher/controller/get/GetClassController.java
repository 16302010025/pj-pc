package education.client.teacher.controller.get;

import education.client.teacher.request.get.GetClassesRequest;
import education.client.teacher.response.get.GetClassesResponse;
import education.client.teacher.service.TeacherCourseService;
import education.entity.Course;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class GetClassController {
  //获得该老师全部课程
  @Resource
  TeacherCourseService courseService;


  @RequestMapping(value = "/getClasses", method = RequestMethod.POST)
  public @ResponseBody
  GetClassesResponse getClasses(@RequestBody GetClassesRequest request) throws IOException{
    //没有检测request正确性
    List<Integer> courseIDs=courseService.findCourseIDByID(request.getTeacherID());
    List<Course> courses=new ArrayList<>();
    for (int i = 0; i < courseIDs.size() ; i++) {
      courses.add(courseService.findCourseByID(courseIDs.get(i)));
    }
    return new GetClassesResponse(courses);
  }
}
