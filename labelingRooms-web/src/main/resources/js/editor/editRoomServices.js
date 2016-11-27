/**
 * Created by Kamil on 2016-11-27.
 */
var editRoomServicesModule = angular.module(
    "EditRoomServicesModule", ['ngResource']);

editRoomServicesModule.factory('EditRoomRepository', [
    '$resource', function ($resource) {
        return $resource('', {}, {
            saveRoom: {
                method: 'POST',
                url: '../room/save/'
            },
            editRoom: {
                method: 'POST',
                url: '../room/edit/'
            }

        });
    }]);


editRoomServicesModule.service('EditRoomService', function () {

    var room = null;

    this.setRoom = function (newRoom) {
        room = newRoom;
    };
    this.getRoom = function () {
        return room;
    };
    this.clearRoom = function () {
        room = null;
    };

});