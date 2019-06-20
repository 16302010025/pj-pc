package education.client.teacher.service.impl;

import education.client.teacher.service.KnowledgeService;
import education.dao.ChapterMapper;
import education.dao.KnowledgePointMapper;
import education.entity.KnowledgePoint;

import javax.annotation.Resource;
import java.util.List;

public class KnowledgeServiceImpl implements KnowledgeService {
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
  public boolean addKnowledge(int chapterID, String knowledgeName) {
    if (chapterID<0||knowledgeName==null||knowledgeName.equals("")||chapterMapper.findChapterByID(chapterID)==null){
      return false;
    }else {
      knowledgePointMapper.addKnowledge(chapterID,knowledgeName);
      return true;
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

