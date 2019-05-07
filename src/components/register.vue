<template>
  <div id="register">
    <p>注册</p>
    <el-button @click="login()">登录</el-button>
  </div>
</template>

<script>
export default {
  name: 'register',
  data() {
    return {

    }
  },
  methods: {
    login() {
      this.$router.push('/')
    }
  }
}
</script>

<style lang="less">
#register {
  margin-top: 10%;
  text-align: center;
}
</style>

