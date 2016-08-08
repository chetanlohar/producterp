'use strict';
productApp.factory('ProductDetailsService',['$http', '$q',function($http,$q){

    var REST_SERVICE_URI = configOptions.baseUrl; //'http://localhost:7777/product/get'
    return{
        getProductDetails:function(productId){
            console.log('From Service: '+productId);
            var deferred = $q.defer();
            $http.get(REST_SERVICE_URI+"/product/get")
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
        }
    };
}]);