<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css">         
<script src="js/bootstrap.min.js"></script>
<title>Show tables</title>
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
				com.bionic.edu.transmoney.TransmoneyService transmoneyService =
						(com.bionic.edu.transmoney.TransmoneyService)
						context.getBean("transmoneyServiceImp");%>
	<br/>
	<a name="top"></a>
	<div class="btn-group">
  		 <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">Select table <span class="caret"></span></button>
  			<ul class="dropdown-menu" role="menu">
    			<li><a href="#pay">Payment list</a></li>
    			<li><a href="#transmoney">Transmoney list</a></li>
    			<li><a href="#merch">Merchant's table</a></li>
  			</ul>
  		<a href="MainPage.html" class="btn btn-primary">Back to main page</a>
	</div>
	<br/>

	<a name="pay"></a>
	<div class="page-header" style="text-align: center">
 		<h2>Payment list</h2>
	</div>
	<a href="#top" class="btn btn-primary">Back on top</a>
	<br/>
		<table class="table table-bordered">
			<thead>
    			<tr class="active">
      				<th>Date</th>
      				<th>Merchant ID</th>
      				<th>Customer ID</th>
      				<th>Goods</th>
      				<th>Sum payed</th>
      				<th>Charge payed</th>
    			</tr>
  			</thead>
  			<tbody>
		
			<%java.util.List<com.bionic.edu.payment.Payment> listP = paymentService.findAll();
			for(com.bionic.edu.payment.Payment p : listP) {%>
			<tr>
      			<td><%=p.getDt()%></td>
      			<td><%=p.getMerchantId()%></td>
      			<td><%=p.getCustomerId()%></td>
      			<td><%=p.getGoods()%></td>
      			<td><%=p.getSumPayed()%></td>
      			<td><%=p.getChargePayed()%></td>
    		</tr>
			<%}%>
			<tbody>
	</table>
	<br/>

	<a name="transmoney"></a>
	<div class="page-header" style="text-align: center">
 			 <h2>Transfer money list</h2>
	</div>
	<a href="#top" class="btn btn-primary">Back on top</a>
	<br/>
		<table class="table table-bordered">
			<thead>
    			<tr class="active">
      				<th>ID</th>
      				<th>Merchant ID</th>
      				<th>Sent sum</th>
      				<th>Sent date</th>
      				<th>Status</th>
    			</tr>
  			</thead>
  			<tbody>
  			<%java.util.List<com.bionic.edu.transmoney.Transmoney> listT = transmoneyService.findAll();
			for(com.bionic.edu.transmoney.Transmoney t : listT) {%>
			<tr>
      			<td><%=t.getId()%></td>
      			<td><%=t.getMerchantId()%></td>
      			<td><%=t.getSumSent()%></td>
      			<td><%=t.getSentDate()%></td>
      			<td><%=t.getStatus()%></td>
    		</tr>
			<%}%>
			</tbody>
	</table>
	<br/>

	<a name="merch"></a>
	<div class="page-header" style="text-align: center">
 		<h2>Merchant's table</h2>
	</div>
	<a href="#top" class="btn btn-primary">Back on top</a>
	<br/>
		<table class="table table-bordered">
			<thead>
    			<tr class="active">
      				<th>Name</th>
      				<th>Bank</th>
      				<th>SWIFT</th>
      				<th>Account</th>
      				<th>Charge</th>
      				<th>Period</th>
      				<th>Minimum sum</th>
      				<th>Need to send</th>
      				<th>Sent</th>
      				<th>Last sent date</th>
    			</tr>
  			</thead>
			<tbody>
			<%java.util.List<com.bionic.edu.merchant.Merchant> listM = merchantService.findAll();
			for(com.bionic.edu.merchant.Merchant m : listM) {%>
			<tr>
      			<td><%=m.getName()%></td>
      			<td><%=m.getBankName()%></td>
      			<td><%=m.getSwift()%></td>
      			<td><%=m.getAccount()%></td>
      			<td><%=m.getCharge()%></td>
      			<td><%=m.getPeriod()%></td>
      			<td><%=m.getMinSum()%></td>
      			<td><%=m.getNeedToSend()%></td>
      			<td><%=m.getSent()%></td>
      			<td><%=m.getLastSent()%></td>
    		</tr>
			<%}%>
			<%}catch(Exception e){%>
				<div class="alert alert-danger">Oooops, some errors%></div>
			<%}%>
		
			<tbody>
	</table>
	<div class="alert alert-success">Successfully!</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="bootstrap_script.js"></script>
</body>
</html>