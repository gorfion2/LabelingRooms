/**
 * Created by Kamil on 2016-12-17.
 */

var messagesModule = angular.module(
    'MessagesModule', []);

messagesModule.controller('MessagesController', ['$scope', '$location', '$timeout', 'MessagesService', 'EditMessageService', function ($scope, $location, $timeout, MessagesService, EditMessageService) {
    $scope.messages = [];

    $scope.reloadMessages = function () {
        MessagesService.getMyMessages(function (wrapper) {
            if (wrapper.message == null) {
                $scope.messages = wrapper.data;
            }
        });
    };
    $scope.reloadMessages();

    $scope.editMessage = function (message) {
        EditMessageService.setMessage(message);
        $location.path('/edytuj/wiadomosc');
    };
    $scope.removeMessage = function (message) {
        MessagesService.removeMyMessage(message, function (status) {
            if (status.success === true) {
                $scope.reloadMessages()
            } else {
                alert(status.message);
            }
        });
    };
}]);

