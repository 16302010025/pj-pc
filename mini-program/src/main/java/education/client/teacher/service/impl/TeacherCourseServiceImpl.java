package education.client.teacher.service.impl;

import education.client.teacher.service.TeacherCourseService;
import education.dao.CourseMapper;
import education.dao.TeacherMapper;
import education.entity.Course;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TeacherCourseServiceImpl implements TeacherCourseService {
  @Resource
  CourseMapper courseMapper;
  @Resource
  TeacherMapper teacherMapper;

  @Override
  public Course findCourseByID(int courseID) {
    if (courseID>=0&&courseMapper.findCourseByID(courseID)!=null){
      return courseMapper.findCourseByID(courseID);
    }
    return null;
  }

    @Override
  public List<Integer> findCourseIDByID(int teacherID) {
    if (teacherID>=0&&teacherMapper.findTeacherByID(teacherID)!=null){
      return teacherMapper.findCourseIDByID(teacherID);
    }else {
     return null;
    }

  }


  @Override
  public boolean addCourse(int teacherID, String courseName, String description) {
    if (teacherID<0||courseName==null||courseName.equals("")||description==null||description.equals("")||teacherMapper.findTeacherByID(teacherID)==null){
      return false;
    }else {
      courseMapper.addCourse(teacherID,courseName,description);
      return true;
    }
  }

  @Override
  public boolean updateCourse(int courseID, String courseName, String description) {
    if (courseID<0||courseName==null||courseName.equals("")||description==null||description.equals("")||courseMapper.findCourseByID(courseID)==null){
      return false;
    }else {
      courseMapper.updateCourse(courseID,courseName,description);
      return true;
    }

  }
}
