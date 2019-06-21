// pages/chapter/chapter.js
import courseApi from '../../apis/courseApi.js'
Page({

  /**
   * 页面的初始数据
   */
  data: {
    courseid: '',
    cname: '',
    chapters: [{
        'chapterid': '12',
        'chaptername': '应用层',
        'desc': '电风扇电风扇'
      },
      {
        'chapterid': '13',
        'chaptername': '传输层',
        'desc': '空调空调'
      },
      {
        'chapterid': '14',
        'chaptername': '数据层',
        'desc': '冰箱冰箱'
      }
    ]
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {
    let that = this;
    let api = new courseApi;
    that.setData({
      cname: options.cname,
      courseid: options.cid
    })
    console.log(that.courseid);
    api.getChapter(that.courseid).then(data => {
      that.setData({
        chapters: data
      })
    })
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function() {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function() {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function() {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function() {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function() {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function() {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function() {

  }
})