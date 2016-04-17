'use strict';
app.controller('loginCtrl', function($scope,$location, loginService,sessionService){
	
	$scope.emailId=sessionService.get('emailId');
	$scope.password;
	$scope.loginStats="";
	
	
    $scope.login=function(){
	   loginService.login($scope);
	};

	  
});








