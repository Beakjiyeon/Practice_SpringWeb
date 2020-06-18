<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="../includes/header.jsp"%>


<div class="row">
  <div class="col-lg-12">
    <h1 class="page-header">게시물 조회</h1>
  </div>
  <!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
  <div class="col-lg-12">
    <div class="panel panel-default">

      <div class="panel-heading">Board Read Page</div>  
      <!-- /.panel-heading -->
      <div class="panel-body">

<!-- 게시물 작성 양식 -->

          
          <div class="form-group">
          <label>Bno</label> 
          <input class="form-control" name='bno' 
                 value='<c:out value="${board.bno}"/>' readonly="readonly">
                 <!-- controller에서 board란 이름으로 model을 넘겨줬었음. -->
        </div>
          <!-- name 속성과 BoardVO 속성 이름이 같아야함!!!! -->
          <div class="form-group">
          <label>Title</label> <input class="form-control" name='title'
            value='<c:out value="${board.title}"/>' readonly="readonly">
        </div>

        <div class="form-group">
          <label>Text area</label>
          <textarea class="form-control" rows="3" name='content'
            readonly="readonly"><c:out value="${board.content}" /></textarea>
        </div>

        <div class="form-group">
          <label>Writer</label> <input class="form-control" name='writer'
            value='<c:out value="${board.writer}"/>' readonly="readonly">
        </div>  
            
        <!-- 수정하기 위한 버튼 -->    
        <button data-oper='modify' class="btn btn-default"> 
        <a href="/board/modify?bno=<c:out value="${board.bno}"/>"> Modify</a>
        </button>

        <!-- 목록으로 돌아가기 위한 버튼 -->
        <button data-oper='list' class="btn btn-info"> 
        <a href="/board/list">List</a>
        </button>
     

      </div>
      <!--  end panel-body -->

    </div>
    <!--  end panel-body -->
  </div>
  <!-- end panel -->
</div>
<!-- /.row -->
<%@include file="../includes/footer.jsp"%>
