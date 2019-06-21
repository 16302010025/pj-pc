<template>
  <div id="chapter">
    <el-button type="danger" @click="goback()">返回</el-button>
    <div class="cha_bg">
      <div>
        <p class="cha-name">{{chapterName}} 的知识点</p>
      </div>
      <div class="apoint" v-for="(point,index) in points" :key="index">
        <div style="display: flex; align-items: center">
          <span style="font-size: 28px;margin-right: 200px; width: 700px">{{point.text}}</span>
          <el-button type="info" @click="modify(index)">修改</el-button>
          <el-button type="danger" @click="remove(index)">删除</el-button>
        </div>
        <div v-for="(content,index2) in points[index].contents" :key="index2">
          <p style="color: grey">{{content.con_det}}</p>
        </div>
      </div>
      <div class="buttons"> 
        <el-button type="success" @click="newpoint()">新建知识点</el-button>
        <el-button type="danger" @click="deleteChapter()">删除本章节</el-button>
      </div>

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
          text: '..',
          pointID: '.',
          contents: [
            {
              con_det: '..',
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
    deleteChapter() {
      alert('删除id为：' + this.chapterID + '的章节')
      this.axios.post('/deleteChapter', {
        chapterID: this.$routr.params.chapterID
      })
        .then(function (response) {
          console.log(response);
        })
        .catch(function (error) {
          console.log(error);
        });
    },
    modify(index) {
      this.$router.push('/point/' + this.chapterID + '/' + this.points[index].pointID)
    },
    remove(index) {
      alert('删除id为：' + this.points[index].pointID + '的point')
      this.points.splice(index, 1);
      this.axios.post('/deletePoints', {
        pointID: this.points[index].pointID,
      })
        .then(function (response) {
          console.log(response);
        })
        .catch(function (error) {
          console.log(error);
        });
    },
    newpoint() {
      this.$router.push('/point/' + this.chapterID + '/null')
    },
    getDetails() {
      if (this.$cookies.get("username") != undefined) {
        this.username = this.$cookies.get("username")
        this.axios.post('/getKnowledge', {
          // username: this.username,
          chapterID: this.$routr.params.chapterID
        })
          .then(function (response) {
            console.log(response);
            this.points = response.knowledgePoints
            // this.contents = response.contents
          })
          .catch(function (error) {
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
.el-button {
  max-height: 40px;
}
.cha_bg {
  margin-top: 20px;
  padding: 30px;
  width: 85vw;
  margin-bottom: 50px;
  margin-left: auto;
  margin-right: auto;
  border: solid 0.5px rgb(200, 200, 200);
  box-shadow: 10px 10px 5px #888888;
  border-radius: 10px;
}
.cha-name {
  font-size: 30px;
  margin-top: 0;
  margin-bottom: 0;
  text-align: center;
  font-family: "League-Gothic", Courier;
  text-transform: uppercase;
  color: #fff;
  text-shadow: 0 0 2px #fefcc9, 1px -1px 3px #feec85, -2px -2px 4px #ffae34,
    2px -4px 5px #ec760c, -2px -6px 6px #cd4606, 0 -8px 7px #973716,
    1px -9px 8px #451b0e;
}
.apoint {
  margin-top: 10px;
  border: solid 1px rgba(0, 0, 0, 0.315);
  background-color: #fafafa;
  border-radius: 20px;
  padding: 20px;
}
.buttons {
  margin-top: 20px;
}
</style>
