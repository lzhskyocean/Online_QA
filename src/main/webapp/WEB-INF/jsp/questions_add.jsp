<%--
  Created by IntelliJ IDEA.
  User: Leezhenhao
  Date: 2019/06/01
  Time: 22:33:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我要提问</title>
    <link href="https://cdn.bootcss.com/twitter-bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<br/>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <h1 class="text-center">
                我 要 提 问
            </h1>

            <h3 class="text-center">
                <a href="${pageContext.request.contextPath}/questions/list">返回首页</a>
            </h3>
            <form class="form-horizontal" role="form" action="${pageContext.request.contextPath}/questions/add" method="POST">
                <div class="form-group">
                    <label for="title" class="col-sm-4 control-label" style="font-size: 18px">问题:</label>
                    <div class="col-sm-5">
                        <input required name="title" class="form-control" id="title"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="detailDesc" class="col-sm-4 control-label" style="font-size: 18px">问题描述:</label>
                    <div class="col-sm-5">
                        <textarea required name="detailDesc" class="form-control" id="detailDesc"></textarea>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-offset-4 col-sm-5">
                        <button type="submit" class="btn btn-default">提交问题</button>
                    </div>
                </div>
            </form>

            <div style="text-align: center">
                <span>${addMsg}</span>
            </div>

        </div>
    </div>
</div>
</body>
</html>
