<template>
  <div id="stuList">
    <el-button type="danger" @click="goback()">返回</el-button>
    <!-- 已经完成的 -->
    <div class="stulistbox">
      <div class="stulist">
        <p>已提交的学生：</p>
        <div class="stucard" v-for="(finishStu,index) in finishStus" :key="index">
          <p>{{finishStu.name}}</p>
        </div>
      </div>
      <!-- 还没完成的 -->
      <div class="stulist">
        <p>未提交的学生：</p>
        <div class="stucard" v-for="(unfinishStu,index) in unfinishStus" :key="index">
          <p>{{unfinishStu.name}}</p>
        </div>
      </div>
    </div>

  </div>
</template>

<script>
export default {
  name: 'stuList',
  data() {
    return {
      finishStus: [
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

      ],
      unfinishStus: [
        {
          name: '李四',
        }
      ]
    }
  },
  mounted: function () {
    this.getStuPapList();
  },
  methods: {
    goback() {
      this.$router.go(-1)
    },
    getStuPapList() {
      this.axios.post('/getStuPapList', {
        courseID: this.$route.params.courseID,
        papperID: this.$route.params.papperID,
      })
        .then(function (response) {
          console.log(response);
          this.finishStus = response.finishStus;
          this.unfinishStus = response.unfinishStus;
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
