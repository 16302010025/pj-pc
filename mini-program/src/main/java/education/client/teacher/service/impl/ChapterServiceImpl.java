package education.client.teacher.service.impl;

import education.client.teacher.service.ChapterService;
import education.dao.ChapterMapper;
import education.dao.CourseMapper;
import education.entity.Chapter;

import javax.annotation.Resource;
import java.util.List;

public class ChapterServiceImpl implements ChapterService {
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
  public boolean addChapter(int courseID, String chapterName, String description) {
    if (courseID<0||chapterName==null||chapterName.equals("")||description==null||description.equals("")||courseMapper.findCourseByID(courseID)==null){
      return false;
    }else {
     chapterMapper.addChapter(courseID,chapterName,description);
     return true;
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
