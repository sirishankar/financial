<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<s:url id="imagesRoot" value="/web/images"/>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
   		<meta http-equiv="X-UA-Compatible" content="IE=8" >
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate"/>
		<sj:head jqueryui="true" />

		<script type="text/javascript" src="<s:url value="/web/js/jquery.tools.1.2.5.min.js"/>"></script>      
        <script type="text/javascript" src="<s:url value="/web/js/jquery.tools.1.2.5.expose.js"/>"></script>

		<title><tiles:insertAttribute name="title" ignore="true" /></title>
		
		<link rel="stylesheet" type="text/css" href="<s:url value="/web/css/styles.css"/>">
		<link rel="shortcut icon" href="<s:url value="/web/images/favicon.ico"/>" />
    </head>
    <body>
		<div id="sessionInvalid"></div>
    	<div id="wrapper">
			<tiles:insertAttribute name="header" />			
		  	<div id="mainContent">	 
	 		  	<div id="mainContentColumn">
	 		  		<s:actionerror cssClass="errorMessage"/>
	          		<tiles:insertAttribute name="body" />
	          	</div>       
          	</div>
		  	<div id="nav" >
				<tiles:insertAttribute name="menu" />
          	</div>          
          	<tiles:insertAttribute name="footer" />
		</div>

    </body>
</html>