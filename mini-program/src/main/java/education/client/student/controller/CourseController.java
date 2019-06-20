package education.client.student.controller;

import education.client.student.service.CourseService;
import net.minidev.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("course")
public class CourseController {
  @Resource
  private CourseService courseService;

  //4.1 得到学生所选课程
  @RequestMapping(value = "getCourse")
  public String getCourse(@RequestParam String studentID) {
    JSONObject jsonObject = new JSONObject();
    jsonObject.put("list", courseService.getAllCourse());
    return jsonObject.toJSONString();
  }

  //4.2得到全部课程
  @RequestMapping(value = "getAllCourse")
  public String getAllCourse() {
    JSONObject jsonObject = new JSONObject();
    jsonObject.put("list", courseService.getAllCourse());
    return jsonObject.toJSONString();
  }

  //4.3学生添加课程
  @RequestMapping(value = "addcourse")
  public String addCourse(@RequestParam String studentID, @RequestParam int courseId) {
    JSONObject jsonObject = new JSONObject();
    jsonObject.put("status", courseService.addCourse(studentID, courseId));
    return jsonObject.toJSONString();
  }

  //4.4 得到course所有章节id，name，decription
  @RequestMapping(value = "getChapter")
  public String getAllChapterByCourseId(@RequestParam String courseId) {
    JSONObject jsonObject = new JSONObject();
    jsonObject.put("list", courseService.getAllChapterByCourseId(courseId));
    return jsonObject.toJSONString();
  }

  //4.5 得到对应章节的所有知识点
  @RequestMapping(value = "getkpoint")
  public String getAllKnowledgePointByChapterId(@RequestParam int chapterId) {
    JSONObject jsonObject = new JSONObject();
    jsonObject.put("list", courseService.getAllKnowledgePointByChapterId(chapterId));
    return jsonObject.toJSONString();
  }

  //3.2 添加收藏
  @PostMapping(value = "addFav")
  public String addFav(@RequestParam String studentID, @RequestParam int kpID) {
    JSONObject jsonObject = new JSONObject();
    jsonObject.put("status", courseService.addFav(studentID, kpID));
    return jsonObject.toJSONString();
  }

  //3.3 删除收藏
  @PostMapping(value = "delFav")
  public String delFav(@RequestParam String studentID, @RequestParam int kpID) {
    JSONObject jsonObject = new JSONObject();
    jsonObject.put("status", courseService.delFav(studentID, kpID));
    return jsonObject.toJSONString();
  }

  //3.4 获取笔记列表
  @RequestMapping(value = "getNote")
  public String getNote(@RequestParam String studentID) {
    JSONObject jsonObject = new JSONObject();
    return jsonObject.toJSONString();
  }

  //3.5 添加笔记
  @PostMapping(value = "addNote")
  public String addNote(@RequestParam String studentID, @RequestParam int kpID, @RequestParam String description) {
    JSONObject jsonObject = new JSONObject();
    jsonObject.put("status", courseService.addNote(studentID, kpID, description));
    return jsonObject.toJSONString();
  }
  //3.6 删除笔记
  @PostMapping(value = "delNote")
  public String delNote(@RequestParam String studentID, @RequestParam int memoID) {
    JSONObject jsonObject = new JSONObject();
    jsonObject.put("status", courseService.delNote(memoID));
    return jsonObject.toJSONString();
  }
}
