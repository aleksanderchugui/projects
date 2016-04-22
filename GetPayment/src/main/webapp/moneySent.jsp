<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!--<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">-->
  <meta http-equiv="refresh" content="1; URL='MainPage.html'" />
<link rel="stylesheet" href="css/bootstrap.min.css">         
<script src="js/bootstrap.min.js"></script>
<title>Merchant's table</title>
</head>
<body>
		<%try{
			
		    org.springframework.context.ApplicationContext context = new   
		    	org.springframework.context.support.ClassPathXmlApplicationContext 
	        	("spring/application-config.xml");
			com.bionic.edu.transmoney.TransmoneyService transmoneyService =
					(com.bionic.edu.transmoney.TransmoneyService)
					context.getBean("transmoneyServiceImp");
			com.bionic.edu.merchant.MerchantService merchantService = 
					(com.bionic.edu.merchant.MerchantService)context.getBean("merchantServiceImp");

			transmoneyService.sendMoneyToMerchants(Double.valueOf(request.getParameter("availableSum")));

			}catch(Exception e){%>
				<div class="alert alert-danger">Oooops, some errors%></div>
			<%}%>

	<%response.setStatus(response.SC_MOVED_TEMPORARILY);
	response.setHeader("Location", "mainPage.jsp");%>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="bootstrap_script.js"></script>
</body>
</html>