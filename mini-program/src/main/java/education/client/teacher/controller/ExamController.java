package education.client.teacher.controller;


import education.client.teacher.request.add.AddExerciseRequest;
import education.client.teacher.request.add.AddPaperRequest;
import education.client.teacher.request.get.GetCoursePaperRequest;
import education.client.teacher.request.get.GetPaperExerciseRequest;
import education.client.teacher.request.get.GetTeacherPaperRequest;
import education.client.teacher.request.update.UpdateExerciseRequest;
import education.client.teacher.response.BooleanResponse;
import education.client.teacher.response.IDResponse;
import education.client.teacher.response.get.GetCoursePaperResponse;
import education.client.teacher.response.get.GetPaperExerciseResponse;
import education.client.teacher.response.get.GetTeacherPaperResponse;
import education.client.teacher.service.TeacherExamService;
import education.entity.ExerciseWithBLOBs;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;

@CrossOrigin(origins = "*")
@RestController
public class ExamController {
  @Resource
  TeacherExamService examService;
  //添加试卷
  @RequestMapping(value = "/addPaper", method = RequestMethod.POST)
  public @ResponseBody
  IDResponse addPaper(@RequestBody AddPaperRequest request) throws IOException {
    int paperID=examService.addPaper(request.getTeacherID(),request.getCourseID());
    if (paperID>=0){
      return new IDResponse(true,paperID);
    }else {
      return new IDResponse(false,-1);
    }
  }
  //添加题目
  @RequestMapping(value = "/addExercise", method = RequestMethod.POST)
  public @ResponseBody
  IDResponse addExercise(@RequestBody AddExerciseRequest request) throws IOException {
    int exercriseID=examService.addExercise(request.getPaperID(),request.getDescription(),request.getCorrect(),request.getA(),
      request.getB(),request.getC(),request.getD());
    if (exercriseID>=0){
      return new IDResponse(true,exercriseID);
    }else {
      return new IDResponse(false,-1);
    }
  }

  //编辑题目
  @RequestMapping(value = "/updateExercise", method = RequestMethod.POST)
  public @ResponseBody
  BooleanResponse updateExercise(@RequestBody UpdateExerciseRequest request) throws IOException {
    ExerciseWithBLOBs exercrise=examService.findExerciseByID(request.getExerciseID());
    if (exercrise!=null){
      examService.updateExercise(request.getExerciseID(),request.getDescription(),request.getCorrect(),
        request.getA(),request.getB(),request.getC(),request.getD());
      return new BooleanResponse(true);
    }else {
      return new BooleanResponse(false);
    }
  }

  //查看教师试卷
  @RequestMapping(value = "/getTeacherPaper", method = RequestMethod.POST)
  public @ResponseBody
  GetTeacherPaperResponse getTeacherPaper(@RequestBody GetTeacherPaperRequest request) throws IOException {
    return new GetTeacherPaperResponse(examService.findPaperByTeacherID(request.getTeacherID()));
  }

  //查看课程试卷
  @RequestMapping(value = "/getMyPapers", method = RequestMethod.POST)
  public @ResponseBody
  GetCoursePaperResponse getCoursePaper(@RequestBody GetCoursePaperRequest request) throws IOException {
    return new GetCoursePaperResponse(examService.findPaperByCourseID(request.getCourseID()));
  }

  //查看试卷题目
  @RequestMapping(value = "/getPaperDet", method = RequestMethod.POST)
  public @ResponseBody
  GetPaperExerciseResponse getPaperExercise(@RequestBody GetPaperExerciseRequest request) throws IOException {
    return new GetPaperExerciseResponse(examService.findExerciseIDByID(request.getPaperID()));
  }

}
