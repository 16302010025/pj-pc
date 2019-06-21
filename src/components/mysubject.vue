<template>
  <div id="mysubject">
    <el-button type="danger" @click="goback()">返回</el-button>
    <el-button class="quesbutton" type="warning" @click="question()">发布课程问卷</el-button>
    <el-button class="quesbutton" type="warning" plain @click="checkmyq()">查看发布的问卷</el-button>
    <p class="title">我的课程</p>
    <div class="body">
      <div class="course_info">
        <p class="course_name">{{courseName}}</p>
        <p class="course_disc">课程简介： {{discription}}</p>
      </div>
      <div class="sub-details">
        <div class="addcha">
          <el-input placeholder="新建章节名称" v-model="cha_name"></el-input>
          <el-button type="warning" @click="addchapter()">添加章节</el-button>
        </div>
        <div class="boxcha" v-for="(item,index) in chapters" :key="index" @click="details(index)">
          <p class="mychapters">{{item.chapterName}}</p>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'mysubject',
  data() {
    return {
      cha_name: '',
      username: '',
      courseName: this.$route.params.courseName,
      discription: this.$route.params.discription,
      chapters: [
        {
          chapterName: '第一章',
          chapterID: '12345'
        }
      ]
    }
  },
  mounted: function () {
    this.getDetails();
  },
  methods: {
    checkmyq() {
      this.$router.push('/mypappers/' + this.$route.params.id)
    },
    question() {
      this.$router.push('/questionnaire/' + this.$route.params.id)
    },
    addchapter() {
      if (this.cha_name != '') {
        this.axios.post('/addChapter', {
          courseID: this.$route.params.id,
          chapterName: this.cha_name,
          description: '.'
        })
          .then(function (response) {
            console.log(response);
            this.chapters = response.chapters
          })
          .catch(function (error) {
            console.log(error);
          });
      } else {
        alert(this.$route.params.id + "请输入章节名称")
      }
    },
    details(index) {
      // alert(this.chapters[index].chapterName)
      this.$router.push('/chapter/' + this.chapters[index].chapterName + '/' + this.chapters[index].chapterID)
    },
    goback() {
      this.$router.go(-1)
    },
    getDetails() {
      if (this.$cookies.get("username") != undefined) {
        this.username = this.$cookies.get("username")
        this.axios.post('/getChapter', {
          courseID: this.$route.params.id
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
    }
  }
}
</script>

<style lang="less">
.title {
  border-bottom: solid 1px #888888;
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
  margin-top: 15px;
  margin-left: 40px;
  font-size: 36px;
  font-weight: 600;
  font-family: "Courier New", Courier, monospace;
}

.course_disc {
  font-size: 18px;
  color: rgb(119, 119, 119);
}
.course_info {
  padding: 20px;
  width: 450px;
  margin-left: 75px;
  border-radius: 10px;
  border: solid 1px rgb(238, 238, 238);
  box-shadow: 10px 10px 5px #888888;
}
.sub-details {
  padding: 20px;
  width: 500px;
  margin-left: 100px;
  border-radius: 10px;
  border: solid 1px rgb(238, 238, 238);
  box-shadow: 10px 10px 5px #888888;
}
.body {
  display: flex;
  margin-top: 30px;
}
.boxcha {
  margin-top: 10px;
  border: solid 0.1px rgb(238, 238, 238);
  box-shadow: 3px 3px 5px #c7c7c7;
}
.mychapters {
  cursor: pointer;
  margin-left: 30px;
}
.addcha {
  display: flex;
  .el-input {
    margin-right: 10px;
  }
}
</style>
