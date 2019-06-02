<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Leezhenhao
  Date: 2019/06/01
  Time: 21:33:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>在线问答</title>

    <link href="https://cdn.bootcss.com/twitter-bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">


</head>
<body>


<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <h1 class="text-center">
                在 线 问 答
            </h1>
            <h3 class="text-center">
                <a href="${pageContext.request.contextPath}/questions/add">我要提问</a>
            </h3>
            <table class="table table-bordered table-hover">
                <thead style="font-size: 18px">
                <tr>
                    <th>
                        序号
                    </th>
                    <th>
                        问题
                    </th>
                    <th>
                        回答次数
                    </th>
                    <th>
                        最后修改
                    </th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${pageInfo.list}" var="questions" varStatus="vs">
                    <tr ${vs.index % 2 == 0 ? 'class="warning"':'class="success"'}>
                        <td>
                            ${vs.index + 1}
                        </td>
                        <td>
                            <a href="${pageContext.request.contextPath}/questions/toAddAnswer/${questions.id}">
                                <span style="${questions.answerCount==0?'color: red':''};font-size: 15px"> ${questions.title}</span>
                            </a>
                        </td>
                        <td>
                            ${questions.answerCount}
                        </td>
                        <td>
                            <fmt:formatDate value="${questions.lastModified}" pattern="yyyy-MM-dd HH:mm:ss"/>
                        </td>
                    </tr>
                </c:forEach>


                </tbody>
            </table>
            <ul class="pagination">

                <c:if test="${pageInfo.page>1}">
                    <li>
                        <a href="javascript:;" onclick="page(1)">首页</a>
                    </li>
                    <li>
                        <a href="javascript:;" onclick="page(${pageInfo.page - 1})">上一页</a>
                    </li>
                </c:if>

                <c:if test="${pageInfo.page < pageInfo.pages}">
                    <li>
                        <a href="javascript:;" onclick="page(${pageInfo.page + 1})">下一页</a>
                    </li>
                    <li>
                        <a href="javascript:;" onclick="page(${pageInfo.pages})">尾页</a>
                    </li>
                </c:if>
            </ul>
        </div>

        <script>

            function page(page){
                window.location.href="${pageContext.request.contextPath}/questions/list?page="+page;
            }
        </script>
        <span>
            当前第 ${pageInfo.page} 页 / 共 ${pageInfo.pages} 页 (共 ${pageInfo.count} 条)
        </span>

        <div style="color: red;font-size: 18px;text-align: center" >
            <span>${questAddMsg}${AnsAddMsg}</span>
        </div>

    </div>
</div>


</body>
</html>
