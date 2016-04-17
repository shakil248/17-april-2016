'use strict';
app.factory('urlService',['$http', function($http) {
    return {
    	getURL: function() { 
    		 $http.get('resources/connection.json').then(function (response) {
    			 console.log('b is ', response.data.baseURL);
    		     return response.data.baseURL;
    		      });	
    			},
    };
}]);







