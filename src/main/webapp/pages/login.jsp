<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Login</title>
</head>

<body>

	<hr>
	<h1>Veuillez vous identifier</h1>
	<hr>

	<s:form action="login">
		<p><s:textfield name="contact.username" label="username"/></p>
		<p><s:password name="contact.password" label="password"/></p>
		<p><s:submit/></p>
	
	</s:form>
</body>

</html>