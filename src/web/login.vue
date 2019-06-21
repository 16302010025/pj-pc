<template>
  <div id="login">
    <p class="logtext">教师登录界面</p>
    <div style="margin-top: 5px">
      <label for>帐号:</label>
      <el-input placeholder="用户名  (邮箱/手机号)" v-model="input" clearable onkeyup="value=value.replace(/[\u4e00-\u9fa5]/ig,'')"></el-input>
    </div>
    <div style="margin-top: 5px">
      <label for>密码:</label>
      <el-input placeholder="请输入密码" v-model="pass" show-password></el-input>
    </div>
    <div style="margin-top: 5px">
      <el-button style="width:200px;margin-top:15px;" type="primary" round @click="login()">登录</el-button>
      <div style="margin-top: 15px">
        <label>我是新用户? </label>
        <a style="color:blue; cursor: pointer;" @click="register()">点我注册</a>
      </div>

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
.logtext {
  font-size: 30px;
  font-weight: 600;
  font-family: "Courier New", Courier, monospace;
}
.el-input {
  width: 250px;
}
#login {
  width: 30%;
  margin-top: 10%;
  text-align: center;
  margin-left: auto;
  margin-right: auto;
  padding-bottom: 20px;
  border-radius: 10px;
  background-color: rgb(246, 246, 246);
  border: solid 1px rgb(238, 238, 238);
  box-shadow: 10px 10px 5px #888888;
}
</style>
