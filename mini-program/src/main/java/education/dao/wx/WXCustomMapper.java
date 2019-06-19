package education.dao.wx;

import education.entity.Chapter;
import education.entity.Teacher;
import education.entity.wx.WXCourse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface WXCustomMapper {

  @Select("select courseID, courseName, course.description, name as teacher from course natural join teacher")
  List<WXCourse> getAllCourse();

  @Select("select * from chapter where chapterID = #{courseID}")
  List<Chapter> getAllChapterByCourseID(@Param("courseID") Integer courseID);
  
}
