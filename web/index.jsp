<%--
  Created by IntelliJ IDEA.
  User: superuser
  Date: 18.01.2017
  Time: 23:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="utf-8">
  <title>Java Servlet JSON</title>
  <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>

  <!-- bootstrap just to have good looking page -->
  <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

  <!-- we code these -->
  <script src="js/myfunctions.js"></script>

</head>

<body>

<h1 style="text-align:center">Java Servlet Send & Receive JSON<br></h1>

<!-- article inputs -->
<div class="article" style="margin:10px;">
  <div class="input-prepend">
    <span class="add-on">Title</span>
    <input class="span4" id="title" name="title" type="text" placeholder="Article Title...">
  </div>
  <br/>
  <div class="input-prepend">
    <span class="add-on">URL</span>
    <input class="span4" id="url" name="url" type="text" placeholder="http://...">
  </div>
  <br/>
  <div class="input-prepend">
    <span class="add-on">Categories</span>
    <input class="span2" id="categories" name="categories" type="text" placeholder="category1;category2;...">
  </div>
  <br/>
  <div class="input-prepend">
    <span class="add-on">Tags</span>
    <input class="span2" id="tags" name="tags" type="text" placeholder="tag1;tag2;...">
  </div>
  <p>
    <button class="btn btn-primary" type="button" onclick="sendAjax()">Add</button>
  </p>
</div>

<!-- display all articles -->
<div style="width:700px;padding:20px;">
  <h5 style="text-align:center"><i style="color:#ccc"><small>Articles</small></i></h5>

  <table id="added-articles" class="table">
    <tr>
      <th>Title</th>
      <th>Categories</th>
      <th>Tags</th>
    </tr>
  </table>
</div>
</body>
</html>
