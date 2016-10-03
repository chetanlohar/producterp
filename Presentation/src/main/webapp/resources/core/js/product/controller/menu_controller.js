'use strict';
productApp.controller('MenuController',function($scope)
{
    $scope.state = false;

        $scope.toggleState = function() {
            $scope.state = !$scope.state;
        };
});