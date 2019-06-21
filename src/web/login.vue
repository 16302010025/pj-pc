<template>
  <div id="login">
    <p>教师登录界面</p>
    <div style="margin-top: 5px">
      <label for>帐号:</label>
      <el-input placeholder="用户名  (邮箱/手机号)" v-model="input" clearable onkeyup="value=value.replace(/[\u4e00-\u9fa5]/ig,'')"></el-input>
    </div>
    <div style="margin-top: 5px">
      <label for>密码:</label>
      <el-input placeholder="请输入密码" v-model="pass" show-password></el-input>
    </div>
    <div style="margin-top: 5px">
      <el-button style="width:200px;margin-top:30px;" type="primary" round @click="login()">登录</el-button>
      <br>
      <label>我是新用户</label>
      <a style="color:blue; cursor: pointer;" @click="register()">点我注册</a>
    </div>
  </div>
</template>

<script>
export default {
  name: 'login',
  data() {
    return {
      input: '',
      pass: ''
    }
  },
  methods: {
    // login() {
    //   alert("登录成功")
    //   this.$cookies.set("username", this.input, 0)
    //   this.$router.push('/home')
    // },
    login() {
      if (this.input === '' || this.pass === '') {
        alert("请完善信息")
      } else {
        // 需要写好url（对应到后端）
        this.axios.post('/login', {
          username: this.input,
          password: this.pass
        })
          .then(function (response) {
            console.log(response);
            if (response.success === true) {
              alert("登录成功")
              // teacherID
              // success bo
              // this.$cookies.set("username", this.input, 0)
              this.$cookies.set("username", response.ID, 0)
              this.$router.push('/home')
            }
          })
          .catch(function (error) {
            alert("服务出错")
            console.log(error);
          });
      }
    },
    register() {
      this.$router.push('/register')
    }
  }
}
</script>

<style lang="less">
.el-input {
  width: 250px;
}
#login {
  width: 30%;
  margin-top: 10%;
  text-align: center;
  margin-left: auto;
  margin-right: auto;
  border: 1px solid grey;
  padding-bottom: 20px;
}
</style>
