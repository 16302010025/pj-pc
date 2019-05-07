<template>
  <div id="login">
    <p>教师登录界面</p>
    <div style="margin-top: 5px">
      <label for>帐号:</label>
      <el-input placeholder="用户名" v-model="input" clearable></el-input>
    </div>
    <div style="margin-top: 5px">
      <label for>密码:</label>
      <el-input placeholder="请输入密码" v-model="pass" show-password></el-input>
    </div>
    <div style="margin-top: 5px">
      <el-button @click="login()">登录</el-button>
      <label for>新用户</label>
      <el-button @click="register()">注册</el-button>
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
    login() {
      alert("success")
      this.$router.push('/main')
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
  margin-top: 10%;
  text-align: center;
}
</style>

