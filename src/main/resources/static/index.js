angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/app';

    $scope.contextPathTwo = 'http://localhost:8189/app'

    $scope.loadProducts = function () {
        $http.get(contextPath + '/products')
            .then(function (response) {
                console.log(response.data)
                $scope.productList = response.data;
            });
    };

    $scope.changePrice = function (productId, price) {
        $http({
            url: contextPath + '/products/change_price',
            method: 'GET',
            params: {
                id: productId,
                price: price
            }
        }).then(function (response) {
            $scope.loadProducts();
        });
    };

    $scope.createProduct = function () {
        console.log($scope.newProduct);
        $http.post(contextPath + '/products', $scope.newProduct)
            .then(function (response) {
                $scope.loadProducts()
            });
    };

    $scope.deleteProduct = function (productId) {
        $http.get(contextPath + '/products/delete/' + productId)
            .then(function (response) {
                $scope.loadProducts()
            });
    };

    $scope.loadProducts();

});
