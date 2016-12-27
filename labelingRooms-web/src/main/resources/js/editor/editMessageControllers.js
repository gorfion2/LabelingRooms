/**
 * Created by Kamil on 2016-12-12.
 */
var editMessageModule = angular.module(
    'EditMessageModule', []);

editMessageModule.controller('EditMessageController', ['$scope', '$location', 'EditMessageRepository', 'EditMessageService', function ($scope, $location, EditMessageRepository, EditMessageService) {

    $scope.editAction = $location.path() === '/edytuj/wiadomosc';
    $scope.roomRegex = '^[0-9]{1,3}$';

    $scope.save = function () {
        EditMessageRepository.saveMessage($scope.message, function (status) {
            if (status.success === true) {
                $location.path('/wiadomosci');
            } else {
                alert(status.message);
            }

        });
    };

    $scope.edit = function () {
        EditMessageRepository.editMessage($scope.message, function (status) {
            if (status.success === true) {
                $location.path('/wiadomosci');
            } else {
                alert(status.message);
            }

        });
    };

    if ($scope.editAction && EditMessageService.getMessage() !== null) {
        $scope.message = EditMessageService.getMessage();
    } else {
        $scope.message = {};
    }

}]);

