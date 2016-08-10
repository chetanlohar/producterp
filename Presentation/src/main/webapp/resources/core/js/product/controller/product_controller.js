'use strict';
productApp.controller('ProductController',function($scope,$log,ProductDetailsService)
{
    $scope.getProductDetails = function(){
        $log.info('====>>> From Controller: ');
        ProductDetailsService.getProductDetails()
        .then(
            function(products) {
                $scope.products = products;
            },
            function(errResponse){
                $log.error('Controller : Error while fetching Products');
            }
        );
        };
    $scope.addProduct = function(product){
       $log.info('====>>> From Controller: addProduct->> '+product);
       ProductDetailsService.addProduct({productId: product.productId, productName:product.productName})
       .then(
           function(message) {
               $scope.message = message.data.message;
           },
           function(errResponse){
               $log.error('Controller : Error while fetching Products');
           }
       );
       };
    $scope.fetchProductDetails = function(productId){
        $log.info("productId: "+productId);
        ProductDetailsService.fetchProductDetails(productId)
        .then(
            function(product){
                $scope.productEntity = product;
            },
            function(errResponse){
                $log.error('Error while fetching the product');
            }
        )
    };
    $scope.updateProduct = function(product){
           $log.info('====>>> From Controller: addProduct->> '+product);
           ProductDetailsService.updateProduct({productId: product.productId, productName:product.productName})
           .then(
               function(message) {
                   $scope.message = message.data.message;
               },
               function(errResponse){
                   $log.error('Controller : Error while fetching Products');
               }
           );
           };
    });