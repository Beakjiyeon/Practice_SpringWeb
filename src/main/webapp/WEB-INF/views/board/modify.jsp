<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="../includes/header.jsp"%>


<div class="row">
  <div class="col-lg-12">
    <h1 class="page-header">게시물 수정</h1>
  </div>
  <!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
  <div class="col-lg-12">
    <div class="panel panel-default">

      <div class="panel-heading">게시물 수정</div>
      <!-- /.panel-heading -->
      <div class="panel-body">

<!-- controller의 postMapping(/modify)가 실행된다. -->
<form role="form" action="/board/modify" method="post">
      
        <input type='hidden' name='pageNum' value='<c:out value="${cri.pageNum }"/>'>
        <input type='hidden' name='amount' value='<c:out value="${cri.amount }"/>'>
	    <input type='hidden' name='type' value='<c:out value="${cri.type }"/>'>
		<input type='hidden' name='keyword' value='<c:out value="${cri.keyword }"/>'>
      
 
<div class="form-group">
  <label>Bno</label> 
  <input class="form-control" name='bno' 
     value='<c:out value="${board.bno }"/>' readonly="readonly">
</div>

<div class="form-group">
  <label>Title</label> 
  <input class="form-control" name='title' 
    value='<c:out value="${board.title }"/>' >
</div>

<div class="form-group">
  <label>Text area</label>
  <textarea class="form-control" rows="3" name='content' ><c:out value="${board.content}"/></textarea>
</div>

<div class="form-group">
  <label>Writer</label> 
  <input class="form-control" name='writer'
    value='<c:out value="${board.writer}"/>' readonly="readonly">            
</div>

<div class="form-group">
  <label>RegDate</label> 
  <input class="form-control" name='regDate'
    value='<fmt:formatDate pattern = "yyyy/MM/dd" value = "${board.regdate}" />'  readonly="readonly">            
</div>

<div class="form-group">
  <label>Update Date</label> 
  <input class="form-control" name='updateDate'
    value='<fmt:formatDate pattern = "yyyy/MM/dd" value = "${board.updateDate}" />'  readonly="readonly">            
</div>

          
  <button type="submit" data-oper='modify' class="btn btn-default">Modify</button>
  <!-- controller의 postMapping(/modify)가 실행된다. -->
  
  <button type="submit" data-oper='remove' class="btn btn-danger">Remove</button>
  <button type="submit" data-oper='list' class="btn btn-info">List</button>
</form>

      </div>
      <!--  end panel-body -->

    </div>
    <!--  end panel-body -->
  </div>
  <!-- end panel -->
</div>
<!-- /.row -->

<script type="text/javascript">
$(document).ready(function() {

// remove 버튼이 눌러지면, action 속성 값을 /board/remove로 바꾸어야함
	  var formObj = $("form"); // form태그 객체를 담아둠.

	  // 태그 이름이 button 인 것을 모두 찾음, 그것이 클릭 되면
	  $('button').on("click", function(e){
	    
	    e.preventDefault(); 
	    
	    // this는 현재 클릭이 일어난 버튼을 의미함. 그 중, data-oper라는 속성값이 있는지 찾아보는 것.
	    var operation = $(this).data("oper");
	    
	    console.log(operation);
	    
	    if(operation === 'remove'){ //data-oper 속성값이 remove인 버튼
	      formObj.attr("action", "/board/remove"); //폼 태그의 action속성에 /board/list 요청 보냄
	    
	    }else if(operation === 'list'){
	      //move to list
	      //list는 서버로 데이터 보낼 것이 없음. 그냥 페이지 이동 뿐.
	      self.location = "/board/list"      
	      return;
	    }
	    
	    formObj.submit(); //서버에 <Input>에 담긴 데이터를 전달하면서 요청하는 것
	  });

});
</script>
  

<%@include file="../includes/footer.jsp"%>
