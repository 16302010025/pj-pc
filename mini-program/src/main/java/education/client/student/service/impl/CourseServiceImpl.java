package education.client.student.service.impl;

import education.client.student.service.CourseService;
import education.dao.*;
import education.entity.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
  @Resource
  private CourseMapper courseMapper;
  private ChooseCourseMapper chooseCourseMapper;
  private ChapterMapper chapterMapper;
  private FavoriteMapper favoriteMapper;
  private MemoMapper memoMapper;

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
  public List<Chapter> getAllChapterByCourseId(String courseId) {
    Chapter chapter = new Chapter();
    List<Chapter> chapterList = new ArrayList<>();

    return chapterList;
  }

  @Override
  public List<KnowledgePoint> getAllKnowledgePointByChapterId(int chapterId) {
    KnowledgePoint knowledgePoint = new KnowledgePoint();
    List<KnowledgePoint> knowledgePointList = new ArrayList<>();

    return knowledgePointList;
  }

  @Override
  public boolean addFav(String studentId, int kpID) {
    Favorite favorite = new Favorite();
    favorite.setStudentid(studentId);
    favorite.setKpid(kpID);
    if (favoriteMapper.insertSelective(favorite) != 0) {
      return true;
    }
    return false;
  }

  @Override
  public boolean delFav(String studentId, int kpID) {
    FavoriteKey favoriteKey = new FavoriteKey();
    favoriteKey.setStudentid(studentId);
    favoriteKey.setKpid(kpID);
    if (favoriteMapper.deleteByPrimaryKey(favoriteKey) != 0) {
      return true;
    }
    return false;
  }

  @Override
  public List getNote(String studentID) {
    return null;
  }

  @Override
  public boolean addNote(String studentID, int kpID, String description) {
    Memo memo = new Memo();
    memo.setStudentid(studentID);
    memo.setKpid(kpID);
    memo.setDescription(description);
    if (memoMapper.insertSelective(memo) != 0) {
      return true;
    }
    return false;
  }
  @Override
  public boolean delNote(int memoID){
    if (memoMapper.deleteByPrimaryKey(memoID) != 0) {
      return true;
    }
    return false;
  }
  @Override
  public List<Course> getCourse(String studentID){
    return null;
  }
}
