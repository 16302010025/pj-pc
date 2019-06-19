package education.client.student.controller;

import education.client.student.service.StudentService;
import education.entity.Student;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
@RequestMapping("user")
public class StudentController {
    @Resource
    private StudentService studentService;

    @PostMapping(value = "loginAuth", produces = "application/json;UTF-8")
    public String login(@RequestParam() String code) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("openid",studentService.login(code));
        return jsonObject.toJSONString();
    }
    //获得和完善用户信息的接口,用id取得学生全部个人信息
    @RequestMapping(value = "getStu", produces = "application/json;UTF-8")
    public String getStu(@RequestParam() String studentid) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("student",studentService.getStudentById(studentid));
        return jsonObject.toJSONString();
    }

    // 更新个人信息
    @PostMapping(value = "updateStu", produces = "application/json;UTF-8")
    public String updateStu(@RequestParam() String studentid, @RequestParam() String email, @RequestParam() String name,
                             @RequestParam() boolean gender, @RequestParam() String studentNo) {
        JSONObject jsonObject = new JSONObject();
        Student student = new Student();
        student.setStudentid(studentid);
        student.setEmail(email);
        student.setName(name);
        student.setGender(gender);
        student.setStudentno(studentNo);
        Student checkedStudent = studentService.getStudentById(studentid);
        if(null == checkedStudent){
            jsonObject.put("flag",false);
            return jsonObject.toJSONString();
        }
        studentService.update(student);
        jsonObject.put("flag",true);
        return jsonObject.toJSONString();
    }
}
