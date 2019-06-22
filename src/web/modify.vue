<template>
  <div id="modify">
    <p>修改个人信息</p>
    <div style="margin-top: 5px">
      <label for>用户名:</label>
      <el-input placeholder="请输入用户名" v-model="user" clearable onkeyup="value=value.replace(/[\u4e00-\u9fa5]/ig,'')"></el-input>
    </div>
    <div style="margin-top: 5px">
      <label for>原密码:</label>
      <el-input placeholder="请输入原密码" v-model="pass" show-password onkeyup="value=value.replace(/[\u4e00-\u9fa5]/ig,'')"></el-input>
    </div>
    <div style="margin-top: 5px">
      <label for>新密码:</label>
      <el-input placeholder="请输入新密码" v-model="newpass" show-password></el-input>
    </div>
    <div style="margin-top: 5px">
      <label>确认新密码</label>
      <el-input placeholder="确认新密码" v-model="checknewpass" show-password></el-input>
    </div>
    <el-button style="width:200px;margin-top:30px;" type="primary" round @click="modify()">修改</el-button>
  </div>
</template>

<script>
export default {
  name: 'login',
  data() {
    return {
      user: '',
      pass: '',
      newpass: '',
      checknewpass: ''
    }
  },
  methods: {
    modify() {
      if (this.user === '' || this.pass === '' || this.newpass === '' || this.checknewpass === '') {
        alert("请完善信息")
      } else if (this.newpass != this.checknewpass) {
        alert("请输入相同的新密码")
      } else if (this.checknewpass.length < 6) {
        alert("密码过短")
      } else {
        // 需要写好url（对应到后端）
        this.axios.post('http://localhost:8080/login', {
          username: this.user,
          password: this.pass
        })
          .then(function (response) {
            console.log(response);
            if (response.data.success === true) {
              this.axios.post('http://localhost:8080/modify', {
                username: this.user,
                password: this.newpass
              })
                .then(function (res) {
                  alert("修改成功,请重新登录")
                  this.$cookies.remove("username")
                  this.$router.push('/login')
                }.bind(this))
                .catch(function (err) {
                  alert("修改失败")
                  console.log(err)
                })
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
.el-input {
  width: 250px;
}
#modify {
  width: 30%;
  margin-top: 10%;
  text-align: center;
  margin-left: auto;
  margin-right: auto;
  border: 1px solid grey;
  padding-bottom: 20px;
}
</style>
