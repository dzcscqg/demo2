//index.js
//获取应用实例
var app = getApp();

Page({

  data: {
    imgs: [
      { url: '../../img/lubo01.jpg' },
      { url: '../../img/lubo02.jpg' },
      { url: '../../img/lubo03.jpg' },
      { url: '../../img/lubo04.jpg' },
      { url: '../../img/lubo05.jpg' }
    ],
    pic: [
      { url: '../../img/zxzl.png', name: '在线资料' },
      { url: '../../img/tl.png', name: '听力练习' },
      { url: '../../img/ks.png', name: '考前测试' },
    ],
    imgs2: [
      { url: '../../img/cet4.png', topic: 'CET4大学英语四级考试报名', time: '9月15日 10:00', rules: '适合一年级' },
      { url: '../../img/cet6.png', topic: 'CET6大学英语四级考试报名', time: '9月15日 10:00', rules: '适合二年级' },
      { url: '../../img/jk.jpg', topic: '全国计算机等级考试报名', time: '9月15日 10:00', rules: '适合三年级' },
      { url: '../../img/yasi.png', topic: '雅思考试报名', time: '9月15日 10:00', rules: '适合四年级' }
    ]
  },

  SininBtn: function (e) {
    wx.navigateTo({
      url: '../sign/sign',
    })
  }

})
