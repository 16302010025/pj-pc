package education.dao;

import education.entity.KPDetail;

public interface KPDetailMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kpdetail
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kpdetail
     *
     * @mbggenerated
     */
    int insert(KPDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kpdetail
     *
     * @mbggenerated
     */
    int insertSelective(KPDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kpdetail
     *
     * @mbggenerated
     */
    KPDetail selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kpdetail
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(KPDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kpdetail
     *
     * @mbggenerated
     */
    int updateByPrimaryKeyWithBLOBs(KPDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kpdetail
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(KPDetail record);
}