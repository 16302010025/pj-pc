package education.dao;

import education.entity.KPDetail;
import education.entity.KnowledgePoint;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface KnowledgePointMapper {
  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table knowledgepoint
   *
   * @mbggenerated
   */
  int deleteByPrimaryKey(Integer kpid);

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table knowledgepoint
   *
   * @mbggenerated
   */
  int insert(KnowledgePoint record);

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table knowledgepoint
   *
   * @mbggenerated
   */
  int insertSelective(KnowledgePoint record);

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table knowledgepoint
   *
   * @mbggenerated
   */
  KnowledgePoint selectByPrimaryKey(Integer kpid);

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table knowledgepoint
   *
   * @mbggenerated
   */
  int updateByPrimaryKeySelective(KnowledgePoint record);

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table knowledgepoint
   *
   * @mbggenerated
   */
  int updateByPrimaryKey(KnowledgePoint record);


  //通过kpID获取一个具体的知识点记录项
  @Select("select * from knowledgepoint where kpID = #{kpID}")
  KnowledgePoint findKnowledgeByID(Integer kpID);

  //通过kpID获取对应的kpDetail的所有相关的id
  @Select("select id from kpdetail where kpID = #{kpID}")
  List<Integer> findDetailIDByID(Integer kpID);

  //向一个知识点表中插入一条新的数据
 // @Insert("insert into knowledgepoint (chapterID, name)values (#{chapterID}, #{name})")
  int addKnowledge(KnowledgePoint knowledgePoint);

  //更新相关的记录项
  @Update("update knowledgepoint set name = #{name} where kpID = #{kpID}")
  int updateKnowledge(@Param("kpID") Integer knowledgeID, @Param("name") String knowledgeName);
}
