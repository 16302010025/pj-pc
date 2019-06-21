package education.client.teacher.service.impl;

import education.client.teacher.service.TeacherCourseService;
import education.client.teacher.service.TeacherExamService;
import education.client.teacher.service.TeacherService;
import education.entity.Exercise;
import education.entity.Paper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TeacherExamServiceImpl implements TeacherExamService {
//  @Resource
//  TeacherExamMapper examMapper;
  @Resource
  TeacherService teacherService;
  @Resource
  TeacherCourseService courseService;
  @Override
  public int addPaper(int teacherID, int courseID) {
//    if (teacherID<0||courseID<0||teacherService.findTeacherByID(teacherID)==null||courseService.findCourseIDByID(courseID)==null){
//      return -1;
//    }else {
//      int paperID=examMapper.addPaper(teacherID,courseID);
//      return paperID;
//    }
    return 0;
  }

  @Override
  public int addExercise(int paperID, String description, char correct, String a, String b, String c, String d) {
    return 0;
  }

  @Override
  public boolean updateExercise(int paperID, String description, char correct, String a, String b, String c, String d) {
    return false;
  }

  @Override
  public Paper findPaperByID(int paperID) {
    return null;
  }

  @Override
  public Paper findPaperByCourseID(int courseID) {
    return null;
  }

  @Override
  public List<Paper> findPAperByTeacherID(int teacherID) {
    return null;
  }

  @Override
  public Exercise findExerciseByID(int exercriseID) {
    return null;
  }

  @Override
  public List<Integer> findExerciseIDByID(int paperID) {
    return null;
  }
}
