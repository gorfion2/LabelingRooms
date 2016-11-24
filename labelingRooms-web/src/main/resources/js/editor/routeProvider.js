/**
 * Created by Kamil on 2016-07-24.
 */
var mainApp = angular.module("mainApp", ['ngRoute', 'EventsModule', 'EventsServicesModule','EditEventModule']);
mainApp.config(['$routeProvider', function ($routeProvider) {
    $routeProvider.when('/', {
        templateUrl: '/templates/events.html',
        controller: 'EventsController'
    }).when('/edytuj/wydarzenie', {
            templateUrl: '/templates/editEvent.html',
            controller: 'EditEventController'
    }
    ).otherwise({
        redirectTo: '/'
    })

} 
]);



