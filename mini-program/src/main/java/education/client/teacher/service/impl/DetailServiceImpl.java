package education.client.teacher.service.impl;

import education.client.teacher.service.DetailService;
import education.dao.KPDetailMapper;
import education.dao.KnowledgePointMapper;
import education.entity.KPDetail;

import javax.annotation.Resource;
import java.util.List;

public class DetailServiceImpl implements DetailService {
  @Resource
  KPDetailMapper kpDetailMapper;
  @Resource
  KnowledgePointMapper knowledgePointMapper;
  @Override
  public KPDetail findDetailByID(int detailID) {
    if (detailID>=0&&kpDetailMapper.findDetailByID(detailID)!=null){
      return kpDetailMapper.findDetailByID(detailID);
    }
    return null;
  }

  @Override
  public String gainDescriptionByID(int detailID) {
    if (detailID>=0&&kpDetailMapper.findDetailByID(detailID)!=null){
      return kpDetailMapper.findDetailByID(detailID).getDescription();
    }
    return null;
  }

  @Override
  public List<Integer> findDetailIDByID(int knowledgeID) {
    if (knowledgeID>=0&&knowledgePointMapper.findKnowledgeByID(knowledgeID)!=null){
      return knowledgePointMapper.findDetailByID(knowledgeID);
    }
    return null;
  }

  @Override
  public boolean addDetail(int knowledgeID, String description) {
    if (knowledgeID<0||description==null||description.equals("")||knowledgePointMapper.findKnowledgeByID(knowledgeID)){
      return false;
    }else {
      kpDetailMapper.addDetail(knowledgeID,description);
      return true;
    }

  }

  @Override
  public boolean updateDetail(int detailID, String description) {
    if (detailID<0||description==null||description.equals("")||kpDetailMapper.findDetailByID(detailID)){
      return false;
    }else {
      kpDetailMapper.updateDetail(detailID,description);
      return true;
    }
  }
}
