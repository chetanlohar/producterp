'use strict';
productApp.factory('ProductDetailsService',['$http', '$q','$log',function($http,$q,$log){

    var REST_SERVICE_URI = configOptions.baseUrl; //'http://localhost:7777/product/get'
    return{
        getProductDetails:function(){
            var deferred = $q.defer();
            $http.get(REST_SERVICE_URI+'/product/get')
                .then(
                function (response) {
                    deferred.resolve(response.data);
                },
                function(errResponse){
                    $log.error('Error while fetching Products');
                    deferred.reject(errResponse);
                }
            );
            return deferred.promise;
        },
        addProduct:function(product){
            var deferred = $q.defer();
            $log.info("prodName: "+product.productName)
            $http.post(REST_SERVICE_URI+'/product/add',product)
                .then(
                function (response) {
                    $log.info("response: " + response)
                    deferred.resolve(response);
                },
                function(errResponse){
                    $log.error('Service: Error while fetching Products');
                    deferred.reject(errResponse);
                }
            );
            return deferred.promise;
        },
        fetchProductDetails:function(productId){
            var deferred = $q.defer();
            $http.get(REST_SERVICE_URI+'/product/get/'+productId)
                .then(
                function (response) {
                    $log.info("response productName: " + response.data)
                    deferred.resolve(response.data);
                },
                function(errResponse){
                    $log.error('Service: Error while fetching Product');
                    deferred.reject(errResponse);
                }
            );
            return deferred.promise;
        },
        updateProduct:function(product){
            var deferred = $q.defer();
            $http.post(REST_SERVICE_URI+'/product/update',product)
                .then(
                function (response) {
                    deferred.resolve(response);
                },
                function(errResponse){
                    $log.error('Service: Error while fetching Products');
                    deferred.reject(errResponse);
                }
            );
            return deferred.promise;
        }
    };
}]);