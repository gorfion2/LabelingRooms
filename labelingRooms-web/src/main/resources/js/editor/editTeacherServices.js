/**
 * Created by Kamil on 2016-12-01.
 */

var editTeacherServicesModule = angular.module(
    "EditTeacherServicesModule", ['ngResource']);

editTeacherServicesModule.factory('EditTeacherRepository', [
    '$resource', function ($resource) {
        return $resource('', {}, {
            saveTeacher: {
                method: 'POST',
                url: '../teacher/register/'
            },
            editTeacher: {
                method: 'POST',
                url: '../teacher/edit/'
            }

        });
    }]);


editTeacherServicesModule.service('EditTeacherService', function () {

    var teacher = null;

    this.setTeacher = function (newTeacher) {
        teacher = newTeacher;
    };
    this.getTeacher = function () {
        return teacher;
    };
    this.clearTeacher = function () {
        teacher = null;
    };

});
