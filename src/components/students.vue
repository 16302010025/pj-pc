<template>
  <div id="students">
    <p>hello, my boys.</p>
    <el-table :data="tableData" height="350" border style="width: 100%">
      <el-table-column prop="name" label="姓名" width="180"></el-table-column>
      <el-table-column prop="class" label="班级" width="180"></el-table-column>
      <el-table-column prop="content" label="课程内容"></el-table-column>
      <el-table-column label="操作">
        <template>
            <!-- slot-scope="scope" -->
          <el-button size="mini" @click="showchat()">联系</el-button>
          <el-button size="mini" type="danger">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
export default {
  name: 'students',
  data() {
    return {
      tableData: [{
        name: '李子明',
        class: 'A',
        content: '数学'
      }, {
        name: '面筋哥',
        class: 'B',
        content: '数学'
      }, {
        name: '旗鼓相当的对手',
        class: 'A',
        content: '物理'
      }, {
        name: '王尼玛',
        class: 'F',
        content: '软件工程'
      }, {
        name: '室友',
        class: 'F',
        content: '软件工程'
      }, {
        name: '小红',
        class: 'F',
        content: '软件工程'
      }, {
        name: '程序员',
        class: 'F',
        content: '软件工程'
      }, {
        name: '哈士奇',
        class: 'F',
        content: '软件工程'
      }]
    }
  },
  methods: {
      showchat() {
          this.$router.push('/home/chat')
      }
  }
}
</script>

<style lang="less">
</style>

