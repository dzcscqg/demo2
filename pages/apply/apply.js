var app = getApp()
Page({
  data: {
    routers: [
      {
        name: '考试项目',
        url: '/pages/Course/course',
        icon: '../../img/app1.png',
        code: '10'
      },
      {
        name: '考试咨讯',
        url: '/pages/Course/course',
        icon: '../../img/aap2.png',
        code: '11'
      },
      {
        name: '公示公告',
        url: '/pages/Course/course',
        icon: '../../img/app3.png',
        code: '10'
      },
      {
        name: '考试报名',
        url: '/pages/sign/sign',
        icon: '../../img/app4.png',
        code: '11'
      },
      {
        name: '成绩查询',
        url: '/pages/search/search',
        icon: '../../img/app5.png',
        code: '10'
      },
      {
        name: '证书查询',
        icon: '../../img/app6.png',
        code: '11'
      },
      {
        name: '考生服务',
        url: '/pages/Course/course',
        icon: '../../img/app7.png',
        code: '10'
      },
      {
        name: '证书直邮',
        icon: '../../img/app8.png',
        code: '11'
      },
      {
        name: '其他信息',
        url: '/pages/Course/course',
        icon: '../../img/app9.png',
        code: '10'
      }
    ]
  },
  
  onLoad(e) {
    console.log(e.title)
    this.setData({
      msgList: [
        { url: "url", title: "公告| 严惩考试违法犯罪　维护考试公平公正" },
        { url: "url", title: "通知| 关于申报国家教育考试科研规划2019年度课题" },
        { url: "url", title: "消息| 教育部考试中心2019-2020年度信息安全服务项目中标公告" }]
    });
  },
  tzBtn: function(e){

  }
})