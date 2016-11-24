/**
 * Created by Kamil on 2016-11-23.
 */
/**
 * Created by Kamil on 2016-11-21.
 */
var editEventModule = angular.module(
    'EditEventModule', []);

editEventModule.controller('EditEventController', ['$scope', '$location', 'EventsService', function ($scope, $location, EventsService) {
    $scope.event = {week: 'Każdy', weekDay: 'Poniedziałek'};
    $scope.timeRegex = '^[0-9]{1,2}:[0-9]{1,2}$';
    $scope.roomRegex = '^[0-9]{3}$';
    $scope.setEventStartTime = function (time) {
        if (time != null || time != undefined) {
            var timeTable = time.split(':');
            if (timeTable.length == 2 && $scope.validTime(timeTable[0], timeTable[1])) {
                $scope.event.startHour = timeTable[0];
                $scope.event.startMinute = timeTable[1];
                $scope.setEventEndTime($scope.endTime);
                $scope.validStartTime = true;
                return;
            }
        }
        $scope.validStartTime = false;
    };
    $scope.setEventEndTime = function (time) {
        if (time != null || time != undefined) {
            var timeTable = time.split(':');
            if (timeTable.length == 2 && $scope.validateEndTime(timeTable[0], timeTable[1])) {
                $scope.event.endHour = timeTable[0];
                $scope.event.endMinute = timeTable[1];
                $scope.validEndTime = true;
                return;
            }
        }
        $scope.validEndTime = false;
    };
    $scope.validateEndTime = function (hour, minute) {
        if ($scope.validTime(hour, minute)) {
            if ($scope.event.startHour < hour)
                return true;
            else if($scope.event.startHour == hour){
                if ($scope.event.startMinute < minute)
                    return true;
            }
        }
        return false;
    }
    $scope.validTime = function (hour, minute) {
        if (hour >= 0 && hour < 24 && minute >= 0 && minute < 60)
            return true;
        return false;
    }

}]);
