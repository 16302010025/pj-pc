package education.client.teacher.response.get;

import education.entity.Course;

import java.util.List;

public class GetClassesResponse {
  private List<Course> courseList;

  public GetClassesResponse(List<Course> courseList){
    this.courseList=courseList;
  }
  public List<Course> getCourseList() {
    return courseList;
  }

  public void setCourseList(List<Course> courseList) {
    this.courseList = courseList;
  }
}
