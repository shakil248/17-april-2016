'use strict';
app.factory('homeService',['$http','sessionService','config', function($http,sessionService,config) {
    return {
    	getProductByCat: function(pcId,scope) { 
    		
    		var promise  = $http.get(config.apiUrl+'getproductbycat',{params: {productCatId: pcId}}).
            then(function  (response) {
                return response.data;
            });
			return promise ;
			},

		addToCart: function(product){
			
			var cartDetails = new Array();
			var cartDetail = new Object();
			cartDetail.productId = product.productId;
			cartDetail.productName = product.productName;
			cartDetail.productPrice = product.productPrice;
			cartDetail.quantity = product.quantity;
			cartDetail.sku = product.sku;
			cartDetails.push(cartDetail);
			
			
			var cart = new Object();
			cart.cartDetails = cartDetails;
			cart.emailId = sessionService.get('emailId');
			
			
			var res = $http.post(config.apiUrl+'addtocart', cart);
			res.success(function(data, status, headers, config) {
				  console.log("Success", data);
					
			});
			res.error(function(data, status, headers, config) {
				 console.log(data);
			});	
			},
    	
    };
}]);







