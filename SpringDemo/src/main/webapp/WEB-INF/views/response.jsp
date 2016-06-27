<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<html>
<head>
	<title>response</title>
</head>
<body>
<h1>
	
</h1>

<P> ${callback}
({
    "responsMessage" :
    '${responsMessage}'
    ,
    "responsData" :
    '${responseData}'
})
 </P>
</body>
</html>
