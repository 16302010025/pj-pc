package education.entity;

public class ExerciseWithBLOBs extends Exercise {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column exercise.description
     *
     * @mbggenerated
     */
    private String description;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column exercise.optionA
     *
     * @mbggenerated
     */
    private String optiona;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column exercise.optionB
     *
     * @mbggenerated
     */
    private String optionb;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column exercise.optionC
     *
     * @mbggenerated
     */
    private String optionc;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column exercise.optionD
     *
     * @mbggenerated
     */
    private String optiond;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column exercise.description
     *
     * @return the value of exercise.description
     *
     * @mbggenerated
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column exercise.description
     *
     * @param description the value for exercise.description
     *
     * @mbggenerated
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column exercise.optionA
     *
     * @return the value of exercise.optionA
     *
     * @mbggenerated
     */
    public String getOptiona() {
        return optiona;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column exercise.optionA
     *
     * @param optiona the value for exercise.optionA
     *
     * @mbggenerated
     */
    public void setOptiona(String optiona) {
        this.optiona = optiona == null ? null : optiona.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column exercise.optionB
     *
     * @return the value of exercise.optionB
     *
     * @mbggenerated
     */
    public String getOptionb() {
        return optionb;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column exercise.optionB
     *
     * @param optionb the value for exercise.optionB
     *
     * @mbggenerated
     */
    public void setOptionb(String optionb) {
        this.optionb = optionb == null ? null : optionb.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column exercise.optionC
     *
     * @return the value of exercise.optionC
     *
     * @mbggenerated
     */
    public String getOptionc() {
        return optionc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column exercise.optionC
     *
     * @param optionc the value for exercise.optionC
     *
     * @mbggenerated
     */
    public void setOptionc(String optionc) {
        this.optionc = optionc == null ? null : optionc.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column exercise.optionD
     *
     * @return the value of exercise.optionD
     *
     * @mbggenerated
     */
    public String getOptiond() {
        return optiond;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column exercise.optionD
     *
     * @param optiond the value for exercise.optionD
     *
     * @mbggenerated
     */
    public void setOptiond(String optiond) {
        this.optiond = optiond == null ? null : optiond.trim();
    }
}