var IndexServices = angular.module(
    "eventsServicesModule", ['ngResource']);

IndexServices.factory('IndexService', [
    '$resource', function ($resource) {
        return $resource('', {}, {
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