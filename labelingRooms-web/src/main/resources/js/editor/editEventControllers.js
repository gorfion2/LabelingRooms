/**
 * Created by Kamil on 2016-11-23.
 */
var editEventModule = angular.module(
    'EditEventModule', []);

editEventModule.controller('EditEventController', ['$scope', '$location', 'EditEventRepository', 'EditEventService', function ($scope, $location, EditEventRepository, EditEventService) {

    $scope.editAction = $location.path() === '/edytuj/wydarzenie';
    $scope.timeRegex = '^[0-9]{1,2}:[0-9]{1,2}$';
    $scope.roomRegex = '^[0-9]{3}$';
    $scope.setEventStartTime = function (time) {
        if (time != null || time != undefined) {
            var timeTable = time.split(':');
            var hour = parseInt(timeTable[0]);
            var minute = parseInt(timeTable[1]);
            if (timeTable.length == 2 && $scope.validTime(hour, minute)) {
                $scope.event.startHour = hour;
                $scope.event.startMinute = minute;
                $scope.setEventEndTime($scope.event.end);
                $scope.validStartTime = true;
                return;
            }
        }
        $scope.validStartTime = false;
    };
    $scope.setEventEndTime = function (time) {
        if (time != null || time != undefined) {
            var timeTable = time.split(':');
            var hour = parseInt(timeTable[0]);
            var minute = parseInt(timeTable[1]);
            if (timeTable.length == 2 && $scope.validateEndTime(hour, minute)) {
                $scope.event.endHour = hour;
                $scope.event.endMinute = minute;
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
            else if ($scope.event.startHour == hour) {
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
    if ($scope.editAction && EditEventService.getEvent() !== null) {
        $scope.event = EditEventService.getEvent();
        $scope.setEventStartTime($scope.event.start);
        $scope.setEventEndTime($scope.event.end);
    } else {
        $scope.event = {week: 'Każdy', weekDay: 'Poniedziałek'};
    }
    $scope.save = function () {
        EditEventRepository.saveEvent($scope.event, function (status) {
            if(status.success===true){
                $location.path('/');
            }else{
                alert(status.message);
            }
            
        });
    }

}]);
