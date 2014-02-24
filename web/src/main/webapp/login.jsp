<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/style.css">

    <title>Login - MagazinOF</title>
</head>
<body onload='document.f.j_username.focus();' class="mf-special_page">
<div class="mf-top">
    <div class="mf-gradient"></div>
    <div class="mf-white"></div>
    <div class="mf-shadow"></div>
</div>
<div class="mf-content">
    <h1>MagazinoF | Login</h1>

    <div class="mf-background"></div>

    <div class="mf-wrapper">
        <div class="mf-box">
            <div class="mf-header mf-grey">
                <img src="images/lock.png" alt="X" width="16" height="16">

                <h3>Authorization</h3>
            </div>
            <form name='f' action='j_spring_security_check' method='POST'>
                <div class="mf-content mf-no-padding">
                    <div class="mf-section mf-l100">
                        <label>Login</label>

                        <div><input type='text' name='j_username' value='' class="required"></div>
                    </div>
                    <div class="mf-section mf-l100">
                        <label>Password</label>

                        <div><input type='password' name='j_password' type="password" class="required"></div>
                    </div>
                </div>
                <div class="mf-actions">
                    <div class="mf-actions-left" style="margin-top: 8px;">
                        <%--<label>
                            <input name="autologin" type="checkbox" class="hidden"/>
                            <span class="mf-checkbox">
				                <span class="mf-mark mf-checkbox-hover">
					                <img src="images/checkboxes/empty.png">
                                </span>
                            </span>
                            Remember me
                        </label>--%>
                    </div>
                    <div class="mf-actions-right"><input type="submit" value="Login" name="Login" class="mf-normal"/></div>
                </div>
            </form>
        </div>
        <div class="shadow"></div>
    </div>
</div>
</body>
</html>