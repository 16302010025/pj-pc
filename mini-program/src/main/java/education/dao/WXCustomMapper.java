package education.dao;

import education.entity.*;
import education.entity.wx.WXCourse;
import education.entity.wx.WXNote;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface WXCustomMapper {

  List<WXCourse> getAllCourse();

  @Select("select * from chapter where courseID = #{courseID}")
  List<Chapter> getAllChapterByCourseID(@Param("courseID") Integer courseID);

  @Select("select * from favorite where studentID = #{studentID}")
  List<Favorite> getFavorite(String studentID);

  List<ExerciseWithBLOBs> getPaper(String courseID);

  @Insert("insert into dopaper (studentID, exerciseID, paperID, choose)values (#{studentID}, #{exerciseID}, #{paperID}, #{choose})")
  int insertDoPaper(@Param("studentID") String studentID, @Param("exerciseID") Integer exerciseID, @Param("paperID")Integer paperID , @Param("choose")Character choose);

  List<WXNote> getNote(String studentID);

  @Select("select kpID, name from knowledgepoint where chapterID = #{chapterID}")
  List<KnowledgePoint> getAllKnowledgePoint(Integer chapterID);
}
