<template>
  <div id="questionnaire">
    <el-button type="danger" @click="goback()">返回</el-button>
    <p class="quetitle">发布课程问卷</p>
    <div class="papper">
      <el-input class="pafirel" placeholder="输入问卷名" v-model="pappername"></el-input>
      <div class="main-ques" v-for="(question,index) in questions" :key="index">
        <div class="queslist">
          <span>问题：</span>
          <el-input placeholder="输入问题内容" v-model="question.ques_title"></el-input>
          <!-- <el-button type="success" plain @click="addopt(index)">新加选项</el-button> -->
          <el-button type="danger" plain @click="delQues(index)">删除题目</el-button>
        </div>
        <div class="optlist">
          <span>选项A: </span>
          <el-input placeholder="输入选项内容" v-model="question.optionA"></el-input>
        </div>
        <div class="optlist">
          <span>选项B: </span>
          <el-input placeholder="输入选项内容" v-model="question.optionB"></el-input>
        </div>
        <div class="optlist">
          <span>选项C: </span>
          <el-input placeholder="输入选项内容" v-model="question.optionC"></el-input>
        </div>
        <div class="optlist">
          <span>选项D: </span>
          <el-input placeholder="输入选项内容" v-model="question.optionD"></el-input>
        </div>
        <div class="key">
          <span>答案: </span>
          <el-input placeholder="输入答案" v-model="question.num"></el-input>
        </div>
      </div>
      <div class="bot">
        <el-button class="button-bottom" type="info" @click="addques()">新加题目</el-button>
        <el-button class="button-bottom" type="success" @click="submit()">发布</el-button>
      </div>

    </div>
  </div>
</template>

<script>
import { all } from 'q';
export default {
  name: 'questionnaire',
  data() {
    return {
      pappername: '',
      check_empty: false,
      questions: [
        {
          ques_title: '',
          optionA: '',
          optionB: '',
          optionC: '',
          optionD: '',
          num: '',
        }
      ]
    }
  },
  mounted: function () {

  },
  methods: {
    //   添加选项
    // addopt(index) {
    //   this.questions[index].options.push({ opt_txt: '' });
    // },
    // 删除题目
    delQues(index) {
      this.questions.splice(index, 1);
    },
    // 删除选项
    // delOpt(index, index2) {
    //   this.questions[index].options.splice(index2, 1);
    // },
    // 添加题目
    addques() {
      this.questions.push({ ques_title: '', optionA: '', optionB: '', optionC: '', optionD: '', num: '' });
    },
    checkPapper() {
      if (this.pappername.trim() == '') {
        this.check_empty = true;
      }
      this.questions.forEach(element => {
        if (element.num.trim() == '' || element.ques_title.trim() == '' || element.optionA.trim() == '' || element.optionB.trim() == '' || element.optionC.trim() == '' || element.optionD.trim() == '') {
          this.check_empty = true;
        }
      });
    },
    submit() {
      this.check_empty = false;
      this.checkPapper();
      if (this.check_empty == true) {
        alert('请先完善信息');
      } else {
        this.axios.post('/addPapper', {
          pappername: this.pappername,
          courseID: this.$route.params.courseID,
          questions: this.questions,
        })
          .then(function (response) {
            console.log(response);
          })
          .catch(function (error) {
            console.log(error);
          });
      }

    },
    goback() {
      this.$router.go(-1)
    },
  }
}
</script>

<style lang="less">
.key {
  margin-top: 10px;
  display: flex;
  align-items: center;
  span {
    width: 70px;
  }
  .el-input {
    width: 205px;
  }
}
.quetitle {
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
.main-ques {
  display: flex;
  flex-direction: column;
  margin-top: 20px;
  padding: 20px;
  border: solid 0.1px rgb(238, 238, 238);
  box-shadow: 3px 3px 5px #c7c7c7;
}
.queslist {
  display: flex;
  align-items: center;
  span {
    width: 70px;
  }
  .el-input {
    width: 500px;
    margin-right: 10px;
  }
}
.papper {
  padding: 20px;
  width: 800px;
  margin-top: 30px;
  margin-left: auto;
  margin-right: auto;
  border: solid 0.1px rgb(238, 238, 238);
  box-shadow: 10px 10px 5px #888888;
}
.pafirel {
  width: 800px;
}
.optlist {
  clear: both;
  margin-top: 10px;
  display: flex;
  align-items: center;
  .el-input {
    margin-right: 10px;
    width: 500px;
  }
  span {
    width: 70px;
  }
}
.bot {
  margin-top: 20px;
}
</style>
