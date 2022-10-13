angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/app';

    $scope.loadProducts = function () {
        $http.get(contextPath + '/product/all')
            .then(function (response) {
                $scope.productList = response.data;
            });
    };

    $scope.changePrice = function (productId, price){
        $http({
            url: contextPath + '/product/change_price',
            method: 'GET',
            params: {
                productId: productId,
                price: price
            }
        }).then(function (response){
            $scope.loadProducts();
        });
    };

    $scope.loadProducts();

});
