package education.dao;

import education.entity.PaperExerciseKey;

public interface PaperExerciseMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table paperexercise
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(PaperExerciseKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table paperexercise
     *
     * @mbggenerated
     */
    int insert(PaperExerciseKey record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table paperexercise
     *
     * @mbggenerated
     */
    int insertSelective(PaperExerciseKey record);
}