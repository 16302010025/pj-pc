package education.dao;

import education.entity.Progress;
import education.entity.ProgressKey;

public interface ProgressMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table progress
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(ProgressKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table progress
     *
     * @mbggenerated
     */
    int insert(Progress record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table progress
     *
     * @mbggenerated
     */
    int insertSelective(Progress record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table progress
     *
     * @mbggenerated
     */
    Progress selectByPrimaryKey(ProgressKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table progress
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Progress record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table progress
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Progress record);
}