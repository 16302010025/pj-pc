package education.client.teacher.controller.get;

import education.client.teacher.request.get.GetChapterRequest;
import education.client.teacher.response.get.GetChapterResponse;
import education.client.teacher.service.TeacherChapterService;
import education.entity.Chapter;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class GetChapterController {
  //获得该课程全部章节
  @Resource
  TeacherChapterService chapterService;

  @RequestMapping(value = "/getChapter", method = RequestMethod.POST)
  public @ResponseBody
  GetChapterResponse getChapter(@RequestBody GetChapterRequest request) throws IOException {
    List<Integer> chapterIDs=chapterService.findChapterIDByID(request.getCourseID());
    List<Chapter> chapters=new ArrayList<>();
    for (int i = 0; i < chapterIDs.size() ; i++) {
      chapters.add(chapterService.findChapterByID(chapterIDs.get(i)));
    }
    return new GetChapterResponse(chapters);
  }
}
