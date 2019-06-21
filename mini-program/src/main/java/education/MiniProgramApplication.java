package education;

import education.dao.CourseMapper;
import education.dao.WXCustomMapper;
import education.entity.Course;
import education.entity.wx.WXCourse;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


@SpringBootApplication
@MapperScan("education.dao")
//@RestController
public class MiniProgramApplication {
  @Resource
  CourseMapper courseMapper;

  public static void main(String[] args) {
    SpringApplication.run(MiniProgramApplication.class, args);
  }

//  @RequestMapping("/")
//  public Object hello() {
//    Course course = new Course();
//    course.setCoursename("English");
//    course.setTeacherid(6);
//    course.setDescription("This an English course.");
//    courseMapper.addCourse(course);
//    return course.getCourseid();
//  }
}
