<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<body>
	<c:choose>
		<c:when test="${isUpdate}">
			<script type="text/javascript">
				alert('예약수정이 정상 처리되었습니다.');
				window.location = '/';
			</script>
		</c:when>
		<c:otherwise>
			<script type="text/javascript">
				alert('예약수정을 처리하지 못했습니다.');
				window.location = '/';
			</script>			
		</c:otherwise>
	</c:choose>
</body>
</html>