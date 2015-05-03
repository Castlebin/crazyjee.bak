<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<head>
	<title> 文件上传 </title>
</head>
<body>
<form method="post" action="upload"  enctype="multipart/form-data">
	文件名：<input type="text" id="name" name="name" /><br/>
	选择文件：<input type="file" id="file" name="file" /><br/>
	<input type="submit" value="上传" /><br/>
</form>
</body>
</html>