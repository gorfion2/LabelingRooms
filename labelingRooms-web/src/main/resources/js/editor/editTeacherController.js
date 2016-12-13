/**
 * Created by Kamil on 2016-11-30.
 */
var editTeacherModule = angular.module(
    'EditTeacherModule', []);

editTeacherModule.controller('EditTeacherController', ['$scope', '$location', 'EditTeacherRepository', 'EditTeacherService', function ($scope, $location, EditTeacherRepository, EditTeacherService) {

    $scope.editAction = $location.path() === '/edytuj/pokoj';

    $scope.save = function () {
        EditTeacherRepository.saveTeacher($scope.teacher, function (status) {
            if(status.success===true){
                $location.path('/');
            }else{
                alert(status.message);
            }

        });
    }

    $scope.edit = function () {
        EditTeacherRepository.editTeacher($scope.teacher, function (status) {
            if(status.success===true){
                $location.path('/');
            }else{
                alert(status.message);
            }

        });
    }

    if ($scope.editAction && EditTeacherService.getTeacher() !== null) {
        $scope.teacher = EditTeacherService.getTeacher();
    } else {
        $scope.teacher = {} ;
    }

}]);

