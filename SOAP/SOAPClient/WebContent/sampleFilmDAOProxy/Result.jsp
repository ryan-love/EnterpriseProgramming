<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleFilmDAOProxyid" scope="session" class="core.FilmDAOProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleFilmDAOProxyid.setEndpoint(request.getParameter("endpoint"));
%>

<%
String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

if(methodID != -1) methodID = Integer.parseInt(method);
boolean gotMethod = false;

try {
switch (methodID){ 
case 2:
        gotMethod = true;
        java.lang.String getEndpoint2mtemp = sampleFilmDAOProxyid.getEndpoint();
if(getEndpoint2mtemp == null){
%>
<%=getEndpoint2mtemp %>
<%
}else{
        String tempResultreturnp3 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getEndpoint2mtemp));
        %>
        <%= tempResultreturnp3 %>
        <%
}
break;
case 5:
        gotMethod = true;
        String endpoint_0id=  request.getParameter("endpoint8");
            java.lang.String endpoint_0idTemp = null;
        if(!endpoint_0id.equals("")){
         endpoint_0idTemp  = endpoint_0id;
        }
        sampleFilmDAOProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        core.FilmDAO getFilmDAO10mtemp = sampleFilmDAOProxyid.getFilmDAO();
if(getFilmDAO10mtemp == null){
%>
<%=getFilmDAO10mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
</TABLE>
<%
}
break;
case 15:
        gotMethod = true;
        core.Film[] getAllFilms15mtemp = sampleFilmDAOProxyid.getAllFilms();
if(getAllFilms15mtemp == null){
%>
<%=getAllFilms15mtemp %>
<%
}else{
        String tempreturnp16 = null;
        if(getAllFilms15mtemp != null){
        java.util.List listreturnp16= java.util.Arrays.asList(getAllFilms15mtemp);
        tempreturnp16 = listreturnp16.toString();
        }
        %>
        <%=tempreturnp16%>
        <%
}
break;
case 18:
        gotMethod = true;
        String stars_2id=  request.getParameter("stars23");
            java.lang.String stars_2idTemp = null;
        if(!stars_2id.equals("")){
         stars_2idTemp  = stars_2id;
        }
        String review_3id=  request.getParameter("review25");
            java.lang.String review_3idTemp = null;
        if(!review_3id.equals("")){
         review_3idTemp  = review_3id;
        }
        String director_4id=  request.getParameter("director27");
            java.lang.String director_4idTemp = null;
        if(!director_4id.equals("")){
         director_4idTemp  = director_4id;
        }
        String year_5id=  request.getParameter("year29");
        int year_5idTemp  = Integer.parseInt(year_5id);
        String title_6id=  request.getParameter("title31");
            java.lang.String title_6idTemp = null;
        if(!title_6id.equals("")){
         title_6idTemp  = title_6id;
        }
        String id_7id=  request.getParameter("id33");
        int id_7idTemp  = Integer.parseInt(id_7id);
        %>
        <jsp:useBean id="core1Film_1id" scope="session" class="core.Film" />
        <%
        core1Film_1id.setStars(stars_2idTemp);
        core1Film_1id.setReview(review_3idTemp);
        core1Film_1id.setDirector(director_4idTemp);
        core1Film_1id.setYear(year_5idTemp);
        core1Film_1id.setTitle(title_6idTemp);
        core1Film_1id.setId(id_7idTemp);
        boolean insertFilm18mtemp = sampleFilmDAOProxyid.insertFilm(core1Film_1id);
        String tempResultreturnp19 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(insertFilm18mtemp));
        %>
        <%= tempResultreturnp19 %>
        <%
break;
case 35:
        gotMethod = true;
        String stars_9id=  request.getParameter("stars40");
            java.lang.String stars_9idTemp = null;
        if(!stars_9id.equals("")){
         stars_9idTemp  = stars_9id;
        }
        String review_10id=  request.getParameter("review42");
            java.lang.String review_10idTemp = null;
        if(!review_10id.equals("")){
         review_10idTemp  = review_10id;
        }
        String director_11id=  request.getParameter("director44");
            java.lang.String director_11idTemp = null;
        if(!director_11id.equals("")){
         director_11idTemp  = director_11id;
        }
        String year_12id=  request.getParameter("year46");
        int year_12idTemp  = Integer.parseInt(year_12id);
        String title_13id=  request.getParameter("title48");
            java.lang.String title_13idTemp = null;
        if(!title_13id.equals("")){
         title_13idTemp  = title_13id;
        }
        String id_14id=  request.getParameter("id50");
        int id_14idTemp  = Integer.parseInt(id_14id);
        %>
        <jsp:useBean id="core1Film_8id" scope="session" class="core.Film" />
        <%
        core1Film_8id.setStars(stars_9idTemp);
        core1Film_8id.setReview(review_10idTemp);
        core1Film_8id.setDirector(director_11idTemp);
        core1Film_8id.setYear(year_12idTemp);
        core1Film_8id.setTitle(title_13idTemp);
        core1Film_8id.setId(id_14idTemp);
        boolean deleteFilm35mtemp = sampleFilmDAOProxyid.deleteFilm(core1Film_8id);
        String tempResultreturnp36 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(deleteFilm35mtemp));
        %>
        <%= tempResultreturnp36 %>
        <%
break;
case 52:
        gotMethod = true;
        String stars_16id=  request.getParameter("stars57");
            java.lang.String stars_16idTemp = null;
        if(!stars_16id.equals("")){
         stars_16idTemp  = stars_16id;
        }
        String review_17id=  request.getParameter("review59");
            java.lang.String review_17idTemp = null;
        if(!review_17id.equals("")){
         review_17idTemp  = review_17id;
        }
        String director_18id=  request.getParameter("director61");
            java.lang.String director_18idTemp = null;
        if(!director_18id.equals("")){
         director_18idTemp  = director_18id;
        }
        String year_19id=  request.getParameter("year63");
        int year_19idTemp  = Integer.parseInt(year_19id);
        String title_20id=  request.getParameter("title65");
            java.lang.String title_20idTemp = null;
        if(!title_20id.equals("")){
         title_20idTemp  = title_20id;
        }
        String id_21id=  request.getParameter("id67");
        int id_21idTemp  = Integer.parseInt(id_21id);
        %>
        <jsp:useBean id="core1Film_15id" scope="session" class="core.Film" />
        <%
        core1Film_15id.setStars(stars_16idTemp);
        core1Film_15id.setReview(review_17idTemp);
        core1Film_15id.setDirector(director_18idTemp);
        core1Film_15id.setYear(year_19idTemp);
        core1Film_15id.setTitle(title_20idTemp);
        core1Film_15id.setId(id_21idTemp);
        boolean updateFilm52mtemp = sampleFilmDAOProxyid.updateFilm(core1Film_15id);
        String tempResultreturnp53 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(updateFilm52mtemp));
        %>
        <%= tempResultreturnp53 %>
        <%
break;
case 69:
        gotMethod = true;
        String title_22id=  request.getParameter("title72");
            java.lang.String title_22idTemp = null;
        if(!title_22id.equals("")){
         title_22idTemp  = title_22id;
        }
        core.Film[] searchFilms69mtemp = sampleFilmDAOProxyid.searchFilms(title_22idTemp);
if(searchFilms69mtemp == null){
%>
<%=searchFilms69mtemp %>
<%
}else{
        String tempreturnp70 = null;
        if(searchFilms69mtemp != null){
        java.util.List listreturnp70= java.util.Arrays.asList(searchFilms69mtemp);
        tempreturnp70 = listreturnp70.toString();
        }
        %>
        <%=tempreturnp70%>
        <%
}
break;
case 74:
        gotMethod = true;
        String id_23id=  request.getParameter("id89");
        int id_23idTemp  = Integer.parseInt(id_23id);
        core.Film getFilmByID74mtemp = sampleFilmDAOProxyid.getFilmByID(id_23idTemp);
if(getFilmByID74mtemp == null){
%>
<%=getFilmByID74mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">stars:</TD>
<TD>
<%
if(getFilmByID74mtemp != null){
java.lang.String typestars77 = getFilmByID74mtemp.getStars();
        String tempResultstars77 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typestars77));
        %>
        <%= tempResultstars77 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">review:</TD>
<TD>
<%
if(getFilmByID74mtemp != null){
java.lang.String typereview79 = getFilmByID74mtemp.getReview();
        String tempResultreview79 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typereview79));
        %>
        <%= tempResultreview79 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">director:</TD>
<TD>
<%
if(getFilmByID74mtemp != null){
java.lang.String typedirector81 = getFilmByID74mtemp.getDirector();
        String tempResultdirector81 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typedirector81));
        %>
        <%= tempResultdirector81 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">year:</TD>
<TD>
<%
if(getFilmByID74mtemp != null){
%>
<%=getFilmByID74mtemp.getYear()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">title:</TD>
<TD>
<%
if(getFilmByID74mtemp != null){
java.lang.String typetitle85 = getFilmByID74mtemp.getTitle();
        String tempResulttitle85 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typetitle85));
        %>
        <%= tempResulttitle85 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">id:</TD>
<TD>
<%
if(getFilmByID74mtemp != null){
%>
<%=getFilmByID74mtemp.getId()
%><%}%>
</TD>
</TABLE>
<%
}
break;
}
} catch (Exception e) { 
%>
Exception: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.toString()) %>
Message: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.getMessage()) %>
<%
return;
}
if(!gotMethod){
%>
result: N/A
<%
}
%>
</BODY>
</HTML>