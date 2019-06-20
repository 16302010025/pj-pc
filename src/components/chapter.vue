<template>
  <div id="chapter">
    <el-button type="danger" @click="goback()">返回</el-button>
    <div>
      <p>{{chapterName}} 的知识点</p>
      <p>{{chapterID}}（之后删除）</p>
    </div>
    <div v-for="(point,index) in points" :key="index">
      <p>{{point.text}}</p>
    </div>
  </div>
</template>

<script>
export default {
  name: 'chapter',
  data() {
    return {
      chapterName: this.$route.params.chapterName,
      chapterID: this.$route.params.chapterID,
      points: [
        {
          text: '第一个知识点'
        },
        {
          text: '第二个知识点'
        }
      ]
    }
  },
  mounted: function () {
    this.getDetails();
  },
  methods: {
    getDetails() {
      if (this.$cookies.get("username") != undefined) {
        this.username = this.$cookies.get("username")
        // alert(this.username + " " + this.$route.params.courseID)
        this.axios.post('/getPoints', {
          username: this.username,
          chapterID: this.$routr.params.chapterID
          // password: this.pass
        })
          .then(function (response) {
            console.log(response);
            this.chapters = response.chapters
          })
          .catch(function (error) {
            // alert("非法请求")
            console.log(error);
          });
      } else {
        alert("请先登录")
      }
    },
    goback() {
      this.$router.go(-1)
    }
  }
}
</script>

<style lang="less">
</style>
