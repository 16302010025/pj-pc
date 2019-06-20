package education.dao;

import education.entity.Course;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface CourseMapper {
  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table course
   *
   * @mbggenerated
   */
  int deleteByPrimaryKey(Integer courseid);

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table course
   *
   * @mbggenerated
   */
  int insert(Course record);

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table course
   *
   * @mbggenerated
   */
  int insertSelective(Course record);

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table course
   *
   * @mbggenerated
   */
  Course selectByPrimaryKey(Integer courseid);

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table course
   *
   * @mbggenerated
   */
  int updateByPrimaryKeySelective(Course record);

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table course
   *
   * @mbggenerated
   */
  int updateByPrimaryKeyWithBLOBs(Course record);

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table course
   *
   * @mbggenerated
   */
  int updateByPrimaryKey(Course record);

  @Select("select * from course where courseID = #{courseID}")
  Course findCourseByID(Integer courseID);

  @Select("select chapterID from chapter where chapterID = #{courseID}")
  List<Integer> findChapterIDByID(Integer courseID);

  @Insert("insert into course values ( #{courseName}, #{description,#{teacherID})")
  int addCourse(@Param("teacherID") Integer teacherID, @Param("courseName") String courseName, @Param("description") String description);

  @Update("update course set courseName = #{courseName}, description = #{description} where courseID = #{courseID}")
  int updateCourse(@Param("courseID") Integer courseID, @Param("courseName") String courseName, @Param("description") String description);


}
