var productApp = angular.module('productApp',['ngRoute']);
productApp.config(function($httpProvider,$routeProvider) {
    //Enable cross domain calls
    $httpProvider.defaults.useXDomain = true;
    $routeProvider.when('/viewProduct',{
        templateUrl: '/resources/core/html/product.html',
        controller: 'ProductController'
    })
});