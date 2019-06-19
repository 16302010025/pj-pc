<template>
  <div id="home">
    <div class="top">
      <el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal" @select="handleSelect"
        background-color="#545c64" text-color="#fff" active-text-color="#ffd04b">
        <el-menu-item index="center">教师工作中心</el-menu-item>
        <el-button v-if="this.login === true" style="float:right;margin-top:10px;margin-right:20px;" type="warning"
          @click="logout()">退出登录</el-button>
        <el-button v-if="this.login === true" style="float:right;margin-top:10px;margin-right:20px;" type="info"
          @click="modify()">修改信息</el-button>
        <el-button v-if="this.login === false" style="float:right;margin-top:10px;margin-right:20px;" type="info"
          @click="gotologin()">登录</el-button>
      </el-menu>
    </div>
    <center></center>
  </div>
</template>

<script>
import center from '@/components/center'
export default {
  components: {
    center
  },
  name: 'home',
  data() {
    return {
      login: false,
      activeIndex: 'center'
    }
  },
  mounted: function () {
    this.islogin();
  },
  methods: {
    gotologin() {
      // alert("okkkk")
      this.$router.push('/')
    },
    islogin() {
      if (this.$cookies.get("username") != undefined) {
        this.login = true;
      }
    },
    logout() {
      alert("成功退出登录");
      this.$cookies.remove("username")
      this.$router.push('/')
    },
    handleSelect(key) {
      console.log(key);
    },
    modify() {
      this.$router.push('/modify')
    }
  }
}
</script>

<style lang="less">
</style>
