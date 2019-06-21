<template>
  <div id="register">
    <div class="reg">
      <p class="regtitle">注册</p>
      <div class="regbody">
        <div class="regcard">
          <span>帐号:</span>
          <el-input placeholder="用户名  (邮箱/手机号)" v-model="input" clearable onkeyup="value=value.replace(/[\u4e00-\u9fa5]/ig,'')"></el-input>
        </div>
        <div class="regcard">
          <span>密码:</span>
          <el-input placeholder="请输入密码" v-model="pass" show-password></el-input>
        </div>
        <div class="regcard">
          <span>确认密码:</span>
          <el-input placeholder="请再输入一次密码" v-model="checkpass" show-password></el-input>
        </div>
        <div style="margin-top: 5px">
          <el-button style="width:200px;margin-top:30px;" type="primary" round @click="login()">注册</el-button>
        </div>
      </div>

    </div>

  </div>
</template>

<script>
export default {
  name: 'register',
  data() {
    return {
      input: '',
      pass: '',
      checkpass: '',
    }
  },
  methods: {
    login() {
      if (this.input === '' || this.pass === '' || this.checkpass === '') {
        alert("请完善信息")
      } else if (this.checkpass != this.pass) {
        alert("请输入相同的密码")
      } else if (this.pass.length < 6) {
        alert("密码不能过短")
      }
      else {
        this.axios.post('/register', {
          username: this.input,
          password: this.pass
        })
          .then(function (response) {
            console.log(response);
            if (response.isnew === true) {
              alert("注册成功，马上登录")
              this.$router.push('/')
            } else {
              alert("用户名已存在")
            }
          })
          .catch(function (error) {
            alert("服务出错")
            console.log(error);
          });
      }
    }
  }
}
</script>

<style lang="less">
.regcard {
  margin-top: 10px;
  display: flex;
  align-items: center;
  span{
    width: 100px;
  }
  .el-input {
    width: 300px;
  }
}
.regbody {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}
.regtitle {
  font-size: 30px;
  font-weight: 600;
  font-family: "Courier New", Courier, monospace;
}
.reg {
  width: 50%;
  margin-top: 10%;
  text-align: center;
  margin-left: auto;
  margin-right: auto;
  border-radius: 10px;
  background-color: rgb(246, 246, 246);
  border: solid 1px rgb(238, 238, 238);
  box-shadow: 10px 10px 5px #888888;
  padding-bottom: 20px;
}
</style>
