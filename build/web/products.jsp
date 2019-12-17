?category=<!--A Design by W3layouts 
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<%@page import="model.Product" %>
<%@page import="dao.ProductDao" %>
<%@page import="model.Cart" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<title>Bonfire a Ecommerce Category Flat Bootstarp Responsive Website Template | Products :: w3layouts</title>
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
    <%
        ProductDao productDao = new ProductDao();
        String category_id = "";
        if(request.getParameter("category") != null){
            category_id = request.getParameter("category");
        }
        Cart cart = (Cart) session.getAttribute("cart");
        if(cart == null ){
            cart = new Cart();
            session.setAttribute("cart", cart);
        }
        
        %>
	<jsp:include page="header.jsp"></jsp:include>
	
		<div class="container">
			<div class="products">
                        <%
                            for(Product p : productDao.getListProductByCategory(Integer.parseInt(category_id))){
                        %>
					<div class=" top-products">
                                            
						<div class="col-md-3 md-col">
							<div class="col-md">
								<a 
                                                                    href="single.jsp?product=<%=p.getProductID()%>"><img  src="<%=p.getProductImage()%>" alt="<%=p.getProductName()%>" />								
								</a>	
								<div class="top-content">
									<h5><a href="single.jsp?product=<%=p.getProductID()%>"><%=p.getProductName()%></a></h5>
                                                                        <h5><a href="single.jsp?product=<%=p.getProductID()%>" >Xem chi tiết sản phẩm</a></h5>
									<div class="white">
                                                                            <a href="CartServlet?command=plus&productID=<%=p.getProductID()%>"
                                                                               class="hvr-shutter-in-vertical hvr-shutter-in-vertical2">THÊM VÀO GIỎ HÀNG</a>
                                                                                
                                                                            <p class="dollar"><span ><%=p.getProductPrice()%></span><span>VNĐ</span></p>
                                                                            <div class="clearfix"></div>
									</div>
								</div>							
							</div>
						</div>
                        <%
                              }
                        %>              
					<div class="clearfix"></div>
					
			</div>
		</div>
		<!---->
		
                
                 <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>