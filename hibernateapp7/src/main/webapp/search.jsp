<%@page import="com.sudha.Customer"%>
<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="org.hibernate.cfg.Configuration"%>

<%!Configuration cfg = null;
	SessionFactory sessionFactory = null;
	Session ses = null;
	Customer customer = null;%>

<%
try {
	String cid = request.getParameter("cid");
	cfg = new Configuration();
	cfg.configure("hibernate.cfg.xml");
	sessionFactory = cfg.buildSessionFactory();
	ses = sessionFactory.openSession();
	customer = (Customer) ses.get(Customer.class, cid);
	if (customer == null) {
%>
<jsp:forward page="notexisted.jsp" />
<%
} else {
request.setAttribute("customer", customer);
%>
<jsp:forward page="display.jsp" />
<%
}
} catch (Exception e) {
e.printStackTrace();
}
%>