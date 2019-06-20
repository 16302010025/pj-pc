<template>
  <div id="point">
    <el-button type="danger" plain @click="goback()">返回</el-button>
    <div>
      <el-input placeholder="新知识点名称" v-model="point_name"></el-input>
      <div class="new_point_content" v-for="(detail,index) in point_details" :key="index">
        <el-input placeholder="新知识点内容" v-model="detail.point_text"></el-input>
        <el-button type="danger" plain @click="remove(index)">删除</el-button>
      </div>
      <el-button type="info" plain @click="adddet()">添加</el-button>
    </div>
    <el-button type="success" plain @click="submit()">提交</el-button>
  </div>
</template>

<script>
export default {
  name: 'point',
  data() {
    return {
      point_name: 'jjjj',
      pointID: this.$route.params.pointID,
      point_details: [
        {
          point_text: 'asdnljabs'
        },
        {
          point_text: 'aaa'
        }
      ],
    }
  },
  mounted: function () {
    this.getInfo();
  },
  methods: {
    getInfo() {
      if (this.$route.params.pointID != 'null') {
        this.axios.post('/getPoint', {
          pointID: this.$route.params.pointID
        })
          .then(function (response) {
            console.log(response);
            this.point_name = response.point_name;
            this.point_details = response.point_details
            //   this.points = response.points
          })
          .catch(function (error) {
            // alert("非法请求")
            console.log(error);
          });
      }
    },
    remove(index) {
      this.point_details.splice(index, 1);
    },
    adddet() {
      this.point_details.push({ point_text: '' });
    },
    goback() {
      this.$router.go(-1)
    },
    submit() {
      alert(this.$route.params.pointID)
      if (this.$cookies.get("username") != undefined) {
        this.axios.post('/addPoint', {
          pointID: this.$route.params.pointID,
          point_name: this.point_name,
          point_details: this.point_details
        })
          .then(function (response) {
            console.log(response);
          })
          .catch(function (error) {
            console.log(error);
          });
      } else {
        alert("请先登录")
        this.router.push('/')
      }
    }
  }
}
</script>

<style lang="less">
.new_point_content {
  display: flex;
}
</style>
