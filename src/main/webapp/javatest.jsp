
<?xml version="1.0" encoding="ISO-8859-1"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
   "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
  <head>
    <title>DB Test</title>
  </head>
  <body>

  <h2>Results</h2>
  
<display:table name="javaTestList" cellspacing="0" cellpadding="0" requestURI=""
    defaultsort="1" id="javatests" pagesize="25" class="table" export="true">
    <display:column property="foo" escapeXml="true" sortable="true" title="Foo" style="width: 50%"/>
    <display:column property="bar" escapeXml="true" sortable="true" title="Bar" style="width: 50%"/>
</display:table>

<%--   <div id="javatests" class="javatests">
        <c:forEach items="${javaTestList}" var="javatest">
            ${javatest.foo} - ${javatest.bar} <br />
        </c:forEach>
   </div>--%>

  </body>
</html>
