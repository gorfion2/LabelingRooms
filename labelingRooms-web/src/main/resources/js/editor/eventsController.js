/**
 * Created by Kamil on 2016-11-21.
 */
var eventsModule = angular.module(
    'EventsModule', []);

eventsModule.controller('EventsController', ['$scope','$location', 'EventsService', function ($scope,$location, EventsService) {
    $scope.events = [];

    $scope.reloadEvents = function () {
        EventsService.getMyEvents(function (wrapper) {
            if (wrapper.message == null) {
                wrapper.data.forEach(function (event) {
                    event.start = event.startHour + ':' + event.startMinute;
                });
                $scope.events = wrapper.data;
            }
        });
    };
    $scope.reloadEvents();

    $scope.editEvent = function (event) {
        // $location.url($location.path());
        $location.path('/edytuj/wydarzenie');
    };
    $scope.removeEvent = function (event) {
        EventsService.removeMyEvent(event);
        alert("Remove")
    };
}]);
