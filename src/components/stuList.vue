<template>
  <div id="stuList">

  </div>
</template>

<script>
export default {
  name: 'stuList',
  data() {
    return {
    }
  },
  mounted: function () {
    this.getStuPapList();
  },
  methods: {
    getStuPapList() {
      this.axios.post('/getStuPapList', {
        courseID: this.$route.params.courseID,
      })
        .then(function (response) {
          console.log(response);
          this.questions = response.papperList;
          this.studentnum = response.studentnum;
        })
        .catch(function (error) {
          console.log(error);
        });
    }
  }
}
</script>

<style lang="less">
</style>
