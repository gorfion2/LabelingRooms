/**
 * Created by Kamil on 2016-11-27.
 */
var roomsModule = angular.module(
    'RoomsModule', []);

roomsModule.controller('RoomsController', ['$scope', '$location',
    'RoomsService','EditRoomService', function ($scope, $location, RoomsService, EditRoomService) {
        $scope.rooms = [];

        $scope.reloadRooms = function () {
            RoomsService.getMyRooms(function (wrapper) {
                if (wrapper.message == null) {
                    $scope.rooms = wrapper.data;
                } else {
                    alert(wrapper.message);
                }
            });
        };
        $scope.reloadRooms();

        $scope.editRoom = function (room) {
            EditRoomService.setRoom(room);
            $location.path('/edytuj/pokoj');
        };
        $scope.removeRoom = function (room) {
            RoomsService.removeMyRoom(room, function (status) {
                if (status.success === true) {
                    $scope.reloadRooms()
                } else {
                    alert(status.message);
                }
            });
        };
    }]);
