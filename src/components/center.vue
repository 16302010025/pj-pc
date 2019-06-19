<template>
  <div id="center">
    <!-- 做一个是否登录的验证 -->
    <div v-if="this.login === true">
      <p class="title">我的课程</p>
      <div class="allclass">
        <div class="add" @click="issue()">
          <div>
            <p class="issue">发布新课程</p>
            <img src="../../static/add.jpg" alt="">
          </div>
        </div>
        <div class="mysubjects" v-for="item in classes" :key="item" @click="details()">
          <!-- 本地路径 -->
          <img id="pic" src="../../static/books.png" alt="">
          <div>
            <p class="name">{{item.name}}</p>
            <p class="textcontent">学生数量：{{item.number}}</p>
            <p class="textcontent">课程简介：{{item.content}}</p>
          </div>
        </div>
      </div>
    </div>

    <div v-if="this.login === false">
      <p class="title">请先登录</p>
    </div>
  </div>
</template>

<script>
import { all } from 'q';
export default {
  name: 'center',
  data() {
    return {
      username: '',
      login: true,
      // 最后把假数据替换
      classes: [
        { name: '计算机基础', number: 20, content: '计算机最基础的课程，从入门到放弃,计算机最基础的课程，从入门到放弃,计算机最基础的课程，从入门到放弃,计算机最基础的课程，从入门到放弃' },
        { name: '多媒体' },
        { name: '计算机原理' },
        { name: '图形学' },
        { name: '网络技术' },
      ]
    }
  },
  mounted: function () {
    this.getclasses();
  },
  methods: {
    issue() {
      this.$router.push('/newsubject')
    },
    details() {
      alert("课程详情正在努力开发中")
    },
    getclasses() {
      if (this.$cookies.get("username") != undefined) {
        this.username = this.$cookies.get("username")
        alert(this.username)
        this.axios.post('/getclasses', {
          username: this.username
          // password: this.pass
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
        alert("no")
        this.login = false;
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
.allclass {
  display: flex;
  flex-direction: row;
  justify-content: flex-start;
  flex-wrap: wrap;
}
.add {
  margin-left: 15px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.12), 0 0 6px rgba(0, 0, 0, 0.1);
  border-radius: 3%;
  width: 400px;
  height: 250px;
  margin-top: 20px;
  display: flex;
  justify-content: center;
  cursor: pointer;
}
.mysubjects {
  margin-left: 15px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.12), 0 0 6px rgba(0, 0, 0, 0.1);
  border-radius: 3%;
  width: 400px;
  height: 250px;
  margin-top: 20px;
  display: flex;
  cursor: pointer;
}
#pic {
  height: 200px;
  margin-top: auto;
  margin-bottom: auto;
}
.name {
  font-size: 20px;
  font-weight: 600;
}
.textcontent {
  color: #666666;
  display: -webkit-box;
  -webkit-box-orient: vertical;
  -webkit-line-clamp: 3;
  overflow: hidden;
  margin-right: 20px;
}
.issue {
  margin-top: 40px;
  text-align: center;
  font-size: 20px;
  font-weight: 600;
}
</style>
