package education.client.teacher.response;

import education.entity.Student;

import java.util.List;

public class StudentResponse {
  List<Student> students;

  public StudentResponse(List<Student> students) {
    this.students = students;
  }

  public List<Student> getStudents() {
    return students;
  }

  public void setStudents(List<Student> students) {
    this.students = students;
  }
}
