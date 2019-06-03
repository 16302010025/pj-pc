package education.entity;

public class Student {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.studentID
     *
     * @mbggenerated
     */
    private String studentid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.name
     *
     * @mbggenerated
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.email
     *
     * @mbggenerated
     */
    private String email;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.gender
     *
     * @mbggenerated
     */
    private Boolean gender;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.studentNo
     *
     * @mbggenerated
     */
    private String studentno;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.studentID
     *
     * @return the value of student.studentID
     *
     * @mbggenerated
     */
    public String getStudentid() {
        return studentid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.studentID
     *
     * @param studentid the value for student.studentID
     *
     * @mbggenerated
     */
    public void setStudentid(String studentid) {
        this.studentid = studentid == null ? null : studentid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.name
     *
     * @return the value of student.name
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.name
     *
     * @param name the value for student.name
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.email
     *
     * @return the value of student.email
     *
     * @mbggenerated
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.email
     *
     * @param email the value for student.email
     *
     * @mbggenerated
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.gender
     *
     * @return the value of student.gender
     *
     * @mbggenerated
     */
    public Boolean getGender() {
        return gender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.gender
     *
     * @param gender the value for student.gender
     *
     * @mbggenerated
     */
    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.studentNo
     *
     * @return the value of student.studentNo
     *
     * @mbggenerated
     */
    public String getStudentno() {
        return studentno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.studentNo
     *
     * @param studentno the value for student.studentNo
     *
     * @mbggenerated
     */
    public void setStudentno(String studentno) {
        this.studentno = studentno == null ? null : studentno.trim();
    }
}