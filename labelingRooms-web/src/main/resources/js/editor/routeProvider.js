/**
 * Created by Kamil on 2016-07-24.
 */
var mainApp = angular.module("mainApp", ['ngRoute', 'EventsModule', 'EventsServicesModule', 'EditEventModule', 'EditEventServicesModule', 'RoomsServicesModule', 'RoomsModule', 'EditRoomServicesModule', 'EditRoomModule']);
mainApp.config(['$routeProvider', function ($routeProvider) {
    $routeProvider.when('/', {
        templateUrl: '/templates/events.html',
        controller: 'EventsController'
    }).when('/edytuj/wydarzenie', {
            templateUrl: '/templates/editEvent.html',
            controller: 'EditEventController'
        }
    ).when('/dodaj/wydarzenie', {
            templateUrl: '/templates/editEvent.html',
            controller: 'EditEventController'
        }
    ).when('/pokoje', {
            templateUrl: '/templates/rooms.html',
            controller: 'RoomsController'
        }
    ).when('/edytuj/pokoj', {
            templateUrl: '/templates/editRoom.html',
            controller: 'EditRoomController'
        }
    ).when('/dodaj/pokoj', {
            templateUrl: '/templates/editRoom.html',
            controller: 'EditRoomController'
        }
    ).otherwise({
        redirectTo: '/'
    })

}
]);

mainApp.controller('NavbarController', ['$scope', '$location', function ($scope, $location) {
    $scope.isEventsPage= function () {
       return  $location.path() === '/';
    };
    $scope.isAddEventPage= function () {
        return  $location.path() === '/dodaj/wydarzenie';
    };
    $scope.isRoomsPage= function () {
        return  $location.path() === '/pokoje';
    };
    $scope.isAddRoomPage= function () {
        return  $location.path() === '/dodaj/pokoj';
    };
}]);



