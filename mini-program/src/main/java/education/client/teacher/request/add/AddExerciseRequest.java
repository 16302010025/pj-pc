package education.client.teacher.request.add;

public class AddExerciseRequest {
  private int paperID;
  private String description;
  private char correct;
  private String a;
  private String b;
  private String c;
  private String d;

  public int getPaperID() {
    return paperID;
  }

  public void setPaperID(int paperID) {
    this.paperID = paperID;
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
