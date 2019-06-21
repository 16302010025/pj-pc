package education.dao;

import education.entity.Chapter;
import education.entity.ExerciseWithBLOBs;
import education.entity.KnowledgePoint;
import education.entity.wx.WXCourse;
import education.entity.wx.WXFavorite;
import education.entity.wx.WXNote;
import education.entity.wx.WXStudentCourse;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 微信数据库的对应的操作
 * */
public interface WXCustomMapper {

  //查询所有的课程
  List<WXCourse> getAllCourse();

  //通过course ID查询所有的章节
  @Select("select * from chapter where courseID = #{courseID}")
  List<Chapter> getAllChapterByCourseID(@Param("courseID") Integer courseID);

  //通过studentID获取收藏的
  //@Select("select * from favorite where studentID = #{studentID}")
  List<WXFavorite> getFavorite(String studentID);

  //得到一个课程对应的paper
  Integer getPaperID(Integer courseID);

  //通过paperID获取该paper中的所有的试题
  List<ExerciseWithBLOBs> getPaper(Integer paperID);

  //将学生所做了的题添加进去
  @Insert("insert into dopaper (studentID, exerciseID, paperID, choose)values (#{studentID}, #{exerciseID}, #{paperID}, #{choose})")
  int insertDoPaper(@Param("studentID") String studentID, @Param("exerciseID") Integer exerciseID, @Param("paperID") Integer paperID, @Param("choose") Character choose);

  //得到所有的笔记
  List<WXNote> getNote(String studentID);

  //通过一个chaoterID获取该下属的所有知识点ID
  @Select("select kpID, name from knowledgepoint where chapterID = #{chapterID}")
  List<KnowledgePoint> getAllKnowledgePoint(Integer chapterID);

  //通过studentID获取该学生的所有的课程
  List<WXStudentCourse> getStudentCourse(String studentID);
}
