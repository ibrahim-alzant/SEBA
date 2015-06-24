ElBaileLatino.controller('PartnerSearchController', function ($scope, $http) {

    $http({
        method: 'GET',
        url: "/language/all",
    }).success(function (data) {
        $scope.languages = data;
    });
    $scope.name = document.getElementById("userName").value;
    $scope.student = null;

    $http({
        method: 'GET',
        url: "/student/all/",
    }).success(function (data) {
        $scope.students = data;
        angular.forEach($scope.students, function (student) {
            if (student.userName == $scope.name) {
                $scope.student = student;
            }
        })
    });
    $scope.selectedStudents = function(){
        var temp =[];
        angular.copy($scope.students, temp);
        return temp;
    };



});
