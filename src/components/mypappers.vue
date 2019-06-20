<template>
  <div id="mypappers">
    <el-button type="danger" @click="goback()">返回</el-button>
    <p class="wdwenjuan">已发布的问卷</p>
    <div>
      <!-- <p>mypappers</p> -->
    </div>
  </div>
</template>

<script>
export default {
  name: 'mypappers',
  data() {
    return {
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
    this.getMyPapper();
  },
  methods: {
    getMyPapper() {
      this.axios.post('/getMyPappers', {
        courseID: this.$route.params.courseID,
      })
        .then(function (response) {
          console.log(response);
          this.questions = response.questions;
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
.wdwenjuan {
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
