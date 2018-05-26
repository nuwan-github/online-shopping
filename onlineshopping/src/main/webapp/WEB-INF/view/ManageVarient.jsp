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
					<h4>Varient Management</h4>
				</div>
				<div class="card-body">


					<sf:form class="form" role="form" autocomplete="off"
						modelAttribute="varient" action="${contextRoot}/manage/varient"
						method="POST" enctype="multipart/form-data">


						<div class="form-group row">
							<label class="col-lg-3 col-form-label form-control-label">Select
								Product</label>
							<div class="col-lg-9">
								<sf:select class="form-control" id="productId" path="productId"
									items="${products}" itemLabel="name" itemValue="id">
									<option value="1">Category One</option>
									<option value="2">CAtegory Two</option>
								</sf:select>
							</div>
						</div>

						<div class="form-group row">
							<label class="col-lg-3 col-form-label form-control-label">Enter
								Size</label>
							<div class="col-lg-9">
								<sf:input type="text" class="form-control" id="size" path="size"
									placeholder="Size Of Product"></sf:input>
								
								<sf:errors path="size" cssClass="help-block" element="em" />
							</div>
							
						</div>
						<div class="form-group row">
							<label class="col-lg-3 col-form-label form-control-label">Select
								Manufactured Country</label>
							<div class="col-lg-9">
								<div class="form-group">
								<c:if test="${varient.id ==0 }">
									<sf:select path="madeBy"
										class="form-control" id="madeBy">
										<option value="" selected="selected">Select Country</option>
										<option value="srilanka">Srilanka</option>
										<option value="Indian">Indian</option>
										<option value="China">China</option>
										<option value="Japan">Japan</option>
										<option value="Dubai">Dubai</option>
									</sf:select>
									</c:if>
									<c:if test="${varient.id !=0 }">
									<sf:input type="text" class="form-control" id="madeBy" path="madeBy"
									placeholder="Size Of Product"></sf:input>
									</c:if>
								</div>


								<sf:errors path="madeBy" cssClass="help-block" element="em" />

							</div>
						</div>
						<div class="form-group row">
							<label class="col-lg-3 col-form-label form-control-label">Select
								Color</label>
							<div class="col-lg-9">
								<div class="form-group">
								<c:if test="${varient.id ==0 }">
									<sf:select path="color"
										class="form-control" id="color">
										<option value="" selected="selected">Select Color</option>
										<option value="Red">Red</option>
										<option value="White">White</option>
										<option value="Gray">Gray</option>
										<option value="Silver">Silver</option>
										<option value="Black">Black</option>
									</sf:select>
									</c:if>
									<c:if test="${varient.id !=0 }">
									<sf:input type="text" class="form-control" id="color" path="color"
									placeholder="Size Of Product"></sf:input>
									</c:if>
								</div>
								<sf:errors path="color" cssClass="help-block" element="em" />

							</div>
						</div>

		
							
						
						<div class="form-group row">
						<c:if test="${varient.id ==0 }">
							<div class="btnMove">
								<input type="Submit" value="Submit"
									class="btn btn-success btn-sm float-left" />
							</div>
						</c:if>
						<c:if test="${varient.id !=0 }">
							<div class="col-lg-9">
							<a href="${contextRoot}/show/all/products/" class="btn btn-primary">View All Products</a>
							</div>
						</c:if>
						
							<!-- Hidden fields of Product -->
							<sf:hidden path="id" />
							<sf:hidden path="productId" />
							<sf:hidden path="size" />
							<sf:hidden path="color" />
							<sf:hidden path="madeBy" />
							<sf:hidden path="active" />

						</div>
					</sf:form>

				</div>

				<div class="card-footer text-muted success-color white-text">
					<p class="mb-0"></p>
				</div>
			</div>
		</div>
	</div>
</div>

<br/>
	<div class="row">
		

		<div class="col-md-8 mx-auto">

			<!-- products table for admin -->
			<table id="adminVarientTable"
				class="table table-striped table-bordered">
				<thead>
					<tr>
						<th>Id</th>
						<th>Product</th>
						<th>Size</th>
						<th>Manufactured Country</th>
						<th>Color</th>
						<th>Delete</th>
					</tr>

				</thead>
				<tbody>
				
				</tbody>
				<tfoot>
					<tr>
						<th>Id</th>
						<th>Product</th>
						<th>Size</th>
						<th>Manufactured Country</th>
						<th>Color</th>
						<th>Delete</th>
						
					</tr>

				</tfoot>



			</table>

		</div>


	</div>