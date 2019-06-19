<template>
  <div id="home">
    <div class="top">
      <el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal" @select="handleSelect"
        background-color="#545c64" text-color="#fff" active-text-color="#ffd04b">
        <el-menu-item index="center">教师工作中心</el-menu-item>
        <el-button style="float:right;margin-top:10px;margin-right:20px;" type="warning" @click="logout()">退出登录</el-button>
        <el-button style="float:right;margin-top:10px;margin-right:20px;" type="info" @click="modify()">修改信息</el-button>
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
      activeIndex: 'center'
    }
  },

  methods: {
    logout() {
      alert("成功退出登录");
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
