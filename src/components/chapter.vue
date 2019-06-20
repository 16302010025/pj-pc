<template>
  <div id="chapter">
    <el-button type="danger" plain @click="goback()">返回</el-button>
    <div>
      <p>{{chapterName}} 的知识点</p>
      <p style="color: red">这个是章节的id： {{chapterID}}（之后删除）</p>
    </div>
    <div v-for="(point,index) in points" :key="index">
      <div style="display: flex">
        <span style="font-size: 28px;margin-right: 200px">{{point.text}}</span>
        <el-button type="info" plain @click="modify(index)">修改</el-button>
        <el-button type="danger" plain @click="remove(index)">删除</el-button>
      </div>
      <p style="font-size: 13px; color: red">知识点的id： {{point.pointID}}</p>
      <div v-for="(content,index2) in points[index].contents" :key="index2">
        <p style="color: grey">{{content.con_det}}</p>
      </div>
    </div>
    <el-button type="success" plain @click="newpoint()">新建知识点</el-button>
    <!-- <el-button type="success" plain @click="save()">保存</el-button> -->
  </div>
</template>
<script>
export default {
  name: 'chapter',
  data() {
    return {
      //   point_name: '',
      //   point_detail: '',
      chapterName: this.$route.params.chapterName,
      chapterID: this.$route.params.chapterID,
      points: [
        {
          text: '第一个知识点',
          pointID: '2345678',
          contents: [
            {
              con_det: '内容内容内容内容内容内容内容内容内容内容内容内容',
            },
            {
              con_det: '内容内容dsafialbfyewlc内容内容内容',
            }
          ]
        },
        {
          text: '第二个知识点',
          pointID: 'hbhgv bnb',
          contents: [
            {
              con_det: '999',
            }
          ]
        }
      ],
    }
  },
  mounted: function () {
    this.getDetails();
  },
  methods: {
    modify(index) {
      this.$router.push('/point/' + this.chapterID + '/' + this.points[index].pointID)
    },
    remove(index) {
      this.points.splice(index, 1);
      this.contents.splice(index, 1);
      this.axios.post('/deletePoints', {
        chapterID: this.$routr.params.chapterID,
        points: this.points,
        contents: this.contents
        // password: this.pass
      })
        .then(function (response) {
          console.log(response);
        })
        .catch(function (error) {
          // alert("非法请求")
          console.log(error);
        });
    },
    newpoint() {
      this.$router.push('/point/' + this.chapterID + '/null')
    },
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
            this.points = response.points
            this.contents = response.contents
          })
          .catch(function (error) {
            // alert("非法请求")
            console.log(error);
          });
      } else {
        alert("请先登录")
        this.router.push('/')
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
