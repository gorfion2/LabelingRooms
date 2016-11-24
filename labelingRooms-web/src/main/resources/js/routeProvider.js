var mainApp = angular.module("mainApp", ['ngRoute','IndexControllers','eventsServicesModule']);
mainApp.config(['$routeProvider', function($routeProvider) {
    $routeProvider.

        when('/registration', {
            templateUrl: '/registration.html',
            controller: 'RegistrationController'
        }).



        otherwise({
            templateUrl: '/mainPage.html',
            controller: 'MainPageController'
        });
}]);

