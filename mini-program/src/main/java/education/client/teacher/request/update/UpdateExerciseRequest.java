package education.client.teacher.request.update;

public class UpdateExerciseRequest {
  private int exerciseID;
  private String description;
  private char correct;
  private String a;
  private String b;
  private String c;
  private String d;

  public int getExerciseID() {
    return exerciseID;
  }

  public void setExerciseID(int exerciseID) {
    this.exerciseID = exerciseID;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public char getCorrect() {
    return correct;
  }

  public void setCorrect(char correct) {
    this.correct = correct;
  }

  public String getA() {
    return a;
  }

  public void setA(String a) {
    this.a = a;
  }

  public String getB() {
    return b;
  }

  public void setB(String b) {
    this.b = b;
  }

  public String getC() {
    return c;
  }

  public void setC(String c) {
    this.c = c;
  }

  public String getD() {
    return d;
  }

  public void setD(String d) {
    this.d = d;
  }
}
