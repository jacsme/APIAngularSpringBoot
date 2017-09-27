<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html data-ng-app="employeeapp">
<head>
<meta charset="utf-8" />
<title>Employee Page</title>
<head>
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.0/angular.min.js"></script>
	 <style>
        table, th, td {
            border:solid 1px #DDD;
            padding:3px;
            font:14px Verdana;
            text-align:center;
        }
        th {font-weight:bold;}
    </style>
</head>
<script>
var app = angular.module('employeeapp', []);
app.controller('EmployeeController',
    function ($scope, $http) {
		
		//This is the sample result from Backend API
		//[{"CEO":"Jamie"},{"Manager":"Alan"},{"Employee":"Martin"},{"Employee":"Alex"},{"Manager":"Steve"},{"Employee":"David"},{"Success":"Record(s) Found"}]
 
            $scope.employeeArray = new Array;
 
            $scope.displayEmployeeList = function(data){
            	$http.post('/APIEmployeeSpringBoot/employeeList/')
            	.success(function (data, status, headers, config) {
            		console.log('Employee List' +data);
                
            		$scope.employeeArray = data;
            		$scope.employeeArrayList = $scope.employeeArray;
            })
            .error(function () {
            	alert('Error')
            });
        }
});
</script>
<body>
    <div ng-app="employeeapp" ng-controller="EmployeeController">
        <table>
            <tr>
                <th>CEO</th>
                <th>Managers</th>
                <th>Employee</th>
            </tr>
            <tr ng-repeat="employee in employeeArrayList">
                <td>{{employee.CEO}}</td>
                <td>{{employee.Manager}}</td>
                <td>{{employee.Employee}}</td>
            </tr>
            <tr>
            	<td colspan="3" style="text-align:center">
		        	<button data-ng-click="displayEmployeeList()">Run</button>
		        </td>
            </tr>
        </table>
    </div>
</body>
</html>
