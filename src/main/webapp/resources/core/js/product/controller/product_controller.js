'use strict';
productApp.controller('ProductController',function($scope,ProductDetailsService)
{
    $scope.name = 'chetan';
    $scope.getProductDetails = function(productId){
        console.log('From Controller: '+productId);
        ProductDetailsService.getProductDetails(productId)
        .then(
            function(d) {
                console.log("d:"+d);
            },
            function(errResponse){
                console.error('Error while fetching Users');
            }
        );
        }
    });