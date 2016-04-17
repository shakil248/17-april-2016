'use strict';
app.factory('loginService', function($location,$http,sessionService,config) {
	
    return {
        login: function(scope){ 
		
		var res = $http.get(config.apiUrl+'dologin', {params : {'emailId':scope.emailId, 'password':scope.password}});
		res.success(function(data, status, headers, config) {
			  console.log("Success", data);
			  if(data==true){
				  sessionService.set('emailId',scope.emailId);
				  $location.path('/home');  
			  }else{
				  	scope.loginStats="Login failed";
			  }
		});
		res.error(function(data, status, headers, config) {
			 console.log("Failure");
		});	
		},
		
		logout: function(){
				if(sessionService.get('emailId')){
					sessionService.destroy('emailId');
					$location.path('/login');
				}
		},
		isLogged: function() {
			if(sessionService.get('emailId')) {return true;} else {return false;}
		},
	
		
		
    };
});