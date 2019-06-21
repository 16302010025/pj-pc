package education.client.teacher.service.impl;

import education.client.teacher.service.TeacherChapterService;
import education.dao.ChapterMapper;
import education.dao.CourseMapper;
import education.entity.Chapter;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TeacherChapterServiceImpl implements TeacherChapterService {
  @Resource
  ChapterMapper chapterMapper;
  @Resource
  CourseMapper courseMapper;

  @Override
  public Chapter findChapterByID(int chapterID) {
    if (chapterID>=0&&chapterMapper.findChapterByID(chapterID)!=null){
      return chapterMapper.findChapterByID(chapterID);
    }
    return null;
  }


  @Override
  public List<Integer> findChapterIDByID(int courseID) {
    if (courseID>=0&&courseMapper.findCourseByID(courseID)!=null){
      return courseMapper.findChapterIDByID(courseID);
    }
    return null;
  }

  @Override
  public int addChapter(int courseID, String chapterName, String description) {
    if (courseID<0||chapterName==null||chapterName.equals("")||description==null||description.equals("")||courseMapper.findCourseByID(courseID)==null){
      return -1;
    }else {
      Chapter chapter=new Chapter();
      chapter.setCourseid(courseID);
      chapter.setName(chapterName);
      chapter.setDescription(description);
     chapterMapper.addChapter(chapter);
     return chapter.getChapterid();
    }
  }

  @Override
  public boolean updateChapter(int chapterID, String chapterName, String description) {
    if (chapterID<0||chapterName==null||chapterName.equals("")||description==null||description.equals("")||chapterMapper.findChapterByID(chapterID)==null){
      return false;
    }else {
      chapterMapper.updateChapter(chapterID,chapterName,description);
      return true;
    }
  }
}
