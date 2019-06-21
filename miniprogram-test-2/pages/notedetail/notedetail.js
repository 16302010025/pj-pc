// pages/notedetail/notedetail.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    kpname: '',
    kpid: '',
    noteid: '',
    notetext: '',
  },
  delnote: function(){
    wx.showToast({
      title: '删除成功',
      duration: 1000
    })
    wx.navigateBack({
      
    })
  },
  savenote: function(){
wx.showToast({
  title: '保存成功',
  duration: 1000
})
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    let that = this;
    that.setData({
      kpname: options.kpname,
      kpid: options.kpid,
    })
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})