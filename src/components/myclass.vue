<template>
  <div id="myclass">
    <p>webcome to this class</p>
     <el-table
    :data="tableData"
    stripe
    style="width: 100%">
    <el-table-column
      prop="date"
      label="日期"
      width="180">
    </el-table-column>
    <el-table-column
      prop="class"
      label="班级"
      width="180">
    </el-table-column>
    <el-table-column
      prop="content"
      label="课程内容">
    </el-table-column>
  </el-table>
  </div>
</template>

<script>
export default {
  name: 'myclass',
  data() {
   return {
        tableData: [{
          date: '2016-05-02',
          class: 'A',
          content: '数学'
        }, {
          date: '2016-05-04',
          class: 'B',
          content: '数学'
        }, {
          date: '2016-05-01',
          class: 'A',
          content: '物理'
        }, {
          date: '2016-05-03',
          class: 'F',
          content: '软件工程'
        }]
      }
  },
  methods: {

  }
}
</script>

<style lang="less">
</style>

