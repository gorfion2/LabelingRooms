/**
 * Created by Kamil on 2016-07-24.
 */
var mainApp = angular.module("mainApp", ['ngRoute', 'EventsModule', 'EventsServicesModule', 'EditEventModule', 'EditEventServicesModule', 'RoomsServicesModule', 'RoomsModule']);
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
    ).otherwise({
        redirectTo: '/'
    })

}
]);



