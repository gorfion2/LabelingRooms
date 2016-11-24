/**
 * Created by Kamil on 2016-10-31.
 */
var scheduleServicesModule = angular.module(
    "eventsServicesModule", ['ngResource']);

scheduleServicesModule.factory('IndexService', [
    '$resource', function ($resource) {
        return $resource('', {}, {
            getEvents: {
                params: {id: "@id"},
                method: 'GET',
                url: '../../room/:id/events',
                isArray: true
            },
            getUser: {
                params: {id: "@id"},
                method: 'GET',
                url: '../user/:id'
            },
            postGret: {
                params: {id: "@id"},
                method: 'POST',
                url: '../gret/save/:id'
            },

            postUser: {
                method: 'POST',
                url: '../user'
                //               isArray: true
            }
        });
    }]);