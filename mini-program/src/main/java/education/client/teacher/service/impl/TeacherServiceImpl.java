package education.client.teacher.service.impl;

import education.client.teacher.service.TeacherService;
import education.dao.TeacherMapper;
import education.entity.Teacher;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

//教师信息处理类
@Service
public class TeacherServiceImpl implements TeacherService {
  @Resource
  TeacherMapper teacherMapper;
  //根据名字找教师
  @Override
  public Teacher findTeacherByName(String name) {
    if (name==null||name.equals("")){//输入是否不合法
      return null;
    }else {
      return teacherMapper.findTeacherByName(name);
    }
  }

  //判断教师用户名及密码是否对应
  @Override
  public boolean isPasswordMatch(String name, String password) {
    if (name==null||name.equals("")||password==null||password.equals("")){//输入是否不合法
      return false;
    }else {
      Teacher teacher=teacherMapper.findTeacherByName(name);
      if (teacher==null){//用户名是否存在
        return false;
      }else if (teacher.getPassword().equals(password)){//是否匹配
        return true;
      }else {
        return false;
      }
    }
  }

  //新增一个教师
  @Override
  public boolean addTeacher(String name,String password,boolean gender,String description) {
    if(name==null||name.equals("")||password==null||password.equals("")){//输入是否不合法
      return false;
    }else {
      Teacher teacher=teacherMapper.findTeacherByName(name);
      if (teacher==null){//用户名是否存在
        Teacher addTeacher=new Teacher();
        addTeacher.setName(name);
        addTeacher.setPassword(password);
        addTeacher.setGender(gender);
        addTeacher.setDescription(description);
        teacherMapper.insert(addTeacher);
        return true;
      }else {
        return false;
      }

    }
  }

  //密码匹配情况下修改密码
  @Override
  public boolean updatePassword(String name, String newPassword) {
    if (name==null||name.equals("")||newPassword==null||newPassword.equals("")){//输入是否不合法
      return false;
    }else {
      Teacher teacher=teacherMapper.findTeacherByName(name);
      if (teacher==null){//用户名是否存在
        return false;
      }else {
        teacherMapper.updatePassword(name,newPassword);
        return true;
      }
    }
  }


}
