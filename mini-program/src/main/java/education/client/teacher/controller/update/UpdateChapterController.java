package education.client.teacher.controller.update;

import education.client.teacher.request.update.UpdateChapterRequest;
import education.client.teacher.response.BooleanResponse;
import education.client.teacher.service.TeacherChapterService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;

@CrossOrigin(origins = "*")
@RestController
public class UpdateChapterController {
  //更新章节信息
  @Resource
  TeacherChapterService chapterService;

  @RequestMapping(value = "/updateChapter", method = RequestMethod.POST)
  public @ResponseBody
  BooleanResponse updateChapter(@RequestBody UpdateChapterRequest request) throws IOException {
    boolean isSuccess = chapterService.updateChapter(request.getChapterID(),request.getChapterName(),request.getDescription());
    return new BooleanResponse(isSuccess);
  }
}
