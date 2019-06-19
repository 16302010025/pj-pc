package education.client.student.service.impl;

import education.client.student.service.CourseService;
import education.dao.ChapterMapper;
import education.dao.ChooseCourseMapper;
import education.dao.CourseMapper;
import education.entity.Chapter;
import education.entity.ChooseCourse;
import education.entity.Course;
import education.entity.KnowledgePoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseMapper courseMapper;
    private ChooseCourseMapper chooseCourseMapper;
    private ChapterMapper chapterMapper;

    @Override
    public List<Course> getAllCourse() {
        return new ArrayList<Course>();
    }

    @Override
    public boolean addCourse(String studentId, int courseId) {
        ChooseCourse chooseCourse = new ChooseCourse();
        chooseCourse.setStudentid(studentId);
        chooseCourse.setCourseid(courseId);
        if (chooseCourseMapper.insertSelective(chooseCourse) != 0) {
            return true;
        }
        return false;
    }
    @Override
    public List<Chapter> getAllChapterByCourseId(String courseId){
        Chapter chapter = new Chapter();
        List<Chapter> chapterList = new ArrayList<>();

        return chapterList;
    }
    @Override
    public List<KnowledgePoint> getAllKnowledgePointByChapterId(int chapterId){
        KnowledgePoint knowledgePoint = new KnowledgePoint();
        List<KnowledgePoint> knowledgePointList = new ArrayList<>();

        return knowledgePointList;
    }
}
