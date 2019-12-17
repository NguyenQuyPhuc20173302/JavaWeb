
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
</head>
<body>
  <!--header-->
	<jsp:include page="header.jsp"></jsp:include>
	
	<div class="container">
		<div class="account">
			<h2 class="account-in">ĐĂNG NHẬP</h2>
                        <form action="UsersServlet" method="POST">
                        <% if(session.getAttribute("error")!= null){%>
                        
                            <div>
                                <p style="color: red"><%=session.getAttribute("error")%></p>
                                
                            </div>
                        <%}%>
							
				<div> 	
					<span class="mail">Email(*)</span>
                                        <input type="text" name="email"> 
				</div>
				<div> 
					<span class="word">MẬT KHẨU(*)</span>
                                        <input type="password" name="pass">
				</div>	
                                        <input type="hidden" value="Login" name="command">
					<input type="submit" value="Login"> 
				</form>
		</div>
	</div>
		<!---->
		
        <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>