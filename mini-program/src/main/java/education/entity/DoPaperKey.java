package education.entity;

public class DoPaperKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dopaper.exerciseID
     *
     * @mbggenerated
     */
    private Integer exerciseid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dopaper.paperID
     *
     * @mbggenerated
     */
    private Integer paperid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dopaper.studentID
     *
     * @mbggenerated
     */
    private String studentid;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dopaper.exerciseID
     *
     * @return the value of dopaper.exerciseID
     *
     * @mbggenerated
     */
    public Integer getExerciseid() {
        return exerciseid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dopaper.exerciseID
     *
     * @param exerciseid the value for dopaper.exerciseID
     *
     * @mbggenerated
     */
    public void setExerciseid(Integer exerciseid) {
        this.exerciseid = exerciseid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dopaper.paperID
     *
     * @return the value of dopaper.paperID
     *
     * @mbggenerated
     */
    public Integer getPaperid() {
        return paperid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dopaper.paperID
     *
     * @param paperid the value for dopaper.paperID
     *
     * @mbggenerated
     */
    public void setPaperid(Integer paperid) {
        this.paperid = paperid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dopaper.studentID
     *
     * @return the value of dopaper.studentID
     *
     * @mbggenerated
     */
    public String getStudentid() {
        return studentid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dopaper.studentID
     *
     * @param studentid the value for dopaper.studentID
     *
     * @mbggenerated
     */
    public void setStudentid(String studentid) {
        this.studentid = studentid == null ? null : studentid.trim();
    }
}