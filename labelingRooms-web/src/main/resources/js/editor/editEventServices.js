/**
 * Created by Kamil on 2016-11-24.
 */
var editEventServicesModule = angular.module(
    "EditEventServicesModule", ['ngResource']);

editEventServicesModule.factory('EditEventRepository', [
    '$resource', function ($resource) {
        return $resource('', {}, {
            getMyEvents: {
                method: 'GET',
                url: '/event/my'
            },
            removeMyEvent: {
                method: 'POST',
                url: '/event/remove/'
            }

        });
    }]);


editEventServicesModule.service('EditEventService', function () {

    var event = null;

    this.setEvent = function (newEvent) {
        event = newEvent;
    };
    this.getEvent = function () {
        return event;
    };
    this.clearEvent = function () {
        event = null;
    };

});