package education.client.teacher.service;

import education.entity.Chapter;

import java.util.List;


public interface ChapterService {
  /**
   *
   * @param chapterID 章节ID
   * @return 章节
   */
  Chapter findChapterByID(int chapterID);

  /**
   *
   * @param courseID 课程ID
   * @return 章节ID链表
   */
  List<Integer> findChapterIDByID(int courseID);


  /**
   *
   * @param courseID 课程ID
   * @param chapterName 章节名
   * @param description 描述
   * @return 是否成功
   */
  boolean addChapter(int courseID, String chapterName, String description);

  /**
   *
   * @param chapterID 章节ID
   * @param chapterName 修改后的章节名
   * @param description 修改后的描述
   * @return 是否成功
   */
  boolean updateChapter(int chapterID, String chapterName, String description);
}
