'use strict';
productApp.factory('ProductDetailsService',['$http', '$q',function($http,$q){

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
                    console.error('Error while fetching Products');
                    deferred.reject(errResponse);
                }
            );
            return deferred.promise;
        },
        addProduct:function(product){
            var deferred = $q.defer();
            console.log("prod: "+product.productId+":"+product.productName)
            $http.post(REST_SERVICE_URI+'/product/add',product)
                .then(
                function (response) {
                    console.log("response: " + response)
                    deferred.resolve(response);
                },
                function(errResponse){
                    console.error('Service: Error while fetching Products');
                    deferred.reject(errResponse);
                }
            );
            return deferred.promise;
        }
    };
}]);