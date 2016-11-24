/**
 * Created by Kamil on 2016-11-21.
 */
/**
 * Created by Kamil on 2016-10-31.
 */
var eventsServicesModule = angular.module(
    "EventsServicesModule", ['ngResource']);

eventsServicesModule.factory('EventsService', [
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