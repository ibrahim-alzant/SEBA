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

    $http({
        method: 'GET',
        url: "/student/all/",
    }).success(function (data) {
        $scope.students = data;
        angular.forEach($scope.students, function (student) {
            if (student.userName == $scope.name) {
                $scope.student = student;
                if(student.gender.id==1){
                    $scope.gender = 2;
                }else{
                    $scope.gender = 1;
                }
            }
        })
    });
    $scope.selectedStudents = function(){
        var temp =[];
        //TODO don't put user into search results
        angular.forEach($scope.students, function(student){
           if(student.gender.id==$scope.gender){
               temp.push(student);
           }
        });
        return temp;
    };



});
