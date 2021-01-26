<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=no" name="viewport">
  <title>佳薪棠（北京）科技有限公司</title>
</head>
<link rel="stylesheet" href="/css/index.css">

<body>
  <div class="container">
    <img src="/images/1@2x.png" alt="">
    <img src="/images/2@2x.png" alt="">
    <img src="/images/3@2x.png" alt="">
    <div class="operation">
      <p>心动不如行动</p>
      <p>立即联系佳薪棠，锁定你的权益</p>
    </div>
    <div class="phone">
      <a href="tel://18610186740" class="call-phone"> <i class="phone-icon"><img src="/images/phone@3x.png" alt=""></i>
        致电佳薪棠</a>
    </div>
    <div class="bottom">
      <div class="bottom-tip">
        <p>您也可以留下联系方式</p>
        <p>我们会尽快安排相关人员与您联系</p>
      </div>
      <img class="flower" src="/images/flower@3x.png" alt="" action="##">

      <form class="form-data" id="my-form" action="https://formspree.io/f/zouqi@ipaynow.cn" method="POST">

        <div class="column">
          <label> 公司名称:</label>
          <input class="ipt" id="company" type="text" placeholder="请输入公司名称" name="公司名称"><span
            class="company_msg position"></span>
        </div>

        <div class="column">
          <label>联系人:</label>
          <input class="ipt" id="contacts" type="text" placeholder="请输入联系人" name="联系人">
          <span class="contacts_msg position"></span>
        </div>

        <div class="column">
          <label>电话:</label>
          <input class="ipt" id="phone" type="text" placeholder="请输入电话" name="电话">
          <span class="phone_msg position"></span>
        </div>
        <div class="column">
          <label>留言:（选填）</label>
          <textarea class="ipt" placeholder="请输入您的留言" name="留言"></textarea>
        </div>

        <button class="submit" id="my-form-button" type="submit">提交</button>
        <p id="my-form-status"></p>


      </form>

      <div class="copyright">
        <p>佳薪棠（北京）科技有限公司</p>
        <p>你好现在（北京）科技股份有限公司</p>
      </div>
      <img class="bottom-decorate" src="/images/bottom-decorate@3x.png" alt="">
    </div>

  </div>

</body>

</html>
<script src="/js/flexible.js"></script>
<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<script>

  var registerBtn = document.getElementById("my-form-button");
  var company_state = false;
  var contacts_state = false;
  var phone_state = false;

  function register() {

    var company = document.getElementById("company");
    var contacts = document.getElementById("contacts");
    var phone = document.getElementById("phone");

    var company_msg = document.getElementsByClassName("company_msg")[0];
    var contacts_msg = document.getElementsByClassName("contacts_msg")[0];
    var phone_msg = document.getElementsByClassName("phone_msg")[0];

    // 公司
    company.onblur = function () {
      if (this.value == "") {
        company_msg.innerHTML = "请输入公司名称!";
        company_state = false;
      } else {
        company_state = true;
        company_msg.innerHTML = "";
      }
      checkForm();
    }

    // 联系人
    contacts.onblur = function () {
      if (this.value == "") {
        contacts_msg.innerHTML = "请输入联系人!";
        contacts_state = false;
      } else {
        contacts_state = true;
        contacts_msg.innerHTML = "";
      }
      checkForm();
    }

    // 电话
    phone.onblur = function () {
      phone_msg.innerHTML = "";
      var tel = /^(\(\d{3,4}\)|\d{3,4}-|\s)?\d{7,14}$/;
      var phone = /^((13[0-9])|(14[5,7,9])|(15[^4])|(18[0-9])|(17[0,1,3,5,6,7,8]))[0-9]{8}$/;

      if (this.value.length == 0) {
        phone_msg.innerHTML = "请输入电话!";

        phone_state = false;
      } else if (this.value.length == 11) {//手机号码
        if (phone.test(this.value)) {
          phone_state = true;
        } else {
          phone_state = false;
          phone_msg.innerHTML = "请输入有效的号码!"
        }
      } else if (tel.test(this.value)) {//电话号码
        phone_state = true;
      } else {
        phone_state = false;
        phone_msg.innerHTML = "请输入有效的号码!"
      }
      checkForm();
    }
  }
  register()

  // function checkForm() {
  //   if (company_state && contacts_state && phone_state) {
  //     registerBtn.removeAttribute("disabled");
  //     $("#my-form-button").removeClass("readySubmit");
  //
  //   } else {
  //     registerBtn.setAttribute("disabled", "");
  //     $("#my-form-button").addClass("readySubmit");
  //   }
  //
  // }

  // 监听form表单
  window.addEventListener("DOMContentLoaded", function () {
    var form = document.getElementById("my-form");
    var button = document.getElementById("my-form-button");
    var status = document.getElementById("my-form-status");

    function success() {
      form.reset();
      // button.style = "display: none";
      // $("#my-form-button").addClass("readySubmit");
      status.innerHTML = "信息发送成功，我们会尽快安排相关人员与您联系!";

      setTimeout(function(){
        location.reload();
        document.body.scrollTop = document.documentElement.scrollTop = 0;
      },1000)

    }

    function error() {
      status.innerHTML = "请求错误!请稍后再试!";
    }

    form.addEventListener("submit", function (ev) {
      ev.preventDefault();
      var data = new FormData(form);
      ajax(form.method, form.action, data, success, error);
    });
  });

  // 发送数据
  function ajax(method, url, data, success, error) {
    var xhr = new XMLHttpRequest();
    xhr.open(method, url);
    xhr.setRequestHeader("Accept", "application/json");
    xhr.onreadystatechange = function () {
      if (xhr.readyState !== XMLHttpRequest.DONE) return;
        success(xhr.response, xhr.responseType);
    };
    xhr.send(data);
  }

</script>