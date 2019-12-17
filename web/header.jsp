<%-- 
    Document   : header
    Created on : Dec 2, 2019, 4:03:39 PM
    Author     : Nguye
--%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Map"%>
<%@page import="model.Item"%>
<%@page import="model.Category" %>
<%@page import="dao.CategoryDao" %>
<%@page import="model.Users" %>
<%@page import="dao.UsersDao" %>
<%@page import="model.Cart" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>header</title>
    </head>
    <body>
        <%
            CategoryDao Dao = new CategoryDao(); 
        %>
        <%
            Users u = new Users();
            if(session.getAttribute("user")!= null){
                u = (Users) session.getAttribute("user");
            }
            else{
                u.setUserEmail("");
            }
        %>
        <%
            Cart cart = (Cart) session.getAttribute("cart");
            if(cart == null){
                cart = new Cart();
                session.setAttribute("cart", cart);
            }
        %>    
        <div class="header">
		<div class="header-top">
			<div class="container">	
			<div class="header-top-in">			
				<div class="logo">
					<a href="index.jsp"><img src="images/logo.png" alt=" " ></a>
				</div>
				<div class="header-in">
					<ul class="icon1 sub-icon1">
                                                        <li><a href="#"> <%=u.getUserEmail() %></a> </li> 
							<li><a href="outsign.jsp"> ĐĂNG SUẤT </a> </li>
							<li><a href="register.jsp">  MY ACCOUNT</a></li>
							
							<li > <a href="checkout.jsp" >CHECKOUT</a> </li>	
							<li>
                                                             <div class="cart">              
                                                                            <a href="#" class="cart-in"> </a> 
                                                                            <span> <%=cart.countItem()%></span>       
                                                                        </div>         
                                                                        <ul class="sub-icon1 list">         
                                                                            <h3>NHỮNG SẢN PHẨM ĐÃ ĐƯỢC THÊM VÀO GIỎ</h3>              
                                                                            <%  for (Map.Entry<Integer, Item> list : cart.getCartItems().entrySet()) {
                                                                            %>                   
                                                                            <div class="cart_box">                       
                                                                                <div class="message">                            
                                                                                    <div class="alert-close"> </div>                              
                                                                                    <div class="list_img">  
                                                                                        <img src="<%=list.getValue().getProduct().getProductImage()%>"  class="img-responsive" alt=""> 
                                                                                    </div>                          
                                                                                    <div class="list_desc"> 
                                                                                        <h4>  
                                                                                            <a href="CartServlet?command=remove&productID= 
                                                                                               <%=list.getValue().getProduct().getProductID()%>"> 
                                                                                               <%=list.getValue().getProduct().getProductName()%>
                                                                                            </a> 
                                                                                        </h4>                                         
                                                                                        <%=list.getValue().getQuantity()%> x <span class="actual">  $<%=list.getValue().getProduct().getProductPrice()%></span>                          
                                                                                    </div>                           
                                                                                    <div class="clearfix"></div>                        
                                                                                </div>                  
                                                                            </div>                
                                                                            <%
                                                                                }
                                                                            %> 
                                                                            <div class="total">                          
                                                                                <div class="total_left">TỔNG SỐ TIỀN : </div>                          
                                                                                <div class="total_right"><%=cart.total()%> VNĐ</div>                          
                                                                                <div class="clearfix"> </div>               
                                                                            </div>               
                                                                                <div class="login_buttons">                     
                                                                                    <div class="check_button"> <a href="checkout.jsp">Check out</a>       
                                                                                    </div>              
                                                                                    <div class="clearfix"></div>        
                                                                                </div>        
                                                                                <div class="clearfix"></div>   
                                                                        </ul> 
							</li>
						</ul>
				</div>
				<div class="clearfix"> </div>
			</div>
			</div>
		</div>
		<div class="header-bottom">
		<div class="container">
			<div class="h_menu4">
				<a class="toggleMenu" href="#">Menu</a>
				<ul class="nav">
					<li class="active"><a href="index.jsp"><i> </i>Trang chủ</a></li>
					<li ><a href="#" >Danh muc sản phẩm</a>
						<ul class="drop">
                                                    <%
                                                        for(Category c : Dao.getListCategory()){
                                                    %>
							<li><a href="products.jsp?category=<%=c.getCategoryID()%>"><%=c.getCategoryName()%></a></li>							
                                                    <%
                                                        }
                                                    %>
                                                        
						</ul>
						</li> 						
						<li><a href="products.jsp?category=1" >  Tablets</a></li>            
						<li><a href="products.jsp?category=2" >Components</a></li>						  				 
						<li><a href="products.jsp?category=3" >Software</a></li>
						<li><a href="products.jsp?category=4" >Phones & PDAs </a></li>
						<li><a href="products.jsp?category=4" >  Cameras  </a></li>
						<li><a href="contact.jsp" >Contact </a></li>
					
				</ul>
				<script type="text/javascript" src="js/nav.js"></script>
			</div>
		</div>
		</div>
		<div class="header-bottom-in">
			<div class="container">
			<div class="header-bottom-on">
			<p class="wel"><a href="#">Welcome visitor you can login or create an account.</a></p>
			<div class="header-can">
				<ul class="social-in">
						<li><a href="#"><i> </i></a></li>
						<li><a href="#"><i class="facebook"> </i></a></li>
						<li><a href="#"><i class="twitter"> </i></a></li>					
						<li><a href="#"><i class="skype"> </i></a></li>
					</ul>	
					
					<div class="search">
                                            <form action="SearchServlet" method="POST">
                                                        <input type="text" name="search"  >
							<input type="submit" value="">
				            </form>
					</div>

					<div class="clearfix"> </div>
			</div>
			<div class="clearfix"></div>
		</div>
		</div>
		</div>
	</div>
    </body>
</html>
