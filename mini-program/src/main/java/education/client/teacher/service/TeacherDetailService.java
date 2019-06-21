package education.client.teacher.service;

import education.entity.KPDetail;

import java.util.List;

public interface TeacherDetailService {
  /**
   *
   * @param detailID 知识点细节ID
   * @return 知识点对象
   */
  KPDetail findDetailByID(int detailID);

  /**
   *
   * @param detailID 知识点细节ID
   * @return 描述
   */
  String gainDescriptionByID(int detailID);

  /**
   *
   * @param knowledgeID 知识点ID
   * @return 知识点细节ID
   */
  List<Integer> findDetailIDByID(int knowledgeID);

  /**
   *
   * @param knowledgeID 知识点ID
   * @param description 描述
   * @return 所添加知识点细节的ID
   */
  int  addDetail(int knowledgeID, String description);

  /**
   *
   * @param detailID 知识点细节ID
   * @param description 修改后的描述
   * @return 是否成功
   */
  boolean updateDetail(int detailID, String description);
}
