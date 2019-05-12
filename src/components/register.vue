<template>
  <div id="register">
    <p>开始注册</p>
   
    <div style="margin-top: 5px">
      <label style="width:200px;" for>帐号:</label>
      <el-input placeholder="用户名  (邮箱/手机号)" v-model="input" clearable></el-input>
       <!-- <el-button type="primary" round>点击验证</el-button> -->
    </div>
    <div style="margin-top: 5px">
      <label for>密码:</label>
      <el-input placeholder="请输入密码" v-model="pass" show-password></el-input>
    </div>
     <div style="margin-top: 5px">
      <label for>再次输入密码:</label>
      <el-input placeholder="请重复输入密码" v-model="checkpass" show-password></el-input>
    </div>
    <div style="margin-top: 5px">
      <el-button style="width:200px;margin-top:30px;" type="primary" round @click="login()">注册</el-button>
     
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
      alert("注册成功，马上登录");
      this.$router.push('/')
    }
  }
}
</script>

<style lang="less">
.el-input {
  width: 250px;
}

#register {
   width: 50%;
  margin-top: 10%;
  text-align: center;
  margin-left: auto;
  margin-right: auto;
  border:1px solid grey;
  padding-bottom: 20px;
  // margin-top: 10%;
  // text-align: center;
}
</style>

