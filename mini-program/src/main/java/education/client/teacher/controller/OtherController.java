package education.client.teacher.controller;

import education.client.teacher.request.get.GetCPIDRequest;
import education.client.teacher.request.get.GetChooseRequest;
import education.client.teacher.request.get.GetPaperIDRequest;
import education.client.teacher.response.StudentResponse;
import education.client.teacher.service.TeacherCourseService;
import education.client.teacher.service.TeacherExamService;
import education.client.teacher.service.TeacherOtherService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;

@CrossOrigin(origins = "*")
@RestController
public class OtherController {
  @Resource
  TeacherOtherService otherService;
  @Resource
  TeacherCourseService courseService;
  @Resource
  TeacherExamService examService;
  //选该课的学生
  @RequestMapping(value = "/getStuList", method = RequestMethod.POST)
  public @ResponseBody
  StudentResponse getChoose(@RequestBody GetChooseRequest request) throws IOException {
    if (request.getCourseID()>=0&&courseService.findCourseIDByID(request.getCourseID())!=null){
      return new StudentResponse(otherService.findChooseByCourseID(request.getCourseID()));
    }else {
      return null;
    }
  }

  //做完试卷的学生
  @RequestMapping(value = "/getFinish", method = RequestMethod.POST)
  public @ResponseBody
  StudentResponse getFinish(@RequestBody GetPaperIDRequest request) throws IOException {
    if (request.getPaperID()>=0&&examService.findPaperByID(request.getPaperID())!=null){
      return new StudentResponse(otherService.findFinishByPaperID(request.getPaperID()));
    }else {
      return null;
    }
  }

  //没做完试卷的学生
  @RequestMapping(value = "/getUnFinish", method = RequestMethod.POST)
  public @ResponseBody
  StudentResponse getUnFinish(@RequestBody GetCPIDRequest request) throws IOException {
    if (request.getPaperID()>=0&&examService.findPaperByID(request.getPaperID())!=null&&
      request.getCourseID()>=0&&courseService.findCourseByID(request.getCourseID())!=null){
      return new StudentResponse(otherService.findUnFinishByPaperID(request.getCourseID(),request.getPaperID()));
    }else {
      return null;
    }
  }

}
