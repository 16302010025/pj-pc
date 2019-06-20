package education.client.teacher.controller.add;

import education.client.teacher.request.add.AddChapterRequest;
import education.client.teacher.response.BooleanResponse;
import education.client.teacher.service.TeacherChapterService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;

@CrossOrigin(origins = "*")
@RestController
public class AddChapterController {
  //添加章节
  @Resource
  TeacherChapterService chapterService;

  @RequestMapping(value = "/addChapter", method = RequestMethod.POST)
  public @ResponseBody
  BooleanResponse addCourse(@RequestBody AddChapterRequest request) throws IOException {
    boolean isSuccess = chapterService.addChapter(request.getCourseID(),request.getChapterName(),request.getDescription());
    return new BooleanResponse(isSuccess);
  }
}
