<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<c:redirect url="/base/menu/login/login.do" />

<%--

Redirect default requests to Welcome global ActionForward.
By using a redirect, the user-agent will change address to match the path of our Welcome ActionForward.

--%>
