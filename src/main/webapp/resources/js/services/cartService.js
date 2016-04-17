'use strict';
app.factory('cartService',['$http','config', function($http,config) {
	
	  return {
    	remove: function(scope, cartDetail) { 
    			var res = $http.post(config.apiUrl+'removecartitem', cartDetail);
    			res.success(function(data, status, headers, config) {
    				  console.log("Success", data);
    				  var newCartDetails = new Array();
    				  angular.forEach(scope.cart.cartDetail, function(cd){
    					  if(cartDetail.productId != cd.productId){
    						  newCartDetails.push(cd);
    					  }
    				  });
    				  scope.cart.cartDetails = newCartDetails;
    				  
  					
    			});
    			res.error(function(data, status, headers, config) {
    				 console.log(data);
    				 scope.saveStatus = "!Oops  failed";
    			});	
    			
    			},
    	 getCart: function(lId){
				var promise  = $http.get(config.apiUrl+'getcart',{params: {emailId: lId}}).
                then(function  (response) {
                    return response.data;
                });
				return promise ;
    		 
    	 	},
    createOrder: function(cart) { 
    	var orderDetails = new Array();
    	var totalAmount = 0.0;
    	angular.forEach(cart.cartDetails, function(cartDetail){
    		var orderDetail = new Object();
    		orderDetail.productId = cartDetail.productId;
    		orderDetail.quantity = cartDetail.quantity;
    		totalAmount = totalAmount + cartDetail.productPrice;
    		orderDetails.push(orderDetail);
    	});
    	var order = new Object();
    	var d = new Date();
    	order.emailId= cart.emailId;
    	order.orderNumber = d.getTime();
    	order.totalAmount= totalAmount;
    	order.orderDetails = orderDetails;
    	order.status = "InProgress";
    	
    			var res = $http.post(config.apiUrl+'createorder', order);
    			res.success(function(data, status, headers, config) {
    				  console.log("Success", data);
  					
    			});
    			res.error(function(data, status, headers, config) {
    				 console.log(data);
    			});	
    			
    		},
   
    };
 
}]);







