<%@ page
  import="java.io.File"
%>

<%
if(image == null) {
	File picDir = new File(path);
	String pics[] = picDir.list();
	String name_cd = myBean.getNameCd();
	
	for(int i=0; i<pics.length; i++) {
	  if(pics[i].substring(pics[i].length()-3).equals("jpg") && (
		  name_cd == null ||
		  pics[i].substring(0,name_cd.length()).equals(name_cd)
		)) { 
	  %>
		<a href="?gid=<vplants:GID />&image=<%= pics[i] %>">
		<img src="thumbs/<%= pics[i] %>" alt="<%= pics[i] %>"/>
		</a>
	  <%
	  }
	}
} else {
	out.println("<img src='"+image+"'/>");
	%><a href="?gid=<vplants:GID />">Back to Gallery Index</a><%
}
%>
