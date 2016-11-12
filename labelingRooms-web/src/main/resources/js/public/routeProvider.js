/**
 * Created by Kamil on 2016-07-24.
 */
var mainApp = angular.module("mainApp", ['ngRoute', 'scheduleModule','scheduleServicesModule']);
mainApp.config(['$routeProvider', function ($routeProvider) {
    $routeProvider.when('/index', {
        templateUrl: '/templates/schedule.html',
        controller: 'scheduleController'
    }).otherwise({
        redirectTo: '/'
    })

}
]);



