<!--A Design by W3layouts 
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Bonfire a Ecommerce Category Flat Bootstarp Responsive Website Template | Account :: w3layouts</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery.min.js"></script>
<!-- Custom Theme files -->
<!--theme-style-->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />	
<!--//theme-style-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Bonfire Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!--fonts-->
<link href='http://fonts.googleapis.com/css?family=Exo:100,200,300,400,500,600,700,800,900' rel='stylesheet' type='text/css'>
<!--//fonts-->
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
				<script type="text/javascript">
					jQuery(document).ready(function($) {
						$(".scroll").click(function(event){		
							event.preventDefault();
							$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
						});
					});
				</script>
<script>$(document).ready(function(c) {
	$('.alert-close').on('click', function(c){
		$('.message').fadeOut('slow', function(c){
	  		$('.message').remove();
		});
	});	  
});
</script>
<script>$(document).ready(function(c) {
	$('.alert-close1').on('click', function(c){
		$('.message1').fadeOut('slow', function(c){
	  		$('.message1').remove();
		});
	});	  
});
</script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"  type="text/javascript"></script> 
<script type="text/javascript">               
$(document).ready(function () {                    
    var x_timer;                    
    $("#email").keyup(function (e) {                         
        clearTimeout(x_timer);                         
        var user_name = $(this).val();                         
        x_timer = setTimeout(function () {                             
            check_username_ajax(user_name);                         
        }, 1000);                         
    });                    
    function check_username_ajax(username) {                         
        $("#user-result").html("<img src="images/ajax-loader.GIF" />");                         
        $.post('CheckEmailServlet', {'username': username}, function (data) {                             
            $("#user-result").html(data);                          
        });                    
    }                
});         
</script> 
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="container">
		<div class="account">
			<h2 class="account-in">THÔNG TIN ĐĂNG KÍ TÀI KHOẢN</h2>
                        <form action="UsersServlet" method="POST">
				<div>
					<p>Họ và tên(*):</p>
                                        <input type="text" required="Yes" maxlength="50" name="fullname">
				</div> 	
				<div>			
					<p>Email(*):</p>
                                        <input type="text"  required="Yes" maxlength="50" name="email"> 
                                        <span id="user-result"></span>
				</div>
				<div> 	
					<p>Password(*):</p>
                                        <input type="password" required="Yes" maxlength="50" name="Password"> 
				</div>
				<div> 
					<p>Nhập lại password(*):</p>
                                        <input type="password" required="Yes" maxlength="50" name="repassword">
				</div>	
                                        <input type="hidden" value="insert" name="command">
					<input type="submit" value="Đăng kí">
                                        
			</form>
		</div>
	</div>	
        <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>