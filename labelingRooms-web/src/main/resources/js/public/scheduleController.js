/**
 * Created by Kamil on 2016-10-26.
 */
var scheduleModule = angular.module(
    'scheduleModule', []);

scheduleModule.controller('scheduleController', ['$scope', 'IndexService', function ($scope, IndexService) {

    $scope.events= [];
    IndexService.getEvents({id: 1},function (events) {
        $scope.events=events;
    });

    $scope.hourColumn = {
        width: 10,
        startHour: 8,
        endHour: 18,
        getSize: function () {
            return $scope.hourColumn.endHour - $scope.hourColumn.startHour;
        },
        getHourArray: function () {
            var array = [];
            for (var i = $scope.hourColumn.startHour; i < $scope.hourColumn.endHour; i++)
                array.push(i);
            return array;
        },
        getStyle: function (index) {
            $scope.tempStyle = {};
            // if (index == $scope.day.names.length - 1)
            //     $scope.tempStyle = {"border-width": "0px 0px 0px 0px"};
            $scope.tempStyle.width = $scope.hourColumn.width + "%";
            $scope.tempStyle.top = (index / $scope.hourColumn.getSize()) * (100 - $scope.day.height) + $scope.day.height + "%";
            $scope.tempStyle.height = (100 - $scope.day.height) / $scope.hourColumn.getSize() + "%";
            return $scope.tempStyle;
        }
    }

    $scope.day = {
        names: ["Poniedziałek", "Wtorek", "Sroda", "Czwartek", "Piątek"],
        height: 10,
        getStyle: function (index) {
            $scope.tempStyle = {};
            if (index == $scope.day.names.length - 1)
                $scope.tempStyle = {"border-width": "0px 0px 0px 0px"};
            // $scope.tempStyle.height = $scope.day.height;

            $scope.tempStyle.left = (index / $scope.day.names.length) * (100 - $scope.hourColumn.width) + $scope.hourColumn.width + "%";
            $scope.tempStyle.width = (100 - $scope.hourColumn.width) / $scope.day.names.length + "%";
            return $scope.tempStyle;
        },
        hours: {
            quantity: 40,
            getQuantityArray: function () {
                return new Array($scope.day.hours.quantity);
            },
            getStyle: function (index) {
                $scope.tempStyle = {};
                // if ((index / 4) % 2 == 0)
                // $scope.tempStyle = {"background-color": "white"};
                // $scope.tempStyle.left = index / $scope.day.names.length * 100 + "%";

                $scope.tempStyle.height = (100 - $scope.day.height) / $scope.day.hours.quantity + "%";
                return $scope.tempStyle;
            },
        }
    };

    $scope.eventUtils = {
        getStyle: function (startHour, startMinute, duration) {
            $scope.tempStyle = {};
            $scope.tempStyle.width = "100%";
            var startTimeDecimal = ( startHour -$scope.hourColumn.startHour + startMinute / 60);
            var durationDecimal=0;
            while(duration>60){
                duration=duration-60;
                durationDecimal++;
            }
            durationDecimal+=duration/60;

            $scope.tempStyle.top = (startTimeDecimal / $scope.hourColumn.getSize()) * (100 - $scope.day.height) + $scope.day.height + "%";
            $scope.tempStyle.height = ((100 - $scope.day.height) / $scope.hourColumn.getSize())* durationDecimal + "%";
            return $scope.tempStyle;
        }
    };

    $scope.windowWidth = window.innerWidth;
    $scope.mesage = "test dobry";
    $scope.events = [{start: 10, end: 11}, {start: 11, end: 15}];
    $scope.add = function () {
        $scope.events.push({start: 14, end: 18});
    }
    $scope.test = function () {
        $scope.style = {
            "top": "70%",
            "max-height": "100%",
            "left": "50%"
        }

    }

    $scope.test1 = function () {
        $scope.style = {
            "top": "70%",
            "max-height": "10%",
            "left": "5%"
        }
    }

    $scope.style = {
        "top": "70%",
        "max-height": "15%",
        "width": "100%"
    }
    $scope.style.top = "10%";


    // $scope.events = [{dayName: "poniedziałek"}, {dayName: "wtorek"}, {dayName: "czwartek"}];

    $


}]);
