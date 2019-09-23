function register() {
  var username = $("#username").val();
  var password1 = $("#password").val();
  var password2 = $("#passwordTwo").val();
  var  job = $("#job").val();
  var sex = $("#sex").val();
  var birthday = $("#birthday").val();
  var email = $("#email").val();
  var phone = $("#phone").val();

  var cityName = $("#cityName").val();
  var roleId = $("#roleId").val();
  var address = $("#address").val();

  if (checkEmpty(username)) {
    alert("用户名不能为空！");
  }
  if (checkEmpty(phone)) {
    alert("用户手机号不能为空！");
  }

  if (checkEmpty(email)) {
    alert("用户邮箱不能为空！");
  }
  if (checkEmpty(password1)) {
    alert("用户密码不能为空！");
  }
  if (password1 !== password2) {
    alert("两次密码不一致！");
  }

  var data = {
    username: username,
    password: password1,
    phone: phone,
    email: email,
    roleId: roleId,
    cityName: cityName,
    address: address,
    birthday: birthday,
    sex: sex,
    job: job
  }
  console.log(JSON.stringify(data))


  $.post(
      {
        type: "POST",
        url: "/user/registerPost",
        contentType: "application/json;charset-UTF-8",
       data: JSON.stringify(data),
        dataType: "json",
        success: function (data) {
          alert(data);
          if (data.genData() > 0) {
            alert("注册成功");
            window.location.href = "/user/homepage";
          } else {
            alert(data.error);
            window.location.href = "/user/homepage";
          }
        },
        error:function () {
          alert("注册失败，请检查数据重试");
          window.location.href = "/user/register"
        }

      });


  function checkEmpty(str) {
    if(str == "" || str == undefined || str == null || (str.length>0 && str.trim().length == 0)){
      return true;
    }
    return false;
  }
}
