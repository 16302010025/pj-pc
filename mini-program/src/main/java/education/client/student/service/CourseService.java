package education.client.student.service;

import education.entity.*;
import education.entity.wx.WXCourse;
import education.entity.wx.WXNote;

import java.util.List;

public interface CourseService {

  List<WXCourse> getAllCourse();

  boolean addCourse(String studentId, int courseId);

  List<Chapter> getAllChapterByCourseId(int courseId);

  List<KnowledgePoint> getAllKnowledgePointByChapterId(int chapterId);

  List<Favorite> getFav(String studentID);

  boolean addFav(String studentId, int chapterId);

  boolean delFav(String studentId, int chapterId);

  List<WXNote> getNote(String studentID);

  boolean addNote(String studentID, int kpID, String description);

  boolean delNote(int memoID);

  List<WXCourse> getCourse(String studentID);

  String getKpDetail(int kpID);

  int getPaper(int courseid);

  List<ExerciseWithBLOBs> getExercise(int paperid);

  boolean submitPaper(String studentID, int exerciseID, int paperID, char choose);
}
