Page({
  data: {
    isLike: false,
    // banner
    imgUrls: [
      "../../images/course.png",
      "../../images/course.png",
      "../../images/course.png",
      "../../images/course.png"
    ],
    indicatorDots: true, //是否显示面板指示点
    autoplay: true, //是否自动切换
    interval: 3000, //自动切换时间间隔,3s
    duration: 1000, //  滑动动画时长1s
    title: "course",
    teacher: "xiaoixioa",
    course_detail: "khfksff",
    isadd: false
  },
  //预览图片
  previewImage: function (e) {
    var current = e.target.dataset.src;

    wx.previewImage({
      current: current, // 当前显示图片的http链接  
      urls: this.data.imgUrls // 需要预览的图片http链接列表  
    })
  },
  // 收藏
  addLike() {
    this.setData({
      isLike: !this.data.isLike
    });
  },
  
  favorate() {

    this.setData({
      isLike: !this.data.isLike
    });
    
    wx.showToast({
      title: this.data.isLike ? '收藏成功' :'取消成功',
      icon: 'success',
      duration: 2000
    })
  },

  subcribe(){

    this.setData({
      isadd: !this.data.isadd
    });
    wx.showToast({
      title: this.data.isadd ? '订阅成功' : '取消成功',
      icon: 'success',
      duration: 2000
    })
  }
})