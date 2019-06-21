package education.client.teacher.service.impl;

import education.client.teacher.service.TeacherKnowledgeService;
import education.dao.ChapterMapper;
import education.dao.KnowledgePointMapper;
import education.entity.KnowledgePoint;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TeacherKnowledgeServiceImpl implements TeacherKnowledgeService {
  @Resource
  KnowledgePointMapper knowledgePointMapper;
  @Resource
  ChapterMapper chapterMapper;

  @Override
  public KnowledgePoint findKnowledgeByID(int knowledgeID) {
    if (knowledgeID>=0&&knowledgePointMapper.findKnowledgeByID(knowledgeID)!=null){
      return knowledgePointMapper.findKnowledgeByID(knowledgeID);
    }
    return null;
  }

  @Override
  public List<Integer> findKnowledgeIDByID(int chapterID) {
    if (chapterID>=0&&chapterMapper.findChapterByID(chapterID)!=null){
      return chapterMapper.findKnowledgeIDByID(chapterID);
    }
    return null;
  }

  @Override
  public int addKnowledge(int chapterID, String knowledgeName) {
    if (chapterID<0||knowledgeName==null||knowledgeName.equals("")||chapterMapper.findChapterByID(chapterID)==null){
      return -1;
    }else {
      int knowledgeID=knowledgePointMapper.addKnowledge(chapterID,knowledgeName);
      return knowledgeID;
    }

  }

  @Override
  public boolean updateKnowledge(int knowledgeID, String knowledgeName) {
    if (knowledgeID<0||knowledgeName==null||knowledgeName.equals("")||knowledgePointMapper.findKnowledgeByID(knowledgeID)==null){
      return false;
    }else {
      knowledgePointMapper.updateKnowledge(knowledgeID,knowledgeName);
      return true;
    }
  }
}

