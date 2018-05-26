$(function() {

	// solving the active menu problem

	switch (menu) {

	case 'About':
		$('#about').addClass('active');
		break;

	case 'Contact':
		$('#contact').addClass('active');
		break;

	case 'All_Products':

		$('#listProducts').addClass('active');
		break;
		
	case 'Manage Product':

		$('#manageProduct').addClass('active');
		break;

	default:
		if (menu == "Home")
			break;
		$('#listProducts').addClass('active');
		$('#a_').addClass('active');
		break;
	}

	// code for jquery datatable

	/*
	 * 
	 * 
	 * //create a dataset
	 * 
	 * var products = [
	 * 
	 * ['1','ABC'], ['2','DEF'], ['3','CFG'], ['4','HJI'], ['5','SWE'],
	 * ['6','KJH']
	 *  ];
	 * 
	 * 
	 * 
	 */

	var $table = $('#productListTable');
	// execute thebelow code only where have this table

	if ($table.length) {
		/* console.log("Inside the table") */

		var jsonUrl = '';
		if (window.categoryId == '') {
			jsonUrl = window.contextRoot + '/json/data/all/products'
		} else {
			jsonUrl = window.contextRoot + '/json/data/category/'
					+ window.categoryId + '/products';
		}

		$table
				.DataTable({
					lengthMenu : [ [ 3, 5, 10, -1 ],
							[ '3 Records', '5 Records', '10 Records', 'All' ] ],
					pageLength : 5,
					/* data:products */

					ajax : {
						url : jsonUrl,
						dataSrc : ''
					},

					columns : [
							{
								data : 'code',
								mRender : function(data, type, row) {
									return '<img src="' + window.contextRoot
											+ '/resources/images/' + data
											+ '.jpg" class="dataTableImg"/>';
								}
							},
							{
								data : 'name'

							},
							{
								data : 'brand'

							},
							{
								data : 'unitprice',
								mRender : function(data, type, row) {
									return 'Rs ' + data
								}

							},
							{
								data : 'quantity',
								mRender : function(data, type, row) {

									if (data < 1) {
										return '<span  class="text-danger">Out of Stock!</span>';
									}
									return data;

								}
							},
							{
								data : 'id',
								bSortable : false,
								mRender : function(data, type, row) {
									var str = '';
									str += '<a href="'
											+ window.contextRoot
											+ '/show/'
											+ data
											+ '/product" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span></a> &#160;';

									if (row.quantity < 1) {

										str += '<a href="javascript.void(0)" class="btn btn-success disabled"><span class="glyphicon glyphicon-shopping-cart"></span></a>';

									} else {
										str += '<a href="'
												+ window.contextRoot
												+ '/cart/add/'
												+ data
												+ '/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span></a>';

									}

									return str;
								}

							},
							{
								data : 'id',
								bSortable : false,
								mRender : function(data, type, row) {
									var str = '';
									str += '<a href="'
											+ window.contextRoot
											+ '/manage/'
											+ data
											+ '/varient" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span>Varient</a>';
									return str;
								}
							}

					]
				});
		
		
	}
	

	//dismissing the alert after 3 seconds

	var $alert = $('.alert');
	
	if($alert.length){
		setTimeout(function(){
			$alert.fadeOut('slow');
		},3000)
	}
	
	//--------------------------------------

	
	//---------------------------------------
	// data table for admin
	//---------------------------------------
	
	var $adminProductsTable = $('#adminProductsTable');
	// execute thebelow code only where have this table

	if ($adminProductsTable.length) {
		

		var jsonUrl = window.contextRoot + '/json/data/admin/all/products';
		
		

		$adminProductsTable
				.DataTable({
					lengthMenu : [ [ 10, 30, 50, -1 ],
							[ '10 Records', '30 Records', '50 Records', 'All' ] ],
					pageLength : 30,
					

					ajax : {
						url : jsonUrl,
						dataSrc : ''
					},

					columns : [
						{
							data: 'id'
						},
							{
								data : 'code',
								mRender : function(data, type, row) {
									return '<img class="dataTableImg" src="' + window.contextRoot
											+ '/resources/images/' + data
											+ '.jpg" class="adminProductsTable"/>';
								}
							},
							{
								data : 'name'

							},
							{
								data : 'brand'

							},
							
							{
								data : 'quantity',
								mRender : function(data, type, row) {

									if (data < 1) {
										return '<span  class="text-danger">Out of Stock!</span>';
									}
									return data;

								}
							},
							
							{
								data : 'unitprice',
								mRender : function(data, type, row) {
									return 'Rs ' + data
								}

							},
							
							{
								data : 'active',
								bSortable : false,
								mRender : function(data,type,row) {
									var str = '';
									
									str += '<label class="switch">';
									
									if(data){
									
										str += '<input type="checkbox" checked="checked" value="'+row.id+'" />';
									}
									else{
										str += '<input type="checkbox" value="'+row.id+'" />';
									}
								
								str += '<div class="slider"></div></label>';
							
								return str;
								}

							},
							{
								data:'id',
								bSortable: false,
								mRender: function(data,type,row){
									var str ='';
									str +='<a href="'+window.contextRoot+'/manage/'+data+'/product" class="btn btn-warning">';
										
									str +='<span class="glyphicon glyphicon-pencil"></span></a>'; 
											
									
									
									return str;
								}
							}
							
					],
					
					initComplete: function(){
						
						var api=this.api();
						
						api.$('.switch input[type="checkbox"]').on('change',function(){
							
							var checkbox = $(this);
							var checked = checkbox.prop('checked');
							var dMsg = (checked)? 'You want to activate product?' :
													'You want to deactivate the product?';
							var value = checkbox.prop('value');
							
							bootbox.confirm({
								size : 'medium',
								title : 'Product Activate & Deactivate',
								message: dMsg,
								callback: function(confirmed){
									if(confirmed){
										console.log(value);
										
										//activation
										
										var activationUrl =window.contextRoot + '/manage/product/' +value +'/activation';
										$.post(activationUrl, function(data){
											bootbox.alert({
												size: 'medium',
												title : 'Information',
												message: data
											});
										});
										
										
									}
									else{
										checkbox.prop('checked',!checked);
									}
								}
							});
							
						});
						
					}
					
					
				});
		
		
	}
	
	//----------------------------------------
/*	jquery validation for category*/
	
	var $categoryForm = $('#categoryForm');
	
	if($categoryForm.length){
		$categoryForm.validate({
			rules  : {
				
				name:{
					required:true,
					minlength: 2
				},
			
				description:{
					required:true
				}
			},
			
			messages : {
				
				name : {
					required: 'Please add the category name!',
					minlength: 'The category name should not me less than 2!!'
				},
				description : {
					
					required : 'Please add the description for this category'
				}
				
				
			},
			errorElement: 'em',
			errorPlacement: function(error,element){
				error.addClass('help-block');
				error.insertAfter(element);
			}
			
			
		});
		
	}
	
//-----------------------------------
	
	$('.selectpicker').selectpicker({
		  style: 'btn-info',
		  size: 4
		});
//-----------------------------------
	
	var $adminVarientTable = $('#adminVarientTable');
	// execute thebelow code only where have this table

	if ($adminVarientTable.length) {
		

		var jsonUrl = window.contextRoot + '/json/data/admin/all/varient';
		
		$adminVarientTable
				.DataTable({
					lengthMenu : [ [ 10, 30, 50, -1 ],
							[ '10 Records', '30 Records', '50 Records', 'All' ] ],
					pageLength : 30,
					

					ajax : {
						url : jsonUrl,
						dataSrc : ''
					},

					columns : [
						{
							data: 'id'
						},
							
						{
								data : 'productId'

						},
						{
								data : 'size'

						},
							
						{
								data : 'color'
								
						},
						{
								data : 'madeBy'
								/*bSortable : false,
								mRender : function(data,type,row) {
									
									if (data<= 2) {
										return '<span class="text-warning" class="font-weight-bold"  >Demonstrator</span>';
									}
									else if(data<= 5){
										return '<span  class="text-primary" class="font-weight-bold" >Lecturer</span>';
									}
									else{
										return '<span class="text-success" class="font-weight-bold"  >Senior Lecturer</span>';
									}
									
									return data;
								
								}*/

							},
							{
								
								data : 'active',
								bSortable : false,
								mRender : function(data,type,row) {
									var str = '';
									
									str += '<label class="switch">';
									
									if(data){
									
										str += '<input type="checkbox" checked="checked" value="'+row.id+'" />';
									}
									else{
										str += '<input type="checkbox" value="'+row.id+'" />';
									}
								
								str += '<div class="slider"></div></label>';
							
								return str;
								}
								
							}
							
					],
					
						initComplete: function(){
						
						var api=this.api();
						
						api.$('.switch input[type="checkbox"]').on('change',function(){
							
							var checkbox = $(this);
							var checked = checkbox.prop('checked');
							var dMsg = (checked)? 'You want to activate Varient?' :
													'You want to deactivate the Varient?';
							var value = checkbox.prop('value');
							
							bootbox.confirm({
								size : 'medium',
								title : 'Varient Activate & Deactivate',
								message: dMsg,
								callback: function(confirmed){
									if(confirmed){
										console.log(value);
										
										//activation
										
										var activationUrl =window.contextRoot + '/manage/varient/' +value +'/activation';
										$.post(activationUrl, function(data){
											bootbox.alert({
												size: 'medium',
												title : 'Information',
												message: data
											});
										});
										
										
									}
									else{
										checkbox.prop('checked',!checked);
									}
								}
							});
							
						});
						
					}
					
					
				});
		
		
	}
	
	
	
//---------------------------------	
});

