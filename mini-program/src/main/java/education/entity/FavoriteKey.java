package education.entity;

public class FavoriteKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column favorite.chapterID
     *
     * @mbggenerated
     */
    private Integer chapterid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column favorite.studentID
     *
     * @mbggenerated
     */
    private String studentid;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column favorite.chapterID
     *
     * @return the value of favorite.chapterID
     *
     * @mbggenerated
     */
    public Integer getChapterid() {
        return chapterid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column favorite.chapterID
     *
     * @param chapterid the value for favorite.chapterID
     *
     * @mbggenerated
     */
    public void setChapterid(Integer chapterid) {
        this.chapterid = chapterid;
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