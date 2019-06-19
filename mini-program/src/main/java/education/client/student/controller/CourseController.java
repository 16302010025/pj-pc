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

    //得到全部课程
    @RequestMapping(value = "getAllCourse")
    public String getAllCourse() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("list", courseService.getAllCourse());
        return jsonObject.toJSONString();
    }

    //学生添加课程
    @RequestMapping(value = "addcourse")
    public String addCourse(@RequestParam String studentId, @RequestParam int courseId) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("flag",courseService.addCourse(studentId, courseId));
        return jsonObject.toJSONString();
    }

    //得到course所有章节id，name，decription
    @RequestMapping(value = "getChapter")
    public String getAllChapterByCourseId(@RequestParam String courseId) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("list",courseService.getAllChapterByCourseId(courseId)) ;
        return jsonObject.toJSONString();
    }

    //得到对应章节的所有知识点
    @RequestMapping(value = "getkpoint")
    public String getAllKnowledgePointByChapterId(int chapterId) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("list", courseService.getAllKnowledgePointByChapterId(chapterId));
        return jsonObject.toJSONString();
    }
}
