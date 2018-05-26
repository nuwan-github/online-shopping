<div class="container">

	<!-- breadcrum -->
	<div class="row">

		<div class="col-xs-12">

			<ol class="breadcrumb">

				<li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
				<li class="breadcrumb-item"><a
					href="${contextRoot}/show/all/product">Product</a></li>
				<li class="breadcrumb-item" class="active">${product.name}</li>
			</ol>

		</div>

	</div>

	<div class="row">

		<!-- display the product image -->
		<div class="col-xs-12 col-sm-4">

			<div class="thumbnail">

				<img src="${images}/${product.code }.jpg" class="img-thumbnail" />
			</div>

		</div>

		<!-- 	display the product description -->
		<div class="col-xs-12 col-sm-8">
			<h3>${product.name }</h3>
			<hr />

			<p>${product.description}</p>

			<h4>
				Price: <strong>&#8377; ${product.unitprice } /-</strong>
			</h4>
			<hr />



			<c:choose>

				<c:when test="${product.quantity <1}">

					<h6>
						Qty Availble: <span class="text-danger">Out of Stock</span>
					</h6>

				</c:when>
				<c:otherwise>
					<h6>Qty. Availble: ${product.quantity}</h6>
				</c:otherwise>
			</c:choose>

			<c:choose>

				<c:when test="${product.quantity <1}">

				
					<a href="javascript:void(0)" class="btn btn-success disabled">
						<strike><span class="glyphicon glyphicon-shopping-cart"></span>Add
							To Cart</strike>
					</a>

				</c:when>
				<c:otherwise>
					

					<a href="${contextRoot}/cart/add/${product.id}/product"
						class="btn btn-success"> <strike><span
						class="glyphicon glyphicon-shopping-cart"></span>Add To Cart</strike>
					</a>


				</c:otherwise>
			</c:choose>

			<a href="${contextRoot}/show/all/products" class="btn btn-primary">
				Back</a>

		</div>
	</div>


</div>
"


