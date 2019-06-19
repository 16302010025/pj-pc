<template>
  <div id="newsubject">
    <div class="bg">
      <p class="title">新建课程</p>
      <div class="main_body">
        <div class="input_body">
          <span class="text">新建课程</span>
          <el-input class="" placeholder="课程名称" v-model="sub_name" clearable></el-input>
        </div>
        <div class="input_body">
          <span class="text">课程简介</span>
          <el-input placeholder="课程简介" v-model="sub_brief" clearable></el-input>
        </div>
        <div class="buttons">
          <el-button type="danger" plain @click="cansel()">取消新建</el-button>
          <el-button type="success" plain @click="newsub()">新建课程</el-button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'newsubject',
  data() {
    return {
      sub_name: '',
      username: '',
      sub_brief: '',

    }
  },
  mounted: function () {
  },
  methods: {
    newsub() {
      if (this.$cookies.get("username") != undefined) {
        this.username = this.$cookies.get("username")
        alert(this.username)
        this.axios.post('/newsubject', {
          username: this.username,
          sub_name: this.sub_name,
          sub_brief: this.sub_brief,

        })
          .then(function (response) {
            console.log(response);
            this.classes = response.classes
          })
          .catch(function (error) {
            // alert("请求失败")
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
.bg {
  margin-left: auto;
  margin-right: auto;
  width: 50%;
  height: 90vh;
  border:solid 0.1px rgb(238, 238, 238);
  box-shadow: 10px 10px 5px #888888;
}

.title {
  font-size: 30px;
  margin-top: 55px;
  margin-bottom: -5px;

  text-align: center;
  font-family: "League-Gothic", Courier;
  text-transform: uppercase;
  color: #fff;
  text-shadow: 0 0 2px #fefcc9, 1px -1px 3px #feec85, -2px -2px 4px #ffae34,
    2px -4px 5px #ec760c, -2px -6px 6px #cd4606, 0 -8px 7px #973716,
    1px -9px 8px #451b0e;
}
.main_body {
  display: flex;
  justify-content: center;
  flex-direction: column;
  align-items: center;
}
.input_body {
  margin-top: 30px;
  width: 400px;
  display: flex;
  justify-content: center;
  align-items: center;
}
.text {
  width: 100px;
}
.buttons {
  margin-top: 100px;
  margin-left: 200px;
}
</style>
