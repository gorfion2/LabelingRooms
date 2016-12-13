/**
 * Created by Kamil on 2016-11-27.
 */
var roomsModule = angular.module(
    'RoomsModule', []);

roomsModule.controller('RoomsController', ['$scope', '$location',
    'RoomsService', 'EditRoomService', function ($scope, $location, RoomsService, EditRoomService) {
        $scope.rooms = [];

        $scope.reloadRooms = function () {
            RoomsService.getMyRooms(function (wrapper) {
                if (wrapper.message == null) {
                    wrapper.data.forEach(function (room) {
                        room.owners = '';
                        for (var i = 0; i < room.teacherNameList.length; i++) {
                            if (room.owners.length!==0) {
                                room.owners = room.owners + ', ' + room.teacherNameList[i];
                            } else {
                                room.owners = room.owners + room.teacherNameList[i];
                            }
                        }

                    });
                    $scope.rooms = wrapper.data;
                } else {
                    alert(wrapper.message);
                }
            });
        };
        $scope.reloadRooms();


        $scope.assignRoom = function (room) {
            RoomsService.assignRoom({id: room.number}, function (status) {
                if (status.success === true) {
                    $scope.reloadRooms()
                } else {
                    alert(status.message);
                }
            });
        };

        $scope.exitRoom = function (room) {
            RoomsService.exitRoom({id: room.number}, function (status) {
                if (status.success === true) {
                    $scope.reloadRooms()
                } else {
                    alert(status.message);
                }
            });
        };

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
