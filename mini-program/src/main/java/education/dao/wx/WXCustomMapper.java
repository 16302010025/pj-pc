package education.dao.wx;

import education.entity.*;
import education.entity.wx.WXCourse;
import org.apache.ibatis.annotations.Insert;
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

  @Select("select * from favorite where studentID = #{studentID}")
  List<Favorite> getFavorite(String studentID);

  @Select("select exerciseID, description, correctOption, optionA, optionB, optionC, optionD from exercise natural join paper where courseID = #{courseID}")
  List<ExerciseWithBLOBs> getPaper(String courseID);

  @Insert("insert into dopaper (#{studentID}, #{exerciseID}, #{paperID}, #{choose})")
  int insertDoPaper(@Param("studentID") String studentID, @Param("exerciseID") Integer exerciseID, @Param("paperID")Integer paperID , @Param("choose")Character choose);
}
