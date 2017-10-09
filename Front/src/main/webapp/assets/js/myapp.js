$(function() {
	switch (menu) {
	case 'About':
		$('#about').addClass('active');
		break;
	case 'Contactus':
		$('#contactus').addClass('active');
		break;
	case 'All Products':
		$('#product').addClass('active');
		break;
	case 'admin product':
		$('#adminProduct').addClass('active');
		break;
	case 'Login':
		$('#login').addClass('active');
		break;
	case 'Regester':
		$('#regester').addClass('active');
		break;
	case 'User Cart':
		$('#userCart').addClass('active');
		break;
	default:
		if (menu == "Home")
			break;
		$('#product').addClass('active');
		$('#a_' + menu).addClass('active');
		break;

	}

	var token = $('meta[name="_csrf"]').attr('content');
	var header = $('meta[name="_csrf_header"]').attr('content');
	if (token.length > 0 && header.length > 0) {
		$(document).ajaxSend(function(e, xhr, options) {
			xhr.setRequestHeader(header, token);
		});
	}

	var $table = $('#productListTable');
	if ($table.length) {
		// console.log('inside the table');
		var jsonUrl = '';
		if (window.category_id == '') {

			jsonUrl = window.contextRoot + '/json/data/all/product';
		} else {
			jsonUrl = window.contextRoot + '/json/data/category/'
					+ window.category_id + '/product';
		}
		$table
				.DataTable({
					lengthMenu : [ [ 5, 8, 12, -1 ], [ '5', '8', '12', 'ALL' ] ],
					pageLength : 5,
					ajax : {
						url : jsonUrl,
						dataSrc : ''
					},

					columns : [
							{
								data : 'pCode',
								mRender : function(data, type, row) {
									return '<img src="' + window.contextRoot
											+ '/resources/images/' + data
											+ '.jpg" class="dataTableImg"/>'
								}
							},
							{
								data : 'pName'
							},
							{
								data : 'pBrand'
							},
							{
								data : 'pPrice',
								mRender : function(data, type, row) {
									return '&#8377; ' + data;
								}
							},
							{
								data : 'pQat',
								mRender : function(data, type, row) {

									if (data < 1) {
										return '<span style="color:red">Out of stock!</span>';
									}

									return data;

								}
							},

							{
								data : 'pId',
								bShortable : false,
								mRender : function(data, type, row) {
									var str = '';
									str += '<a href="'
											+ window.contextRoot
											+ '/show/'
											+ data
											+ '/product" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span></a>  &#160;';
									if (row.pQat < 1) {
										str += '<a href="javascript:void(0)" class="btn btn-success disabled"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
									} else {
										str += '<a href="'
												+ window.contextRoot
												+ '/cart/add/'
												+ data
												+ '/product" class="btn btn-primary"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
									}

									return str;
								}
							} ]

				});
	}

	var $alert = $('.alert');

	if ($alert.length) {

		setTimeout(function() {
			$alert.fadeOut('slow');
		}, 3000)
	}

	var $adminProductTable = $('#adminProductTable');
	if ($adminProductTable.length) {
		// console.log('inside the table');
		var jsonUrl = window.contextRoot + '/json/data/madmin/all/product';

		$adminProductTable
				.DataTable({
					lengthMenu : [ [ 10, 20, 30, -1 ],
							[ '10', '20', '30', 'ALL' ] ],
					pageLength : 10,
					ajax : {
						url : jsonUrl,
						dataSrc : ''
					},

					columns : [

							{
								data : 'pId'
							},
							{
								data : 'pCode',
								mRender : function(data, type, row) {
									return '<img src="' + window.contextRoot
											+ '/resources/images/' + data
											+ '.jpg" class="adminImage"/>'
								}
							},
							{
								data : 'pName'
							},
							{
								data : 'pBrand'
							},

							{
								data : 'pQat',
								mRender : function(data, type, row) {

									if (data < 1) {
										return '<span style="color:red">Out of stock!</span>';
									}

									return data;

								}
							},

							{
								data : 'pPrice',
								mRender : function(data, type, row) {
									return '&#8377; ' + data;
								}
							},

							{
								data : 'is_active',
								bSortable : false,
								mRender : function(data, type, row) {

									var str = '';

									str += '<label class="switch">';
									if (data) {
										str += '<input type="checkbox"  checked="checked" value="'
												+ row.pId + '"/>';

									} else {
										str += '<input type="checkbox"   value="'
												+ row.pId + '"/>';
									}
									str += '<div class="slider"></div></label>';

									return str;

								}

							},
							{

								data : 'pId',
								bSortable : false,
								mRender : function(data, type, row) {
									var str = '';

									str += '<a href="'
											+ window.contextRoot
											+ '/admin/'
											+ data
											+ '/product" class="btn btn-warning">';
									str += '<span class="glyphicon glyphicon-pencil"></span></a>';
									return str;

								}

							} ],

					initComplete : function() {
						var api = this.api();
						api
								.$('.switch input[type="checkbox"]')
								.on(
										'change',
										function() {

											var checkbox = $(this);
											var checked = checkbox
													.prop('checked');
											var dMsg = (checked) ? 'You want to activate the product?'
													: 'You want to deactivate the product?';
											var value = checkbox.prop('value');
											bootbox
													.confirm({

														size : 'medium',
														title : 'Product Activation & Deactivation',
														message : dMsg,
														callback : function(
																confirmed) {
															if (confirmed) {
																console
																		.log(value);

																var activationUrl = window.contextRoot
																		+ '/admin/product/'
																		+ value
																		+ '/activation';
																$
																		.post(
																				activationUrl,
																				function(
																						data) {
																					bootbox
																							.alert({
																								size : 'medium',
																								title : 'Information',
																								message : data
																							});

																				});

															} else {

																checkbox
																		.prop(
																				'checked',
																				!checked);

															}
														}

													});
										});
					}

				});
	}

	// validation form

	var $categoryForm = $('#categoryForm');

	if ($categoryForm.length) {

		$categoryForm.validate({

			rules : {
				cName : {
					required : true,
					minlength : 2
				},

				cDesc : {
					required : true
				}
			},

			messages : {

				cName : {
					required : 'Please enter category name!',
					minlength : 'The category name should be not less then 2!!'
				},

				cDesc : {
					required : 'Please enter product description!!'
				}
			},
			errorElement : 'em',
			errorPlacement : function(error, element) {
				error.addClass('help-block');
				error.insertAfter(element);
			}

		});
	}

	var $loginForm = $('#loginForm');

	if ($loginForm.length) {

		$loginForm.validate({

			rules : {
				username : {
					required : true,
					email : true
				},

				password : {
					required : true
				}
			},

			messages : {
				username : {
					required : 'Please enter username !',
					email : 'please enter valid email address!'
				},
				password : {
					required : 'Please enter password !!'
				}
			},
			errorElement : 'em',
			errorPlacement : function(error, element) {
				error.addClass('help-block');
				error.insertAfter(element);
			}
		});
	}

	$('button[name="refreshCart"]').click(
			function() {
				var cartlineId = $(this).attr('value');
				var countElement = $('#count_' + cartlineId);
				var originalCount = countElement.attr('value');
				var currentCount = countElement.val();

				if (currentCount !== originalCount) {
					if (currentCount < 1 || currentCount > 3) {
						countElement.val(originalCount);
						bootbox.alert({
							size : 'medium',
							title : 'Error',
							message : 'Product count should be between 1 and 3'
						});
					} else {
						var updateUrl = window.contextRoot + '/cart/'
								+ cartlineId + '/update?pCount='
								+ currentCount;
						window.location.href = updateUrl;
					}
				}

			});

});