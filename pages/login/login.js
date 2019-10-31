
var app = getApp();
Page({

  data: {
    cTelephone: '',
    cPwd: ''
  },
  
  input_tel: function (e) {
    this.setData({
      cTelephone: e.detail.value
    })
  },
  input_pwd: function (e) {
    this.setData({
    cPwd: e.detail.value
    })
  },

  //我用按钮绑定了一个向服务器发起请求的时间
  loginBtn: function (e) {
   
    if (this.data.cTelephone == '' || this.data.cPwd == '') {
      wx.showToast({
        title: '信息未填写完',
        duration: 2000
      })
    } else {
     app.globalData.telephone = this.data.cTelephone;
    
      var that = this;
      wx.request({
        url: 'http://localhost:8080/weixin/sign',
        data: {
          'cTelephone': that.data.cTelephone,
          'cPwd': that.data.cPwd
        },
        method: 'POST',
        header: {
          'content-type': 'application/json' // 默认值
        },
        success: function (res) {
          console.log(res.data)
          var message = res.data;
          wx.switchTab({
            url: '../index/index',
          })
        },
        fail: function (res) {
          console.log("fail to connect");
        }
      })
    }

  }


})