<template>
  <div id="mystuList">
    <el-button type="danger" @click="goback()">返回</el-button>
    <!-- 已经完成的 -->
    <div class="stulistbox">
      <div class="stulist">
        <p>选课学生</p>
        <div class="stucard" v-for="(myStu,index) in myStus" :key="index">
          <p>{{myStu.name}}</p>
        </div>
      </div>
    </div>

  </div>
</template>

<script>
export default {
  name: 'mystuList',
  data() {
    return {
      myStu: [
        {
          name: '张三'
        },
        {
          name: '张三'
        },
        {
          name: '张三'
        },
        {
          name: '张三'
        }
      ]
    }
  },
  mounted: function () {
    this.getStuList();
  },
  methods: {
    goback() {
      this.$router.go(-1)
    },
    getStuList() {
      this.axios.post('/getPapList', {
        courseID: this.$route.params.courseID,
      })
        .then(function (response) {
          console.log(response);
          this.myStus = response.myStus;
        })
        .catch(function (error) {
          console.log(error);
        });
    }
  }
}
</script>

<style lang="less">
.stulistbox {
  display: flex;
}
.stucard {
  margin-top: 10px;
  border: solid 0.1px rgb(238, 238, 238);
  box-shadow: 3px 3px 5px #c7c7c7;
  p {
    margin-left: 30px;
  }
}
.stulist {
  margin-bottom: 40px;
  margin-left: auto;
  margin-right: auto;
  width: 400px;
  padding: 30px;
  padding-bottom: 100px;
  border: solid 0.1px rgb(238, 238, 238);
  background-color: rgba(230, 224, 212, 0.527);
  box-shadow: 3px 3px 1px 4px rgb(165, 141, 132), 0 0 6px rgb(197, 178, 124);
  border-radius: 3%;
}
</style>
