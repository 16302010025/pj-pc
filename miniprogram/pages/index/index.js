//index.js

Page({
  data: {
    isAuthorized: true,
    isedit: false
  },
  onLoad: function() {
    let that = this;
    wx.getStorage({
      key: 'isedit',
      success: function(res) {
        that.setData({
          isedit: res.data
        })
      }
    })
  },
  onShow: function(options) {

    this.getUserInfoFun()
  },
  getUserInfoFun: function() {
    var S = this;
    wx.getUserInfo({
      success: function(res) {
        if (S.data.isedit) {
          wx.switchTab({
            url: '../home/home',
          })
        } else {
          wx.navigateTo({
            url: '../edit/edit',
          })
          S.setData({
            isedit: true
          })
          wx.setStorage({
            key: 'isedit',
            data: S.data.isedit,
          })
        }
      },
      fail: S.showPrePage
    })
  },
  showPrePage: function() {
    this.setData({
      isAuthorized: false
    })
  }
})