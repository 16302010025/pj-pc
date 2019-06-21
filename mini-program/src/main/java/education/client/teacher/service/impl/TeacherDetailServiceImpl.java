package education.client.teacher.service.impl;

import education.client.teacher.service.TeacherDetailService;
import education.dao.KPDetailMapper;
import education.dao.KnowledgePointMapper;
import education.entity.KPDetail;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TeacherDetailServiceImpl implements TeacherDetailService {
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
      return knowledgePointMapper.findDetailIDByID(knowledgeID);
    }
    return null;
  }

  @Override
  public int addDetail(int knowledgeID, String description) {
    if (knowledgeID<0||description==null||description.equals("")||knowledgePointMapper.findKnowledgeByID(knowledgeID)==null){
      return -1;
    }else {
      int detailID=kpDetailMapper.addDetail(knowledgeID,description);
      return detailID;
    }

  }

  @Override
  public boolean updateDetail(int detailID, String description) {
    if (detailID<0||description==null||description.equals("")||kpDetailMapper.findDetailByID(detailID)==null){
      return false;
    }else {
      kpDetailMapper.updateDetail(detailID,description);
      return true;
    }
  }
}
