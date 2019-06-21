<template>
  <div id="point">
    <el-button type="danger" @click="goback()">返回</el-button>
    <div class="point_bg">
      <div>
        <div class="point_title">
          <span>知识点名称：</span>
          <el-input placeholder="新知识点名称" v-model="point_name"></el-input>
        </div>
        <div class="new_point_content" v-for="(detail,index) in point_details" :key="index">
          <span>知识点细节：</span>
          <el-input placeholder="新知识点内容" v-model="detail.point_text"></el-input>
          <el-button type="danger" @click="remove(index)">删除</el-button>
        </div>
      </div>
      <div class="new-poi-but">
        <el-button class="button-bottom" type="info" @click="adddet()">新加知识点细节</el-button>
        <el-button class="button-bottom" type="success" @click="submit()">提交</el-button>
      </div>

    </div>
  </div>
</template>

<script>
export default {
  name: 'point',
  data() {
    return {
      point_name: '',
      pointID: this.$route.params.pointID,
      point_details: [
        {
          point_text: ''
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
        this.axios.post('http://localhost:8080/getKpDtails', {
          knowledgeID: this.$route.params.pointID
        })
          .then(function (response) {
            console.log(response);
            this.point_name = response.data.point_name;
            this.point_details = response.data.point_details
          }.bind(this))
          .catch(function (error) {
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
      // alert(this.$route.params.pointID)
      if (this.$cookies.get("username") != undefined) {
        if (this.$route.params.pointID == 'null') {
          // 新建知识点
          this.axios.post('http://localhost:8080/addKnowledge', {
            // pointID: this.$route.params.pointID,
            knowledgeName: this.point_name,
            chapterID: this.$route.params.chapterID,
            knowledgePoints: this.point_details,
          })
            .then(function (response) {
              console.log(response);
            }.bind(this))
            .catch(function (error) {
              console.log(error);
            });
        } else {
          // 修改知识点
          this.axios.post('http://localhost:8080/modKnowledge', {
            pointID: this.$route.params.pointID,
            knowledgeName: this.point_name,
            point_details: this.point_details
          })
            .then(function (response) {
              console.log(response);
            }.bind(this))
            .catch(function (error) {
              console.log(error);
            });
        }

      } else {
        alert("请先登录")
        this.router.push('/')
      }
    }
  }
}
</script>

<style lang="less">
.new-poi-but {
  margin-top: 10px;
  margin-right: 48px;
  display: flex;
  justify-content: flex-end;
}
.new_point_content {
  display: flex;
  margin-top: 10px;
  align-items: center;
  justify-content: start;
  .el-input {
    margin-right: 20px;
    width: 800px;
  }
  span {
    width: 150px;
  }
}
.button-bottom {
  margin-top: 10px;
}
.point_bg {
  margin-top: 20px;
  padding: 30px;
  width: 85vw;
  margin-left: auto;
  margin-right: auto;
  border: solid 0.1px rgb(238, 238, 238);
  box-shadow: 10px 10px 5px #888888;
}
.point_title {
  display: flex;
  align-items: center;
  justify-content: start;
  span {
    width: 150px;
  }
  .el-input {
    width: 300px;
  }
}
</style>
