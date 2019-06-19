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
}
