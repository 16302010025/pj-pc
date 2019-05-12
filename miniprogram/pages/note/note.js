
var that;
var app = getApp();

Page({

  data: {
    showPage: true,
    title:'heljl',
    nodeBody: '',
    bodyHtml: ''
  },

  onLoad: function (options) {

    this.setData({
      bodyHtml: app.richTextParse(`<code>如上图所示，在this.data中设置ceshi这条数据，在方法中，我们定义ceshi变量让其等于that.data.ceshi; 然后对ceshi进行操作，其实就是对that.data.ceshi进行操作，而that.setData({ceshi})就等同于that.setData({ceshi : ceshi }) ; 第一个ceshi 是that.data.ceshi， 第二个ceshi 是我们定义的变量ceshi。通过打印的结果可以看到，数据已经添加上了。
--------------------- 
作者：NAMECZ 
来源：CSDN 
原文：https://blog.csdn.net/NAMECZ/article/details/79623550 
版权声明：本文为博主原创文章，转载请附上博文链接！</code>`),
      showPage: true
    })
 

  }
})
