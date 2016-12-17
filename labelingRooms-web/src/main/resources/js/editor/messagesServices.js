/**
 * Created by Kamil on 2016-12-17.
 */
var messagesServicesModule = angular.module(
    "MessagesServicesModule", ['ngResource']);

messagesServicesModule.factory('MessagesService', [
    '$resource', function ($resource) {
        return $resource('', {}, {
            getMyMessages: {
                method: 'GET',
                url: '/message/my'
            },
            removeMyMessage: {
                method: 'POST',
                url: '/message/remove/'
            }

        });
    }]);