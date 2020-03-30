function storeAppr(){
		var id = $(event.target).val();
		
		location.href="/EMPTY/admin/store/requestAppr?userId="+id;
	}