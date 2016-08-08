'use strict';
productApp.controller('ProductController',function($scope,ProductDetailsService)
{
    $scope.name = 'chetan';
    $scope.getProductDetails = function(){
        console.log('====>>> From Controller: ');
        ProductDetailsService.getProductDetails()
        .then(
            function(products) {
                console.log("products:"+products);
                $scope.products = products;
            },
            function(errResponse){
                console.error('Controller : Error while fetching Products');
            }
        );
        }
    $scope.addProduct = function(product){
       console.log('====>>> From Controller: addProduct->> '+product);
       ProductDetailsService.addProduct({productId: product.productId, productName:product.productName})
       .then(
           function(message) {
               console.log("message:"+message);
               $scope.message = message;
           },
           function(errResponse){
               console.error('Controller : Error while fetching Products');
           }
       );
       }
    });