/**
 * Created by Kamil on 2016-10-26.
 */
var scheduleModule = angular.module(
    'scheduleModule', ['ngRoute', 'scheduleModule', 'eventsServicesModule']);

scheduleModule.controller('scheduleController', ['$scope', '$interval', '$location', 'IndexService',
    function ($scope, $interval, $location, IndexService) {

        $scope.hourColumn = {
            width: 10,
            startHour: 8,
            endHour: 21,
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
        };

        $scope.day = {
            names: ["Poniedziałek", "Wtorek", "Sroda", "Czwartek", "Piątek"],
            height: 10,
            getStyle: function (index) {
                $scope.tempStyle = {};
                if (index == $scope.day.names.length - 1)
                    $scope.tempStyle = {"border-width": "0px 0px 0px 0px"};

                $scope.tempStyle.left = (index / $scope.day.names.length) * (100 - $scope.hourColumn.width) + $scope.hourColumn.width + "%";
                $scope.tempStyle.width = (100 - $scope.hourColumn.width) / $scope.day.names.length + "%";
                return $scope.tempStyle;
            },
            hours: {
                quantity: $scope.hourColumn.getSize() * 4,
                getQuantityArray: function () {
                    return new Array($scope.day.hours.quantity);
                },
                getStyle: function (index) {
                    $scope.tempStyle = {};
                    if (index % 4 == 0)
                        $scope.tempStyle['border-width'] = '2px 0px 0px 0px';
                    $scope.tempStyle.height = (100 - $scope.day.height) / $scope.day.hours.quantity + "%";
                    return $scope.tempStyle;
                }
            }
        };

        $scope.eventUtils = {
            getStyle: function (startHour, startMinute, duration) {
                $scope.tempStyle = {};
                $scope.tempStyle.width = "100%";
                var startTimeDecimal = ( startHour - $scope.hourColumn.startHour + startMinute / 60);
                var durationDecimal = 0;
                while (duration > 60) {
                    duration = duration - 60;
                    durationDecimal++;
                }
                durationDecimal += duration / 60;

                $scope.tempStyle.top = (startTimeDecimal / $scope.hourColumn.getSize()) * (100 - $scope.day.height) + $scope.day.height + "%";
                $scope.tempStyle.height = ((100 - $scope.day.height) / $scope.hourColumn.getSize()) * durationDecimal + "%";
                return $scope.tempStyle;
            }
        };
        $scope.roomId = $location.search();
        $scope.events = [];

        $scope.reloadData = function () {
            IndexService.getEvents({id: 1}, function (events) {
                $scope.events = events;
                $scope.events.forEach(function (event) {
                    event.style = $scope.eventUtils.getStyle(event.startHour, event.startMinute, event.duration);
                })
            });
        };
        $scope.reloadData();
        // $interval($scope.reloadData, 5000);
    }]);
