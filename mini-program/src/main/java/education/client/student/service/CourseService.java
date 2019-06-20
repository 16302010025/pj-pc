package education.client.student.service;

import education.entity.Chapter;
import education.entity.Course;
import education.entity.KnowledgePoint;

import java.util.List;

public interface CourseService {

  List<Course> getAllCourse();

  boolean addCourse(String studentId, int courseId);

  List<Chapter> getAllChapterByCourseId(String courseId);

  List<KnowledgePoint> getAllKnowledgePointByChapterId(int chapterId);

  boolean addFav(String studentId, int chapterId);

  boolean delFav(String studentId, int chapterId);

  List getNote(String studentID);

  boolean addNote(String studentID,int kpID,String description);

  boolean delNote(int memoID);

  List<Course> getCourse(String studentID);
}
