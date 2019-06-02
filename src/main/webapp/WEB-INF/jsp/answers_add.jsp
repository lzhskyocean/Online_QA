<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Leezhenhao
  Date: 2019/06/01
  Time: 23:51:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>问题回答页面</title>

    <link href="https://cdn.bootcss.com/twitter-bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<br/>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <h1 class="text-center">
                我 要 回 答 问 题
            </h1>
            <form action="${pageContext.request.contextPath}/answers/add" method="POST" class="form-horizontal" role="form">
                <input type="hidden" name="qId" value="${questions.id}"/>
                <input type="hidden" name="answerCount" value="${questions.answerCount}"/>
                <div class="form-group">
                    <label for="title" class="col-sm-4 control-label" style="font-size: 18px">问题:</label>
                    <div class="col-sm-5">
                        <input type="text" readonly value="${questions.title}" class="form-control"
                               style="background-color:#99FF99;font-family: 仿宋;font-size: 18px;" id="title"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="detailDesc" class="col-sm-4 control-label" style="font-size: 18px">问题描述:</label>
                    <div class="col-sm-5">
                        <input type="text" readonly value="${questions.detailDesc}" class="form-control"
                               style="background-color:#99FF99;font-family: 仿宋;font-size: 18px;" id="detailDesc"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="ansContent" class="col-sm-4 control-label" style="font-size: 18px">网友回答:</label>
                    <div class="col-sm-5">

                        <c:choose>

                            <c:when test="${questions.answerCount>0}">

                                <c:forEach items="${answersList}" var="answer" varStatus="vs">

                                    <span aria-readonly="true"
                                          style="display: table;background-color: #99FF99;font-family: 仿宋;font-size: 18px;"
                                          class="form-control" id="ansContent">
                                       <fmt:formatDate value="${answer.ansDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
                                            <br/>
                                        ${answer.ansContent}
                                    </span>

                                </c:forEach>

                            </c:when>

                            <c:otherwise>
                                <h4 class="text-center" style="color: red">
                                    暂无网友回答!
                                </h4>
                            </c:otherwise>

                        </c:choose>


                    </div>
                </div>

                <div class="form-group">
                    <label for="newAnsContent" class="col-sm-4 control-label" style="font-size: 18px">我来回答:</label>
                    <div class="col-sm-5">
                        <textarea required name="ansContent" class="form-control" id="newAnsContent"></textarea>

                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-offset-5 col-sm-10">
                        <button type="submit" class="btn btn-default">提交答案</button>
                        <button type="button" onclick="location.href='${pageContext.request.contextPath}/questions/list'" class="btn btn-default">返回首页</button>
                    </div>
                </div>
                <div style="color: red;font-size: 18px;text-align: center" >
                    <span>${AnsAddMsg}</span>
                </div>
            </form>
        </div>
    </div>
</div>


</body>
</html>
