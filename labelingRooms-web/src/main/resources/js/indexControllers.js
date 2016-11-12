var indexControllers = angular.module(
    'IndexControllers', []);

indexControllers.controller('RegistrationController',['$scope','IndexService', function($scope, IndexService) {
    $scope.message = "Registration form";
    $scope.myUser={};
    $scope.send = function(){
        IndexService.postGret({id:8},$scope.gret);
    }
    $scope.gret = {};

    IndexService.postGret({id:3}, $scope.gret);
}]);

indexControllers.controller('MainPageController',['$scope','IndexService', function($scope,IndexService) {
    $scope.message = "Main page";
    $scope.user;


    IndexService.getUser({id:12},function(user){
        $scope.user =user;
    });
}]);