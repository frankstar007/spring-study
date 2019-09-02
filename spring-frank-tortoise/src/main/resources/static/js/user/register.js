<script>
function register() {
  var name = $("#name").val();
  var password1 = $("#password").val();
  var password2 = $("#passwordTwo").val();
  var  job = $("#job").val();
  if (Number(password1) == Number(password2)){
    $.post("/register",{name:name,password:password1,job:job},function (res) {
      if (res ==true){
        alert("注册成功");
        window.location.href ="/login";
      } else {
        alert("注册失败，请检查数据重试");
      }
    })
  }else {
    alert("两次密码不一致！");
  }
}
</script>