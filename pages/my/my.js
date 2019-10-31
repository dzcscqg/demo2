// pages/my/my.js

var app = getApp();
Page({

  data:{
    username:'',
   telephone1:''
   
  },

  onLoad: function (options) {
    console.log(app.globalData.username)
    this.setData({
      username: app.globalData.username,
      telephone1: app.globalData.telephone,
    })
  },

  SininBtn02: function () {
    wx.switchTab({
      url: '../sign/sign',
    })
  },

  OutBtn: function () {
    wx.navigateTo({
      url: '../login/login',
    })
  },

   InBtn: function () {
     wx.navigateTo({
       url: '../login/login',
     })
  },

  SeainBtn: function () {
    wx.switchTab({
      url: '../search/search',
    })
  }
})