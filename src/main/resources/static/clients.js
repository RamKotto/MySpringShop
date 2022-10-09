angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/app';

    $scope.loadClients = function () {
        $http.get(contextPath + '/client/all')
            .then(function (response) {
                $scope.clientList = response.data;
            });
    };

    $scope.changeScore = function (clientId, delta){
        $http({
            url: contextPath + '/client/change_score',
            method: 'GET',
            params: {
                clientId: clientId,
                delta: delta
            }
        }).then(function (response){
            $scope.loadClients();
        });
    };

    $scope.loadClients();

});
