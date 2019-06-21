Page({
  data: {
    email: '',
    name: '',
    id: '',
    gender: ["男", "女"],
    genderindex: 0,
    college: ["清华大学", "复旦大学", "北京大学"],
    collegeindex: 0,
    isAgree: false
  },
  onLoad: function() {
    let that = this;
    wx.getStorage({
      key: 'user',
      success: function(res) {
        that.setData({
          email: res.data.email,
          genderindex: res.data.genderindex,
          name: res.data.name,
          collegeindex: res.data.collegeindex,
          id: res.data.id
        })
      }
    })
  },
  showTopTips: function() {
    var that = this;
    this.setData({
      showTopTips: true
    });
    setTimeout(function() {
      that.setData({
        showTopTips: false
      });
    }, 3000);
  },

  bindGenderChange: function(e) {
    this.setData({
      genderindex: e.detail.value
    })
  },

  bindCollegeChange: function(e) {
    this.setData({
      collegeindex: e.detail.value
    })
  },
  bindAgreeChange: function(e) {
    this.setData({
      isAgree: !!e.detail.value.length
    });
  },
  save: function(e) {
    wx.setStorage({
      key: 'user',
      data: {
        'email': this.data.email,
        'genderindex': this.data.genderindex,
        'name': this.data.name,
        'collegeindex': this.data.collegeindex,
        'id': this.data.id
      }
    })
  },
  emailInput: function(e) {
    this.setData({
      email: e.detail.value
    })
  },
  nameInput: function(e) {
    this.setData({
      name: e.detail.value
    })
  },
  idInput: function(e) {
    this.setData({
      id: e.detail.value
    })
  },
  saveInput: function(e) {
    let i = e.currentTarget.dataset.name;
    this.setData({
      i: e.detail.value
    })
    console.log(this.data.name)
  }
});