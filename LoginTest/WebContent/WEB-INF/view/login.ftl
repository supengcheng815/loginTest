<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <div style="text-align:center;">
         <div style="color:red;">
        <#if error?exists>
            ${error}
        </#if>
        </div>
        <form action="LoginController_login.do">
            <p>
                              账户：<input type="text" name="username" />
            </p>
            <p>
                              密码：<input type="password" name="password" />
            </p>
            <p>
               <input type="submit" value="点击登录" />
            </p> 
        </form>
    </div>
</body>
</html>