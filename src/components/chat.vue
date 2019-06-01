<template>
  <div id="chat">
    <!-- <p>chat</p> -->
    <div id="top">
      <el-button style="float:left;margin-top:10px;margin-left:20px;" type="info" @click="back()">返回列表</el-button>
    </div>
    <div>
        <img style="width:100%" src="../../static/img.png" alt="">
    </div>
  </div>
</template>

<script>
export default {
  name: 'chat',
  data() {
    return {
    }
  },
  methods: {
    back() {
      this.$router.push('/home')
    }
  }
}
</script>

<style lang="less">
#top {
    width: 100%;
    height: 60px;
    background-color: #545c64;
}
</style>

