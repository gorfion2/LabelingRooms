/**
 * Created by Kamil on 2016-10-26.
 */
var scheduleModule = angular.module(
    'scheduleModule', ['ngRoute', 'scheduleModule', 'editEventServicesModule']);

scheduleModule.controller('scheduleController', ['$scope', '$interval', '$location', 'IndexService',
    function ($scope, $interval, $location, IndexService) {
        $scope.roomUtils = {};
        $scope.roomUtils.setBackgroundColor = function (style) {
            if ($scope.room.backgroundColor !== undefined) {
                style['background-color'] = $scope.room.backgroundColor;
            }
        };

        $scope.roomUtils.setBorderColor = function (style) {
            if ($scope.room.borderColor !== undefined) {
                style['border-color'] = $scope.room.borderColor;
            }
        };

        $scope.roomUtils.setLabelColor = function (style) {
            if ($scope.room.labelColor !== undefined) {
                style['background-color'] = $scope.room.labelColor;
            }
        };

        $scope.roomUtils.setLabColor = function (style) {
            if ($scope.room.labelColor !== undefined) {
                style['background-color'] = $scope.room.labColor;
            }
        };

        $scope.roomUtils.getMessageFontSizeStyle = function () {
            var style = {};
            if ($scope.room.messageFontSize !== undefined) {
                style['font-size'] = $scope.room.messageFontSize + '%';
            }
            return style;
        };

        $scope.roomUtils.setEventFontSizeStyle = function (style) {
            if ($scope.room.eventFontSize !== undefined) {
                style['font-size'] = $scope.room.eventFontSize + '%';
            }
        };


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
                $scope.roomUtils.setBorderColor($scope.tempStyle);
                $scope.roomUtils.setLabelColor($scope.tempStyle);
                // if (index == $scope.day.names.length - 1)
                //     $scope.tempStyle = {"border-width": "0px 0px 0px 0px"};
                $scope.tempStyle.width = $scope.hourColumn.width + "%";
                $scope.tempStyle.top = (index / $scope.hourColumn.getSize()) * (100 - $scope.day.height) + $scope.day.height + "%";
                $scope.tempStyle.height = (100 - $scope.day.height) / $scope.hourColumn.getSize() + "%";
                return $scope.tempStyle;
            }
        };

        $scope.day = {
            names: ["Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek", "Sobota", "Niedziela"],
            height: 7,
            getStyle: function (index) {
                $scope.tempStyle = {};
                $scope.roomUtils.setBorderColor($scope.tempStyle);
                $scope.roomUtils.setLabelColor($scope.tempStyle);
                if (index == $scope.day.names.length - 1)
                    $scope.tempStyle["border-width"] = "0px 0px 0px 0px";

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
                    $scope.roomUtils.setBackgroundColor($scope.tempStyle);
                    $scope.roomUtils.setBorderColor($scope.tempStyle);
                    if (index % 4 == 0)
                        $scope.tempStyle['border-width'] = '2px 0px 0px 0px';
                    $scope.tempStyle.height = (100 - $scope.day.height) / $scope.day.hours.quantity + "%";
                    return $scope.tempStyle;
                }
            }
        };

        $scope.eventUtils = {
            getStyle: function (startHour, startMinute, endHour, endMinute) {
                $scope.tempStyle = {};
                $scope.roomUtils.setLabColor($scope.tempStyle);
                $scope.tempStyle.width = "100%";
                $scope.roomUtils.setBorderColor($scope.tempStyle);
                $scope.roomUtils.setEventFontSizeStyle($scope.tempStyle);
                var startTimeDecimal = ( startHour - $scope.hourColumn.startHour + startMinute / 60);
                if (startMinute > endMinute) {
                    endMinute += 60;
                    endHour--;
                }
                var duration = endMinute - startMinute + (endHour - startHour) * 60;
                var durationDecimal = 0;
                while (duration > 60) {
                    duration = duration - 60;
                    durationDecimal++;
                }
                durationDecimal += duration / 60;

                $scope.tempStyle.top = (startTimeDecimal / $scope.hourColumn.getSize()) * (100 - $scope.day.height) + $scope.day.height + "%";
                $scope.tempStyle.height = ((100 - $scope.day.height) / $scope.hourColumn.getSize()) * durationDecimal + "%";
                // $scope.tempStyle['line-height'] = '100px';
                return $scope.tempStyle;
            }
        };

        $scope.roomId = $location.search();
        $scope.events = [];
        $scope.eventWrappers = [];
        $scope.eventWrapperIndex = 0;
        $scope.room = {};
        $scope.messages = [];
        $scope.title = "";
        $scope.actualDataVersion;


        $scope.reloadData = function () {
            IndexService.getDataVersion(function (wrapper) {
                if ($scope.actualDataVersion !== wrapper.data) {
                    $scope.actualDataVersion = wrapper.data
                    var roomId = $location.path().slice(1, 11);
                    if (roomId === undefined || roomId === null || roomId === 0)
                        return;

                    IndexService.getEvents({id: roomId}, function (eventsWrappers) {
                        $scope.eventWrappers = eventsWrappers;
                    });
                    IndexService.getMessages({id: roomId}, function (messages) {
                        $scope.messages = messages;
                    });
                    IndexService.getRoom({id: roomId}, function (room) {
                        $scope.room = room;
                    });
                }
            });
        };

        $scope.changeEvent = function () {
            if ($scope.eventWrappers.length != 0) {
                $scope.eventWrapperIndex++;
                if ($scope.eventWrapperIndex >= $scope.eventWrappers.length)
                    $scope.eventWrapperIndex = 0;
                $scope.events = $scope.eventWrappers[$scope.eventWrapperIndex].eventDtos;
                $scope.day.names = $scope.eventWrappers[$scope.eventWrapperIndex].dayNames;
                $scope.title = $scope.eventWrappers[$scope.eventWrapperIndex].title;
                $scope.events.forEach(function (event) {
                    event.style = $scope.eventUtils.getStyle(event.startHour, event.startMinute, event.endHour, event.endMinute);
                });
            }
        }

        $scope.reloadData();
        $scope.changeEvent();
        $interval($scope.reloadData, 5000);
        $interval($scope.changeEvent, 5000);


    }]);
