<template>
  <div id="mysubject">
    <div>
      <p class="title">我的课程</p>
      <div class="details">
        <p class="course_name">{{this.courseName}}</p>
        <p class="course_disc">{{this.discription}}</p>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'mysubject',
  data() {
    return {
      username: '',
      courseName: this.$route.params.courseName,
      discription: this.$route.params.discription,
      chapters: [
        {
          chapterName: '',
        }
      ]
    }
  },
  mounted: function () {
    this.getDetails();
  },
  methods: {
    getDetails() {
      if (this.$cookies.get("username") != undefined) {
        this.username = this.$cookies.get("username")
        // alert(this.username + " " + this.$route.params.id)
        this.axios.post('/getDetails', {
          username: this.username,
          courseID: this.$route.params.id
          // password: this.pass
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
.details {
  border: solid 1px black;
  width: 450px;
}
</style>
