package education.client.teacher.service;

import education.entity.KnowledgePoint;

import java.util.List;

public interface KnowledgeService {
  /**
   *
   * @param knowledgeID 知识点ID
   * @return 知识点
   */
  KnowledgePoint findKnowledgeByID(int knowledgeID);

  /**
   *
   * @param knowledgeID 知识点ID
   * @return 知识点细节ID
   */
  List<Integer> findDetailByID(int knowledgeID);

  /**
   *
   * @param chapterID 章节ID
   * @param knowledgeName 知识点
   * @return 是否成功
   */
  boolean addKnowledge(int chapterID, String knowledgeName);

  /**
   *
   * @param knowledgeID 知识点ID
   * @param name 修改后的名字
   * @return 是否成功
   */
  boolean updateKnowledge(int knowledgeID, String name);

}
