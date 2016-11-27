/**
 * Created by Kamil on 2016-11-27.
 */

var roomsServicesModule = angular.module(
    "RoomsServicesModule", ['ngResource']);

roomsServicesModule.factory('RoomsService', [
    '$resource', function ($resource) {
        return $resource('', {}, {
            getMyRooms: {
                method: 'GET',
                url: '/room/all'
            },
            removeMyRoom: {
                method: 'POST',
                url: '/room/remove/'
            }

        });
    }]);