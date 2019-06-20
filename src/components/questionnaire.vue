<template>
  <div id="questionnaire">
    <el-button type="danger" @click="goback()">返回</el-button>
    <p class="title">发布课程问卷</p>
    <div class="papper">

      <div class="main-ques" v-for="(question,index) in questions" :key="index">
        <div class="queslist">
          <span>问题：</span>
          <el-input placeholder="输入问题内容" v-model="question.ques_title"></el-input>
          <el-button type="success" plain @click="addopt(index)">新加选项</el-button>
          <el-button type="danger" plain @click="delQues(index)">删除题目</el-button>
        </div>
        <div class="optlist" v-for="(option,index2) in question.options" :key="index2">
          <span>选项{{index2}}: </span>
          <el-input placeholder="输入选项内容" v-model="option.opt_txt"></el-input>
          <el-button type="danger" plain @click="delOpt(index,index2)">删除选项</el-button>
        </div>
        <div class="key">
          <span>答案: </span>
          <el-input placeholder="输入答案（选项对应的数字）" v-model="question.num"></el-input>
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
export default {
  name: 'questionnaire',
  data() {
    return {
      radio: '',
      questions: [
        {
          ques_title: '',
          options: [
            {
              opt_txt: '',
            }
          ],
          num: '',
        }
      ]
    }
  },
  mounted: function () {

  },
  methods: {
    //   添加选项
    addopt(index) {
      this.questions[index].options.push({ opt_txt: '' });
    },
    // 删除题目
    delQues(index) {
      this.questions.splice(index, 1);
    },
    // 删除选项
    delOpt(index, index2) {
      this.questions[index].options.splice(index2, 1);
    },
    // 添加题目
    addques() {
      this.questions.push({ ques_title: '', options: [{ opt_txt: '' }] });
    },
    submit() {
      this.axios.post('/question', {
        courseID: this.$route.params.courseID,
        description: this.questions.ques_title,
        option: this.questions.options,
        correctchoose: this.questions.num,
      })
        .then(function (response) {
          console.log(response);
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
.key {
  margin-top: 10px;
  display: flex;
  align-items: center;
  span {
    width: 50px;
  }
  .el-input {
    width: 205px;
  }
}
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
    width: 80px;
  }
  .el-input {
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
.optlist {
  clear: both;
  margin-top: 10px;
  display: flex;
  align-items: center;
  .el-input {
    margin-right: 10px;
  }
  span {
    width: 80px;
  }
}
.bot {
  margin-top: 20px;
}
</style>
