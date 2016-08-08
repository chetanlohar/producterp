'use strict';
productApp.factory('ProductDetailsService',['$http', '$q',function($http,$q){

    var REST_SERVICE_URI = 'http://localhost:9090/product/get'

    return{
        getProductDetails:function(productId){
            console.log('From Service: '+productId);
            var deferred = $q.defer();
            $http.get(REST_SERVICE_URI)
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