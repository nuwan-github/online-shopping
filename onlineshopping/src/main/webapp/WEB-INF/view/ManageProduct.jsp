<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container">

	<div class="row">

		<c:if test="${not empty message}">

			<div class="col-md-12">

				<div class="alert alert-success alert-dismissible">
					<button type="button" class="close" data-dismiss="alert">&times;</button>
					${message}
				</div>
			</div>

		</c:if>
		<div class=" col-md-8 mx-auto">

			<div class="card text-center">
				<div class="card-header success-color white-text">
					<h4>Product Management</h4>
				</div>
				<div class="card-body">


					<sf:form class="form" role="form" autocomplete="off"
						modelAttribute="product" action="${contextRoot}/manage/products"
						method="POST" enctype="multipart/form-data">

						<div class="form-group row">
							<label class="col-lg-3 col-form-label form-control-label">Enter
								Product Name</label>
							<div class="col-lg-9">
								<sf:input type="text" class="form-control" id="name" path="name"
									placeholder="Product Name"></sf:input>
								<sf:errors path="name" cssClass="help-block" />

							</div>
						</div>
						<div class="form-group row">
							<label class="col-lg-3 col-form-label form-control-label">Enter
								Brand Name</label>
							<div class="col-lg-9">
								<sf:input type="text" class="form-control" id="brand"
									path="brand" placeholder="Brand Name"></sf:input>
								<sf:errors path="brand" cssClass="help-block" element="em" />

							</div>
						</div>
						<div class="form-group row">
							<label class="col-lg-3 col-form-label form-control-label">Enter
								Unit Price</label>
							<div class="col-lg-9">
								<sf:input type="number" class="form-control" id="unitprice"
									path="unitprice" placeholder="Unit Price"></sf:input>
								<sf:errors path="unitprice" cssClass="help-block" element="em" />

							</div>
						</div>

						<div class="form-group row">
							<label class="col-lg-3 col-form-label form-control-label">Product
								Description</label>
							<div class="col-lg-9">
								<sf:textarea class="form-control" id="description"
									path="description" placeholder="Unit Price"></sf:textarea>
								<sf:errors path="description" cssClass="help-block" element="em" />

							</div>
						</div>

						<div class="form-group row">
							<label class="col-lg-3 col-form-label form-control-label">Quantity
								Available</label>
							<div class="col-lg-9">
								<sf:input type="number" class="form-control" id="quantity"
									path="quantity" placeholder="Quantity Availble"></sf:input>

							</div>
						</div>
						<!-- file element for image file upload -->
						<div class="form-group row">
							<label class="col-lg-3 col-form-label form-control-label"
								for="file">Select an Image: </label>
							<div class="col-lg-9">
								<sf:input type="file" class="form-control" id="file" path="file"></sf:input>
								<sf:errors path="file" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group row">
							<label class="col-lg-3 col-form-label form-control-label">Select
								Category</label>
							<div class="col-lg-9">
								<sf:select class="form-control" id="categoryId"
									path="categoryId" items="${categories}" itemLabel="name"
									itemValue="id">
									<option value="1">Category One</option>
									<option value="2">CAtegory Two</option>
								</sf:select>
							</div>
						</div>
						<c:if test="${product.id ==0 }">
						<div class="text-left">
							<div class="text-right">
								
									<button type="button" data-toggle="modal" data-target="#myCategoryModel" class=	"btn btn-warning btn-sm float-right">Add Category</button>			
							</div>
							</br>
					
							</div>
							<br/>
						</c:if>

						<div class="form-group row">
							<div class="btnMove">
							<input type="Submit" value="Submit"
								class="btn btn-success btn-sm float-left" />
							</div>
							
							<!-- Hidden fields of Product -->
							<sf:hidden path="id" />
							<sf:hidden path="code" />
							<sf:hidden path="supplierId" />
							<sf:hidden path="active" />
							<sf:hidden path="purchases" />
							<sf:hidden path="views" />

						</div>
					</sf:form>

				</div>

				<div class="card-footer text-muted success-color white-text">
					<p class="mb-0"></p>
				</div>
			</div>
		</div>
	</div>
	<br/>
	<div class="row">
		

		<div class="col-md-8 mx-auto">

			<!-- products table for admin -->
			<table id="adminProductsTable"
				class="table table-striped table-bordered">
				<thead>
					<tr>
						<th>Id</th>
						<th>&#160</th>
						<th>Name</th>
						<th>Brand</th>
						<th>Quantity</th>
						<th>Unit Price</th>
						<th>Active</th>
						<th>Edit</th>
						
					</tr>

				</thead>
				<%-- <tbody>
					<tr>
						<td>4</td>
						<td><img class="adminDataTableImg"
							src="${contextRoot}/resources/images/PRDMNO123PQRX.jpg"
							alt="mackbook pro" /></td>
						<td>Mackbook Pro</td>
						<td>Apple</td>
						
						<td>3</td>
						<td>&#8377; 54000.00/-</td>
						<td>
							<!-- toggle switch -->
							 <label class="switch"> 
								 <input type="checkbox" checked="checked" value="4" />
									
									<div class="slider"></div>
							</label>
						</td>
						<td>
							<a href="${contextRoot}/manage/4/product" class="btn btn-warning"> 
								
								<span class="glyphicon glyphicon-pencil"> 
									
								</span>
							</a>
						</td>

					</tr>
					
					
					<tr>
						<td>4</td>
						<td><img class="adminDataTableImg"
							src="${contextRoot}/resources/images/PRDMNO123PQRX.jpg"
							alt="mackbook pro" /></td>
						<td>Mackbook Pro</td>

						<td>3</td>
						<td>&#8377; 54000.00/-</td>
						<td>
							<!-- toggle switch -->
							 <label class="switch"> 
								 <input type="checkbox" value="4" />
									
									<div class="slider"></div>
							</label>
						</td>
						<td>
							<a href="${contextRoot}/manage/4/product" class="btn btn-warning"> 
								
								<span class="glyphicon glyphicon-pencil"> 
									
								</span>
							</a>
						</td>

					</tr>

				</tbody> --%>
				<tfoot>
					<tr>
						<th>Id</th>
						<th>&#160; </th>
						<th>Name</th>
						<th>Brand</th>
						<th>Quantity</th>
						<th>Unit Price</th>
						<th>Active</th>
						<th>Edit</th>
						
					</tr>

				</tfoot>



			</table>

		</div>


	</div>

	<div class="row">
		<div class ="modal fade" id="myCategoryModel" role="dialog" tabindex="-1">
			
			<div class="modal-dialog" role="document">
				<div class="modal-content">
				<!-- Modal Dialog -->
					<div class="modal-header">
					
						<button type="button" class="close" data-dismiss="modal">
							<span>&times;</span>
						
						</button>
						<h4 class="modal-title ">Add New Category</h4>
					</div>
					<div class="modal-body">
					<!-- 	category form -->
					
					<sf:form id="categoryForm" modelAttribute="category" action="${contextRoot}/manage/category" method="POST" class="form-horizontal">
						<div class="form-group">
							<label for="category_name" class="control-label col-md-4">Category Name</label>
								<div class="col-md-8">
									
									<sf:input type="text" path="name" id="category_name" class="form-control"/>
								</div>
						</div>
								
								<div class="form-group">
							<label for="category_description" class="control-label col-md-4">Category Description</label>
								<div class="col-md-8">
									
									<sf:textarea cols=" " rows="5" path="description" id="category_description" class="form-control"/>
								</div>
								</div>
								
								<div class="form-group">
								<div class="col-md-offset-4 col-md-8">
										<input type="Submit" value="Add Category" class="btn btn-primary"/>
								</div>
								</div>
					
					</sf:form>
					
					</div>
				</div>
			
			</div>
		
		</div>
	
	
	</div>

</div>