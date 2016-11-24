/**
 * Created by Kamil on 2016-11-21.
 */
var eventsModule = angular.module(
    'EventsModule', []);

eventsModule.controller('EventsController', ['$scope', '$location', 'EventsService', 'EditEventService', function ($scope, $location, EventsService, EditEventService) {
    $scope.events = [];

    $scope.reloadEvents = function () {
        EventsService.getMyEvents(function (wrapper) {
            if (wrapper.message == null) {
                wrapper.data.forEach(function (event) {
                    event.start = event.startHour + ':' + event.startMinute;
                    event.end = event.endHour + ':' + event.endMinute;
                });
                $scope.events = wrapper.data;
            }
        });
    };
    $scope.reloadEvents();

    $scope.editEvent = function (event) {
        EditEventService.setEvent(event);
        $location.path('/edytuj/wydarzenie');
    };
    $scope.removeEvent = function (event) {
        EventsService.removeMyEvent(event);
        alert("Remove")
    };
}]);
