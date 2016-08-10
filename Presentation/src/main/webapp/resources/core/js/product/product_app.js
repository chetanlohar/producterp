var productApp = angular.module('productApp',['ngRoute']);
productApp.config(function($httpProvider,$routeProvider) {
    //Enable cross domain calls
    $httpProvider.defaults.useXDomain = true;
    $routeProvider.when('/viewProduct',{
        templateUrl: '/resources/core/html/product/product.html',
        controller: 'ProductController'
    }),
    $routeProvider.when('/addProduct',{
            templateUrl: '/resources/core/html/product/addProduct.html',
            controller: 'ProductController'
    }),
    $routeProvider.when('/updateProduct',{
            templateUrl: '/resources/core/html/product/updateProduct.html',
            controller: 'ProductController'
    })
});