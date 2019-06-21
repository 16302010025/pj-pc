package education.client.teacher.service.impl;

import education.client.teacher.service.TeacherOtherService;
import education.dao.CourseMapper;
import education.dao.TeacherExamMapper;
import education.entity.Student;

import javax.annotation.Resource;
import java.util.List;

public class TeacherOtherServiceImpl implements TeacherOtherService {
  @Resource
  TeacherOtherMapper otherMapper;
  @Resource
  CourseMapper courseMapper;
  @Resource
  TeacherExamMapper examMapper;
  @Override
  public List<Student> findChooseByCourseID(int courseID) {
    if (courseID>=0&&courseMapper.findCourseByID(courseID)!=null){
      return otherMapper.findChooseByCourseID(courseID);
    }
    return null;
  }

  @Override
  public List<Student> findFinishByPaperID(int paperID) {
    if (paperID>=0&&examMapper.findPaperByID(paperID)!=null){
      return otherMapper.findFinishByPaperID(paperID);
    }
    return null;
  }

  @Override
  public List<Student> findUnFinishByPaperID(int paperID) {
    if (paperID>=0&&examMapper.findPaperByID(paperID)!=null){
      return otherMapper.findUnFinishByPaperID(paperID);
    }
    return null;
  }


}
