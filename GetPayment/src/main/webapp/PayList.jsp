<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css">         
<script src="js/bootstrap.min.js"></script>
<title>Add payment to list</title>
</head>
<body>
		<%try{
		    org.springframework.context.ApplicationContext context = new   
		    	org.springframework.context.support.ClassPathXmlApplicationContext 
	        	("spring/application-config.xml");
			com.bionic.edu.payment.PaymentService paymentService =
					(com.bionic.edu.payment.PaymentService)
					context.getBean("paymentServiceImp");
			com.bionic.edu.merchant.MerchantService merchantService =
					(com.bionic.edu.merchant.MerchantService)
					context.getBean("merchantServiceImp");
			com.bionic.edu.payment.Payment payment = new com.bionic.edu.payment.Payment();
			java.text.DateFormat df = new java.text.SimpleDateFormat("dd-MM-yyyy");
			java.util.Date dt = df.parse(request.getParameter("date"));
			java.sql.Date sqlD = new java.sql.Date(dt.getTime());
			payment.setDt(sqlD);
			payment.setMerchantId(Integer.valueOf(request.getParameter("merchantId")));
			payment.setCustomerId(Integer.valueOf(request.getParameter("customerId")));
			payment.setGoods(request.getParameter("goods"));
			payment.setSumPayed(Double.valueOf(request.getParameter("sumPayed")));
			payment.setChargePayed(Double.valueOf(request.getParameter("chargePayed")));
			for(com.bionic.edu.merchant.Merchant m : merchantService.findAll()) {
				if(payment.getMerchantId() == m.getId()) {
					m.setNeedToSend(Math.round((m.getNeedToSend() + payment.getSumPayed()) * 100.0) / 100.0);
					merchantService.update(m);
				}
			}
			paymentService.save(payment);


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