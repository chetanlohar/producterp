<!DOCTYPE html>
<html lang="en-US" ng-app="productApp">
<script src="/resources/core/js/config.js"></script>
<script src="/resources/core/js/common/angular.js"></script>
<script src="/resources/core/js/common/angular-resource.js"></script>
<script src="/resources/core/js/product/product_app.js"></script>
<script src="/resources/core/js/product/controller/product_controller.js"></script>
<script src="/resources/core/js/product/service/product_service.js"></script>
<head>
    <title>Bitwise</title>
</head>
<body>
    <h1>Product ERP</h1>
    <div ng-controller="ProductController">
        Product Id: <input type="text" ng-model="productId">
        <p><h3>{{productId}}</h3></p>
        <button type="button" ng-click="getProductDetails(productId)" value="Get Data">Get Data</button>
    </div>
</body>
</html>
