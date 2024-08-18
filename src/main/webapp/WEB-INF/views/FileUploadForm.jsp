<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>File Upload Example</title>
</head>
<body>
    <h2>File Upload Example</h2>
    <form action="uploadForm" method="post" enctype="multipart/form-data">
        Select file: <input type="file" name="file" />
        <br/><br/>
        <input type="submit" value="Upload" />
    </form>
</body>
</html>
