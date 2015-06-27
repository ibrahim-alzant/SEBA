ElBaileLatino.controller('SearchController', function ($scope, $http) {

    $http({
        method: 'GET',
        url: "/language/all",
    }).success(function (data) {
        $scope.languages = data;
    });
});
