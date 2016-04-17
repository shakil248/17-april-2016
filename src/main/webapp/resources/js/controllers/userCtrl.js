'use strict';
app.controller('userCtrl', function($scope,userService,sessionService, loginService){
	
	$scope.emailId = sessionService.get('emailId');
	$scope.errorMessage="";
	
	if(null!=$scope.emailId && $scope.emailId!=''){
		userService.getUser($scope.emailId).then(function(user) {
			$scope.user= user;
	    });
	}
	
    $scope.createUser=function(user){
    		userService.createUser(user,$scope);
    		$scope.errorMessage="";
    	
	};
	
	 $scope.getStates=function(){
		   userService.getStates($scope);
	};
	
	$scope.logout=function(){
		loginService.logout();
	};
	
	$scope.getStates();
	
	
	
	$scope.clearUser = function(user){
		$scope.user=null;
		 userService.clearImage();
		 $scope.errorMessage="";
	};
	
	$scope.isLogged = function(){
		return loginService.isLogged();
	};
});
