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

  $.post("/user/registerPost",{
    username:username,
    password:password1,
    phone:phone,
    email:email,
    roleId:roleId,
    cityName:cityName,
    address:address,
    birthday:birthday,
    sex:sex,
    job:job,
  },function (res) {
    if (res ==true){
      alert("注册成功");
      window.location.href ="/user/homepage";
    } else {
      alert("注册失败，请检查数据重试");
    }
  });



  function checkEmpty(str) {
    if(str == "" || str == undefined || str == null || (str.length>0 && str.trim().length == 0)){
      return true;
    }
    return false;
  }
}
