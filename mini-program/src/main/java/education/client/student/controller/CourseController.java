package education.client.student.controller;

import education.client.student.service.CourseService;
import education.entity.Chapter;
import education.entity.Course;
import education.entity.KnowledgePoint;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    //得到全部课程
    @GetMapping(value = "getAllCourse", produces = "application:josn;UTF-8")
    public String getAllCourse() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("list", courseService.getAllCourse());
        return jsonObject.toJSONString();
    }

    //学生添加课程
    @PostMapping(value = "addcourse", produces = "application:josn;UTF-8")
    public String addCourse(@RequestParam String studentId, @RequestParam int courseId) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("flag",courseService.addCourse(studentId, courseId));
        return jsonObject.toJSONString();
    }

    //得到course所有章节id，name，decription
    @GetMapping(value = "getChapter", produces = "application:josn;UTF-8")
    public String getAllChapterByCourseId(@RequestParam String courseId) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("list",courseService.getAllChapterByCourseId(courseId)) ;
        return jsonObject.toJSONString();
    }

    //得到对应章节的所有知识点
    @GetMapping(value = "getkpoint", produces = "application:josn;UTF-8")
    public String getAllKnowledgePointByChapterId(int chapterId) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("list", courseService.getAllKnowledgePointByChapterId(chapterId));
        return jsonObject.toJSONString();
    }
}
