/**
 * Created by Kamil on 2016-10-31.
 */
var scheduleServicesModule = angular.module(
    "editEventServicesModule", ['ngResource']);

scheduleServicesModule.factory('IndexService', [
    '$resource', function ($resource) {
        return $resource('', {}, {
            getEvents: {
                params: {id: "@id"},
                method: 'GET',
                url: '../../room/:id/events',
                isArray: true
            },
            getRoom: {
                params: {id: "@id"},
                method: 'GET',
                url: '../../room/:id',
            }
        });
    }]);