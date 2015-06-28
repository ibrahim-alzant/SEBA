ElBaileLatino.controller('PartnerSearchController', function ($scope, $http) {
    $scope.gender = 1;

    $http({
        method: 'GET',
        url: "/language/all",
    }).success(function (data) {
        $scope.languages = data;
    });
    $scope.name = document.getElementById("userName").value;
    $scope.student = null;
    $scope.students = [];
    $scope.age = "18,45";

    $http({
        method: 'GET',
        url: "/student/all/",
    }).success(function (data) {
        $scope.students = data;
        angular.forEach($scope.students, function (student) {
            var ageDifMs = Date.now() - new Date(student.dateOfBirth).getTime();
            var ageDate = new Date(ageDifMs); // miliseconds from epoch
            student.age = Math.abs(ageDate.getUTCFullYear() - 1970);
            if (student.userName == $scope.name) {
                $scope.student = student;
                if (student.gender.id == 1) {
                    $scope.gender = 2;
                } else {
                    $scope.gender = 1;
                }
            }
        })
    });
    $scope.selectedStudents = function () {
        var temp = [];
        //TODO don't put user into search results
        angular.forEach($scope.students, function (student) {
            if ((student.gender.id == $scope.gender) &&
                ( student.age >= parseFloat($scope.age.split(',')[0]))&&
                ( student.age <=  parseFloat($scope.age.split(',')[1]))) {
                temp.push(student);
            }
        });
        return temp;
    };


});
