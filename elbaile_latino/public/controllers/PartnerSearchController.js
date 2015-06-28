ElBaileLatino.controller('PartnerSearchController', function ($scope, $http) {


    geocoder = new google.maps.Geocoder();

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
    $scope.distance = "10";

    $http({
        method: 'GET',
        url: "/student/all/",
    }).success(function (data) {
        $scope.students = data;
        angular.forEach($scope.students, function (student) {
            if (student.userName == $scope.name) {
                $scope.student = student;
                augmentUser(student);
            }
        });
        angular.forEach($scope.students, function (student) {
            augmentStudent(student);
        })
    });
    $scope.selectedStudents = function () {
        var temp = [];
        //TODO don't put user into search results
        angular.forEach($scope.students, function (student) {
            if ((student.gender.id == $scope.gender) &&
                ( student.age >= parseFloat($scope.age.split(',')[0])) &&
                ( student.age <= parseFloat($scope.age.split(',')[1])) &&
                (
                    (!student.hasOwnProperty('distance')) ||
                    (
                        (student.hasOwnProperty('distance')) &&
                        ( parseFloat(student.distance) < parseFloat($scope.distance))
                    )
                )
            ) {
                temp.push(student);
            }
        });
        return temp;
    };
    function augmentUser(user) {
        if (user.gender.id == 1) {
            $scope.gender = 2;
        } else {
            $scope.gender = 1;
        }
        geocoder.geocode({'address': user.address}, function (results, status) {
            if (status == google.maps.GeocoderStatus.OK) {
                $scope.location = results[0].geometry.location;
            } else {
                $scope.location = new google.maps.LatLng(48.10424, 11.573210000000017);
            }
        });
    }

    function augmentStudent(student) {
        //counting age
        var ageDifMs = Date.now() - new Date(student.dateOfBirth).getTime();
        var ageDate = new Date(ageDifMs);
        student.age = Math.abs(ageDate.getUTCFullYear() - 1970);

        //counting distance from user address
        geocoder.geocode({'address': student.address}, function (results, status) {
            if (status == google.maps.GeocoderStatus.OK) {
                student.distance = distances($scope.location.lat(), $scope.location.lng(),
                    results[0].geometry.location.lat(), results[0].geometry.location.lng());
            } else {
                student.distance = 0;
            }
            var e = document.getElementById("age");
            var scope = angular.element(e).scope();
            scope.$digest();
        });

    }

    function deg2rad(val) {
        var pi = Math.PI;
        var de_ra = ((eval(val)) * (pi / 180));
        return de_ra;
    }

    function distances(lat1, lon1, lat2, lon2) {
        var R = 3963.189; // meters

        // Find the deltas
        delta_lon = deg2rad(lon2) - deg2rad(lon1);

        // Find the Great Circle distance
        miledistance = Math.acos(Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) *
                Math.cos(delta_lon)) * 3963.189;
        var kmdistance = (miledistance * 1.609344).toFixed(1);
        return kmdistance;
    }

});
