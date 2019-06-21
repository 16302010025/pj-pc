<template>
  <div id="mypappers">
    <el-button type="danger" @click="goback()">返回</el-button>
    <p class="wdwenjuan">已发布的问卷</p>
    <div class="pappers">
      <div class="card" v-for="(question,index) in questions" :key="index" @click="details(index)">
        <p class="card-title">{{question.ques_title}}</p>
        <p class="card-body">问卷id：{{question.papperId}}</p>
        <p class="card-body">学生完成情况：{{question.finishnum}} / {{studentnum}}</p>
      </div>
    </div>

  </div>
</template>

<script>
export default {
  name: 'mypappers',
  data() {
    return {
      studentnum: '60',
      questions: [
        {
          ques_title: '问卷1',
          papperId: '12345',
          finishnum: '55'
        },
        {
          ques_title: '期末考试',
          papperId: '987654',
          finishnum: '32'
        },
      ]
    }
  },
  mounted: function () {
    this.getMyPapper();
  },
  methods: {
    details(index) {
      this.$router.push('/papper/' + this.$route.params.courseID + '/' + this.questions[index].papperId)
    },
    getMyPapper() {
      this.axios.post('/getMyPappers', {
        courseID: this.$route.params.courseID,
      })
        .then(function (response) {
          console.log(response);
          this.questions = response.papperList;
          this.studentnum = response.studentnum;
        })
        .catch(function (error) {
          console.log(error);
        });
    },
    goback() {
      this.$router.go(-1)
    },
  }
}
</script>

<style lang="less">
.card-title {
  font-size: 20px;
  margin-left: 20px;
}
.card-body {
  font-size: 15px;
  margin-left: 20px;
}
.pappers {
  display: flex;
  flex-direction: row;
  justify-content: flex-start;
  flex-wrap: wrap;
}
.card {
  margin-left: 15px;
  box-shadow: 3px 3px 1px 4px rgb(165, 141, 132), 0 0 6px rgb(197, 178, 124);
  border-radius: 3%;
  width: 400px;
  height: 250px;
  margin-top: 20px;
  display: flex;
  flex-direction: column;
  background-color: rgb(230, 224, 212);
  cursor: pointer;
}
.wdwenjuan {
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
</style>
