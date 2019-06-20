<template>
  <div id="questionnaire">
    <el-button type="danger" @click="goback()">返回</el-button>
    <p class="title">发布课程问卷</p>
      <div class="details">
        <div class="addcha">
          <el-input placeholder="新建章节名称" v-model="cha_name"></el-input>
          <el-button type="warning" @click="addchapter()">添加章节</el-button>
        </div>
        <div v-for="(item,index) in chapters" :key="index" @click="details(index)">
          <p class="mychapters">{{item.chapterName}}</p>
        </div>
      </div>
  </div>
</template>

<script>
export default {
  name: 'questionnaire',
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
        },
        {
          chapterName: '第二章',
          chapterID: 'qqqqq'
        },
        {
          chapterName: '补充小结',
          chapterID: '65443'
        },
        {
          chapterName: '第三章',
          chapterID: '12345'
        },
        {
          chapterName: '第四章',
          chapterID: 'qqqqq'
        },
        {
          chapterName: '期末复习',
          chapterID: '65443'
        }
      ]
    }
  },
  mounted: function () {
    this.getDetails();
  },
  methods: {
    addchapter() {
      if (this.cha_name != '') {
        this.axios.post('/addchapter', {
          courseID: this.$route.params.id
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
        this.axios.post('/getDetails', {
          username: this.username,
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
