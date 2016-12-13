/**
 * Created by Kamil on 2016-11-27.
 */
var editRoomModule = angular.module(
    'EditRoomModule', []);

editRoomModule.controller('EditRoomController', ['$scope', '$location', 'EditRoomRepository', 'EditRoomService', function ($scope, $location, EditRoomRepository, EditRoomService) {

    $scope.editAction = $location.path() === '/edytuj/pokoj';

    $scope.save = function () {
        EditRoomRepository.saveRoom($scope.room, function (status) {
            if(status.success===true){
                $location.path('/pokoje');
            }else{
                alert(status.message);
            }

        });
    };

    $scope.edit = function () {
        EditRoomRepository.editRoom($scope.room, function (status) {
            if(status.success===true){
                $location.path('/pokoje');
            }else{
                alert(status.message);
            }

        });
    };

    if ($scope.editAction && EditRoomService.getRoom() !== null) {
        $scope.room = EditRoomService.getRoom();
    } else {
        $scope.room = {"borderColor":"#ffffff","backgroundColor":"#9B9B9B","labColor":"#0a3aff","labelColor":"#7A4DF2"} ;
    }

}]);

