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
                console.error('Error while fetching Users');
            }
        );
        }
    });