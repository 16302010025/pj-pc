<template>
  <div id="papper">
    <el-button type="danger" @click="goback()">返回</el-button>
    <div class="big-body">
      <div>
        <p class="pap-title">{{pappername}}</p>
      </div>
      <div class="ques-card" v-for="(question,index) in questions" :key="index">
        <p class="ques">问题{{index + 1}} : {{question.ques_title}}</p>
        <div class="opt">
          <div>
            <p>A. {{question.optionA}}</p>
          </div>
          <div>
            <p>B. {{question.optionB}}</p>
          </div>
          <div>
            <p>C. {{question.optionC}}</p>
          </div>
          <div>
            <p>D. {{question.optionD}}</p>
          </div>
        </div>
        <p>正确答案：{{question.num}}</p>
        <p class="corrate">正确率：{{question.correctnum}} / {{finishnum}}</p>
      </div>
      <div class="delpapperbut">
        <el-button type="danger" plain @click="delPapper()">删除问卷</el-button>
      </div>

    </div>

  </div>
</template>

<script>
export default {
  name: 'papper',
  data() {
    return {
      pappername: '期中小测',
      finishnum: '77',
      questions: [
        {
          ques_title: 'qq',
          optionA: '123',
          optionB: '22',
          optionC: '24',
          optionD: '88',
          num: 'D',
          correctnum: '66'
        },
        {
          ques_title: 'qq',
          optionA: '123',
          optionB: '22',
          optionC: '24',
          optionD: '88',
          num: 'D',
          correctnum: '66'
        }
      ],
    }
  },
  mounted: function () {
    this.getPapperDetails();
  },
  methods: {
    goback() {
      this.$router.go(-1)
    },
    delPapper() {
      this.axios.post('/delPapper', {
        papperID: this.$route.params.papperID,
      })
        .then(function (response) {
          console.log(response);
          this.$router.go(-1)
        })
        .catch(function (error) {
          console.log(error);
        });
    },
    getPapperDetails() {
      this.axios.post('/getPapperDet', {
        papperID: this.$route.params.papperID,
      })
        .then(function (response) {
          console.log(response);
          this.pappername = response.pappername;
          this.questions = response.questions;
          this.finishnum = response.finishnum;
        })
        .catch(function (error) {
          console.log(error);
        });
    }
  }
}
</script>

<style lang="less">
.delpapperbut {
  margin-top: 30px;
  float: right;
  margin-right: 30px;
}
.ques-card {
  margin-left: auto;
  margin-right: auto;
  width: 800px;
  padding-left: 30px;
  padding-right: 30px;
  padding-top: 10px;
  padding-bottom: 10px;
  margin-top: 15px;
  border-radius: 10px;
  background-color: rgb(246, 246, 246);
  border: solid 1px rgb(238, 238, 238);
  box-shadow: 10px 10px 5px #888888;
}
.big-body {
  margin-bottom: 40px;
  margin-left: auto;
  margin-right: auto;
  width: 900px;
  padding: 30px;
  padding-bottom: 100px;
  border: solid 0.1px rgb(238, 238, 238);
  background-color: rgba(230, 224, 212, 0.527);
  box-shadow: 3px 3px 1px 4px rgb(165, 141, 132), 0 0 6px rgb(197, 178, 124);
  border-radius: 3%;
}
.pap-title {
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
.ques {
  font-size: 24px;
  font-weight: 600;
  color: #444444;
}
.corrate {
  color: #c36009;
}
.opt {
  div {
    border: solid 0.1px rgb(238, 238, 238);
    box-shadow: 0 0 1px #888888;
    border-radius: 4px;
    background-color: #fafafa;
    p {
      margin-left: 30px;
      color: #444444;
    }
  }
}
</style>
