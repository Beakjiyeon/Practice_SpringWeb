<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<%@ include file="../includes/header.jsp" %>
        <!-- Begin Page Content -->
        <div class="container-fluid">

          <!-- Page Heading -->
          <h1 class="h3 mb-2 text-gray-800">Tables</h1>
          <p class="mb-4">DataTables is a third party plugin that is used to generate the demo table below. For more information about DataTables, please visit the <a target="_blank" href="https://datatables.net">official DataTables documentation</a>.</p>

          <!-- DataTales Example -->
          <div class="card shadow mb-4">
            <div class="card-header py-3">
              <div class="panel-heading">Board List Page <button id='regBtn' type="button" class="btn btn-xs pullright" style=“float:right”>Register New Board</button> </div>
            </div>
            <div class="card-body">
              <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                  <thead>
                    <tr>
                      <th>#번호</th> 
                      <th>제목</th> 
                      <th>작성자</th> 
                      <th>작성일</th> 
                      <th>수정일</th>
                    </tr>
                  </thead>
                  <tbody>
                  <c:forEach items="${list}" var="board"> 
                     <tr> 
                        <td><c:out value="${board.bno}" /></td> 
                        <td>
                        	<a href='/board/get?bno=<c:out value="${board.bno}"/>'> 
                        	<c:out value="${board.title}"/></a>
                        </td>
                        <td><c:out value="${board.writer}" /></td> 
                        <td><fmt:formatDate pattern="yyyy-MM-dd" value ="${board.regdate}" />
                        </td> <td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.updateDate}" /></td>
               </tr> 
            </c:forEach>
                  </tbody>
                </table>
                
	<!-- Modal 추가 --> 
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog“ aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog"> 
		<div class="modal-content"> 
		<div class="modal-header"> 
			<h4 class="modal-title" id="myModalLabel">Modal title</h4> 
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		</div> 
		
		<div class="modal-body">처리가 완료되었습니다.</div> 
		<div class="modal-footer"> 
			<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			<button type="button" class="btn btn-primary">Save changes</button> 
		</div>
		</div> <!-- /.modal-content -->
		</div> <!-- /.modal-dialog -->
	</div> <!-- /.modal -->                
                
              </div>
            </div>
          </div>

        </div>
        <!-- /.container-fluid -->
        
        <script type="text/javascript">
        //javascript 문법
        $(document).ready(function() {
        	var result = '<c:out value="${result}"/>' //controller에서 result에 게시글 번호 보내줬었음.
        	
        	checkModal(result); //함수 호출
        	
        	history.replaceState({}, null, null); // 다음 번에는 모달 창을 띄울 필요없다고 표시함

        	//함수 정의
        	function checkModal(result) 
        	{ 
        		if (result === '' || history.state) { 
        			return;
				}
        		
        		if(parseInt(result) > 0) { //result 값이 있으면
        			//class이름이 modal-body인 태그를 선택해 안의 내용을 바꾼다.
        			$(".modal-body").html("게시글 "+parseInt(result)+" 번이 등록되었습니다.");
        		}
        		
        		// id가 myModal인 모달창을 보여줘라!
        		$("#myModal").modal("show");
        	}
        	
        	 $("#regBtn").on("click", function() { 
        		 self.location = "/board/register";
             });
        	
        });
        
       
        
        
        </script>

<%@ include file="../includes/footer.jsp" %>