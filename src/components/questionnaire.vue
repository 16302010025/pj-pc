<template>
  <div id="questionnaire">
    <el-button type="danger" @click="goback()">返回</el-button>
    <p class="title">发布课程问卷</p>
  </div>
</template>

<script>
export default {
  name: 'questionnaire',
  data() {
    return {
    }
  },
  mounted: function () {
   
  },
  methods: {
    goback() {
      this.$router.go(-1)
    },
  }
}
</script>

<style lang="less">
.title {
  font-size: 30px;
  margin-top: 15px;
  margin-bottom: -5px;
  text-align: center;
  font-family: "League-Gothic", Courier;
  text-transform: uppercase;
  color: #fff;
  text-shadow: 0 0 2px #fefcc9, 1px -1px 3px #feec85, -2px -2px 4px #ffae34,
    2px -4px 5px #ec760c, -2px -6px 6px #cd4606, 0 -8px 7px #973716,
    1px -9px 8px #451b0e;
}
.course_name {
  font-size: 36px;
}
.course_disc {
  color: rgb(119, 119, 119);
}
.course_info {
  padding: 20px;
  width: 450px;
  margin-left: 75px;
  border: solid 0.1px rgb(238, 238, 238);
  box-shadow: 10px 10px 5px #888888;
}
.details {
  padding: 20px;
  width: 800px;
  margin-top: 30px;
  margin-left: auto;
  margin-right: auto;
  border: solid 0.1px rgb(238, 238, 238);
  box-shadow: 10px 10px 5px #888888;
}
.body {
  display: flex;
  margin-top: 30px;
}
.mychapters {
  cursor: pointer;
}
.addcha {
  display: flex;
  .el-input {
    margin-right: 10px;
  }
}
</style>
