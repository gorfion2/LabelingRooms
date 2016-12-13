/**
 * Created by Kamil on 2016-12-12.
 */

var editMessageServicesModule = angular.module(
    "EditMessageServicesModule", ['ngResource']);

editMessageServicesModule.factory('EditMessageRepository', [
    '$resource', function ($resource) {
        return $resource('', {}, {
            saveMessage: {
                method: 'POST',
                url: '../message/save/'
            },
            editMessage: {
                method: 'POST',
                url: '../message/edit/'
            }

        });
    }]);


editMessageServicesModule.service('EditMessageService', function () {

    var message = null;

    this.setMessage = function (newMessage) {
        message = newMessage;
    };
    this.getMessage = function () {
        return message;
    };
    this.clearMessage = function () {
        message = null;
    };

});