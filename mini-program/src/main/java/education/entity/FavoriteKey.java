package education.entity;

public class FavoriteKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column favorite.kpID
     *
     * @mbggenerated
     */
    private Integer kpid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column favorite.studentID
     *
     * @mbggenerated
     */
    private String studentid;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column favorite.kpID
     *
     * @return the value of favorite.kpID
     *
     * @mbggenerated
     */
    public Integer getKpid() {
        return kpid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column favorite.kpID
     *
     * @param kpid the value for favorite.kpID
     *
     * @mbggenerated
     */
    public void setKpid(Integer kpid) {
        this.kpid = kpid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column favorite.studentID
     *
     * @return the value of favorite.studentID
     *
     * @mbggenerated
     */
    public String getStudentid() {
        return studentid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column favorite.studentID
     *
     * @param studentid the value for favorite.studentID
     *
     * @mbggenerated
     */
    public void setStudentid(String studentid) {
        this.studentid = studentid == null ? null : studentid.trim();
    }
}