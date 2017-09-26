 $(function() {
	switch(menu) {
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
	default:
		 if(menu=="Home") break;
		$('#product').addClass('active');
		$('#a_'+menu).addClass('active');
		break;

	}
	


	var $table = $('#productListTable');
		if ($table.length) {
			// console.log('inside the table');
			var jsonUrl = '';
			if (window.category_id == '') {

				jsonUrl = window.contextRoot + '/json/data/all/product';
			} else {
				jsonUrl = window.contextRoot + '/json/data/category/'+ window.category_id + '/product';
			}
			$table.DataTable({
						lengthMenu: [
								[ 5, 8, 12, -1],[ '5', '8', '12','ALL' ] ],
						pageLength: 5,
						ajax: {
							url: jsonUrl,
							dataSrc: ''
					 	},
					 	
						columns: [
								{
									data : 'pCode',
									mRender : function(data, type, row) {
										return '<img src="' + window.contextRoot
												+ '/resources/images/' + data
												+ '.jpg" class="dataTableImg"/>'
									}
								},
								{
									data: 'pName'
								},
								{
									data: 'pBrand'
								},
								{
									data: 'pPrice',
								        mRender : function(data, type, row) {
										return '&#8377; ' + data;
									}
								},
								{
									data: 'pQat',
								     mRender: function(data, type, row) {
								    	 
											if(data < 1){
												return '<span style="color:red">Out of stock!</span>';
											}
											
												return data;
											
											
										}
								},

								{
									data: 'pId',
									bShortable : false,
									mRender: function(data, type, row) {
										var str='';
										str += '<a href="'+ window.contextRoot+ '/show/'+ data+ '/product" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span></a>  &#160;';
										if(row.pQat < 1){
											str += '<a href="javascript:void(0)" class="btn btn-success disabled"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
										}
										else{
											str += '<a href="'+ window.contextRoot+ '/cart/add/'+ data+ '/product" class="btn btn-primary"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
										}
										
										return str;
									}
								}
								]

					});
		}
	

});

