package education.client.teacher.service.impl;

import education.client.teacher.service.TeacherCourseService;
import education.client.teacher.service.TeacherExamService;
import education.dao.CourseMapper;
import education.dao.TeacherExamMapper;
import education.dao.TeacherMapper;
import education.entity.Exercise;
import education.entity.ExerciseWithBLOBs;
import education.entity.Paper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TeacherExamServiceImpl implements TeacherExamService {
  @Resource
  TeacherExamMapper examMapper;
  @Resource
  TeacherMapper teacherMapper;
  @Resource
  CourseMapper courseMapper;
  @Override
  public int addPaper(int teacherID, int courseID) {
    if (teacherID<0||courseID<0||teacherMapper.findTeacherByID(teacherID)==null||courseMapper.findCourseByID(courseID)==null){
      return -1;
    }else {
      Paper paper=new Paper();
      paper.setCourseid(courseID);
      paper.setTeacherid(teacherID);
     examMapper.addPaper(paper);
      return paper.getPaperid();
    }
  }

  @Override
  public int addExercise(int paperID, String description, char correct, String a, String b, String c, String d) {
    if (paperID<0||description==null||description.equals("")||a==null||a.equals("")||b==null||b.equals("")||
    c==null||c.equals("")||d==null||d.equals("")){
      return -1;
    }else {
      ExerciseWithBLOBs exerciseWithBLOBs=new ExerciseWithBLOBs();
      exerciseWithBLOBs.setPaperid(paperID);
      exerciseWithBLOBs.setDescription(description);
      exerciseWithBLOBs.setOptiona(a);
      exerciseWithBLOBs.setOptionb(b);
      exerciseWithBLOBs.setOptionc(c);
      exerciseWithBLOBs.setOptiond(d);
      exerciseWithBLOBs.setCorrectoption(correct+"");
      examMapper.addExercise(exerciseWithBLOBs);
      return exerciseWithBLOBs.getExerciseid();
    }
  }

  @Override
  public boolean updateExercise(int exerciseID, String description, char correct, String a, String b, String c, String d) {
    if (exerciseID<0||description==null||description.equals("")||a==null||a.equals("")||b==null||b.equals("")||
      c==null||c.equals("")||d==null||d.equals("")){
      return false;
    }else {
      ExerciseWithBLOBs exerciseWithBLOBs=examMapper.findExerciseByExerciseID(exerciseID);
      exerciseWithBLOBs.setDescription(description);
      exerciseWithBLOBs.setOptiona(a);
      exerciseWithBLOBs.setOptionb(b);
      exerciseWithBLOBs.setOptionc(c);
      exerciseWithBLOBs.setOptiond(d);
      exerciseWithBLOBs.setCorrectoption(correct+"");
      examMapper.updateExercise(exerciseWithBLOBs);
      return true;
    }
  }


  @Override
  public Paper findPaperByID(int paperID) {
    if(paperID>=0&&examMapper.findPaperByID(paperID)!=null){
      return examMapper.findPaperByID(paperID);
    }
    return null;
  }

  @Override
  public List<Paper> findPaperByCourseID(int courseID) {
    if (courseID>=0&&examMapper.findPaperByCourseID(courseID)!=null){
      return examMapper.findPaperByCourseID(courseID);
    }
    return null;
  }

  @Override
  public List<Paper> findPaperByTeacherID(int teacherID) {
    if (teacherID>=0&&teacherMapper.findTeacherByID(teacherID)!=null){
      return examMapper.findPaperByTeacherID(teacherID);
    }
    return null;
  }

  @Override
  public ExerciseWithBLOBs findExerciseByID(int exercriseID) {
    if (exercriseID>=0&&examMapper.findExerciseByExerciseID(exercriseID)!=null){
      return examMapper.findExerciseByExerciseID(exercriseID);
    }
    return null;
  }

  @Override
  public List<ExerciseWithBLOBs> findExerciseIDByID(int paperID) {
    if (paperID>=0&&examMapper.findExerciseByPaperID(paperID)!=null){
      return examMapper.findExerciseByPaperID(paperID);
    }
    return null;
  }
}
