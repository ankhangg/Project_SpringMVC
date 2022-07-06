<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
    <script data-require="jquery@*" data-semver="2.0.3" src="http://code.jquery.com/jquery-2.0.3.min.js"></script>
    <title>Delete Item</title>
    <script data-require="bootstrap@*" data-semver="3.1.1" src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
    <link data-require="bootstrap-css@3.1.1" data-semver="3.1.1" rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/decorator_admin/deleteitem/deletecss.css" class="ace-main-stylesheet" id="main-ace-style" />
    <script src="script.js"></script>
</head>
<body>
    <div class="modal fade" id="confirm-delete" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                    <h4 class="modal-title" id="myModalLabel">Confirm Delete</h4>
                </div>
                <div class="modal-body">
                    <p>You are about to delete <b><i class="title"></i></b> record, this procedure is irreversible.</p>
                    <p>Do you want to proceed?</p>
                </div>
                 <form:form modelAttribute="deleteItemForm" method="POST" enctype="multipart/form-data" action="${pageContext.request.contextPath}/delete_item">
                <div class="modal-footer">
                     <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                    <button type="submit" class="btn btn-danger btn-ok">Delete</button>
                </div>
                     <div class="form-group">
    <input type="hidden" class="form-control" id="formGroupExampleInput2" placeholder="Input_ID" name="id" value="${deleteItemForm.id }">
  </div>
  <div class="form-group">
    <label for="formGroupExampleInput">Name Item: ${deleteItemForm.nameItem } </label>
    <input type="hidden" class="form-control" id="formGroupExampleInput" placeholder="Input Name_Item" name="nameItem" value="${deleteItemForm.nameItem }">
  </div>
  <div class="form-group">
    <label for="formGroupExampleInput2">Short Description: ${deleteItemForm.shortdescription }</label>
    <input type="hidden" class="form-control" id="formGroupExampleInput2" placeholder="Input Description_Item" name="shortdescription" value="${deleteItemForm.shortdescription }">
  </div>
   <div class="form-group">
    <label for="formGroupExampleInput2">Price: ${deleteItemForm.price }</label>
    <input type="hidden" class="form-control" id="formGroupExampleInput2" placeholder="Input_Price" name="price" value="${deleteItemForm.price }">
  </div>
     <div class="form-group">
    <label for="formGroupExampleInput2">Amount: ${deleteItemForm.amountItem }</label>
    <input type="hidden" class="form-control" id="formGroupExampleInput2" placeholder="Input_Price" name="amountItem" value="${deleteItemForm.amountItem }">
  </div>
   <div class="form-group">
    <label for="formGroupExampleInput2">Image</label>
  </div>
    <td><img src="${pageContext.request.contextPath}/itemImage?id=${deleteItemForm.id}" width="100"/></td>
     <div class="form-group">
  </div>
                </form:form>
            </div>
        </div>
    </div>
    <br />
    <button class="btn btn-default" data-record-id="54" data-record-title=" ${deleteItemForm.nameItem }" data-toggle="modal" data-target="#confirm-delete">
       Delete Name Item: ${deleteItemForm.nameItem }
    </button>
    <script>
        $('#confirm-delete').on('click', '.btn-ok', function(e) {
            var $modalDiv = $(e.delegateTarget);
            var id = $(this).data('recordId');
            // $.ajax({url: '/api/record/' + id, type: 'DELETE'})
            // $.post('/api/record/' + id).then()
            $modalDiv.addClass('loading');
            setTimeout(function() {
                $modalDiv.modal('hide').removeClass('loading');
            }, 1000)
        });
        $('#confirm-delete').on('show.bs.modal', function(e) {
            var data = $(e.relatedTarget).data();
            $('.title', this).text(data.recordTitle);
            $('.btn-ok', this).data('recordId', data.recordId);
        });
    </script>
    
    
</body>

</html>