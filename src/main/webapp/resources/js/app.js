'use strict';
var app = angular.module('loginApp',['ngRoute']);
app.config(['$routeProvider', function($routeProvider) {
	  $routeProvider.when('/admin', {templateUrl:'resources/partials/admin.html', controller: 'adminCtrl'});
      $routeProvider.when('/login', {templateUrl:'resources/partials/login.html', controller: 'loginCtrl'});
      $routeProvider.when('/user', {templateUrl:'resources/partials/user.html', controller: 'userCtrl'});
      $routeProvider.when('/home', {templateUrl:'resources/partials/home.html', controller: 'homeCtrl'});
      $routeProvider.when('/cart', {templateUrl:'resources/partials/cart.html', controller: 'cartCtrl'});
	  $routeProvider.otherwise({redirectTo:'/login'});
}]);
	
app.constant('config', {
      apiUrl: "http://localhost:8080/petstore/"
});







