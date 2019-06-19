Page({

  /**
   * 页面的初始数据
   */
  data: {
    name: 'Jackma',
    id: '123',
    avatar: '../../static/images/头像.jpg',
    bg_image: '../../static/images/bg2.jpg',
    note_image: '../../static/images/note.png',
    fav_image: '../../static/images/fav.png',
    conf_image: '../../static/images/per.png',
    gender: 'male',
  },
  nav:function(){
    wx.redirectTo({
      url: '../fav/fav',
    })
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.getStudentInfo();
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