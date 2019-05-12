<template>
  <div id="home">
    <el-menu
      :default-active="activeIndex"
      class="el-menu-demo"
      mode="horizontal"
      @select="handleSelect"
      background-color="#545c64"
      text-color="#fff"
      active-text-color="#ffd04b"
    >
      <!-- 代码优化的话需要在el-menu最后添加router -->
      <el-menu-item index="center">教师工作中心</el-menu-item>
      <el-menu-item index="myclass">我的课程</el-menu-item>
      <el-menu-item index="students">联系学生</el-menu-item>
      <!-- <el-button> -->
      <el-button
        style="float:right;margin-top:10px;margin-right:20px;"
        type="info"
        @click="logout()"
      >退出登录</el-button>
    </el-menu>
    <!-- <div v-show="this.showtime1">
      <p>center</p>
    </div> -->
    <center v-show="this.showtime1"></center>
    <myclass v-show="this.showtime2"></myclass>
    <students v-show="this.showtime3"></students>
  </div>
</template>

<script>
// import { truncate } from 'fs';
import center from '@/components/center'
import myclass from '@/components/myclass'
import students from '@/components/students'
export default {
  components :{
    center,
    myclass,
    students
  },
  name: 'home',
  data() {
    return {
      activeIndex: 'center',
      showtime1: true,
      showtime2: false,
      showtime3: false,
    }
  },
  // 日后代码优化可以重新做，用router
  // computed: {
  //   activeIndex() {
  //     return this.$route.path.replace('/', '')
  //   }
  // },
  methods: {
    logout() {
      alert("成功退出登录");
      this.$router.push('/')
    },
    handleSelect(key) {
      console.log(key);
      if (key == 'center') {
        this.showtime1 = true;
        this.showtime2 = false;
        this.showtime3 = false;
      } else if (key == 'myclass') {
        this.showtime1 = false;
        // this.showtime1 = true;
        this.showtime2 = true;
        this.showtime3 = false;
      } else {
        this.showtime1 = false;
        this.showtime2 = false;
        this.showtime3 = true;
      }
    }
  }
}
</script>

<style lang="less">
</style>

