<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE>
<%String english = (String) session.getAttribute("english");%>
<%int total = (int) session.getAttribute("total");%>
<%int saveCount = (int)session.getAttribute("registCount"); %>


<html lang="ja">
<head>
  <meta charset="UTF-8">
  <title>Result</title>
</head>
<body>
  <p><%= saveCount %>件、登録しました</p>
  <p>登録された英単語は<%=english %>です。</p>
  <p>合計登録件数は<%=total %></p>

</body>
</html>