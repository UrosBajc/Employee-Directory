app = angular.module('dirApp', ['ngRoute', 'ngAnimate','ngMaterial','ngResource','ui.bootstrap','optilab-directory.services'])
    .config(['$routeProvider', '$locationProvider',
        function($routeProvider, $locationProvider) {

            $routeProvider
                .when('/', {
                    templateUrl: 'first.jsp',
                    controller: 'MainController',
                    controllerAs: 'main'
                })
                .when('/employee/:empId', {
                    templateUrl: 'second.jsp',
                    controller: 'EmployeeController',
                    controllerAs: 'employee'
                })
                .otherwise({
                    redirectTo: '/'
                });

            $locationProvider.html5Mode(false);
            $locationProvider.hashPrefix('!');
        }])
    .controller("MainController", function($scope, Employees, $route, $location, $mdToast) {

        $scope.department = "All";
        $scope.employees = undefined;

        $scope.getEmployee = function(id) {
            $location.path("/employee/"+id);
        };

        $scope.removeEmployee = function(id) {
            Employees.delEmployee.get({empId:id})
                .$promise
                .then(function(data){
                    $scope.employees = undefined;
                    $mdToast.show(
                        $mdToast.simple()
                            .textContent('Employee succesfully removed.')
                            .position("bottom right")
                            .hideDelay(3000)
                    );
                    $scope.getByDepartment();
                },function(err){
                    console.log(err);
                })
        }

        $scope.$watch('department', function() {
            $scope.getByDepartment();
        });

        $scope.getByDepartment = function () {
            Employees.department.query({department: $scope.department.toLowerCase()})
                .$promise
                .then(function(employees){
                    $scope.employees = employees;
                },function(err){
                    console.log(err);
                })
        }
}).controller("EmployeeController", function ($scope, Employees, $location, $routeParams, $mdToast) {
    $scope.existingEmp = undefined;
    if(angular.equals($routeParams.empId,"new")){ //add new employee
        $scope.newEmp = true;
    }
    else{ //update existing
        $scope.newEmp = false;
        Employees.employee.get({empId:$routeParams.empId})
            .$promise
            .then(function(employee){
                $scope.form = employee;
                $scope.existingEmp = {};
                $scope.existingEmp.name = employee.name;
                $scope.existingEmp.surname = employee.surname;
                $scope.existingEmp.department = employee.department;
                $scope.existingEmp.internalNumber = employee.internalNumber;
                console.log($scope.form);
            },function(err){
                console.log(err);
            })
    }
    
    $scope.save = function (form) {
        Employees.employee.save(form)
            .$promise
            .then(function (res) {
                if($scope.newEmp){
                    $mdToast.show(
                        $mdToast.simple()
                            .textContent('New employee succesfully added.')
                            .position("bottom right")
                            .hideDelay(3000)
                    );
                }
                else{
                    $mdToast.show(
                        $mdToast.simple()
                            .textContent('Employee succesfully updated.')
                            .position("bottom right")
                            .hideDelay(3000)
                    );
                }
                $location.path("/");
            }, function (err) {
                console.log(err);
            })
    }

    $scope.saveCheck = function () {
        if($scope.form == null)
            return false;

        if ($scope.form.name == null || $scope.form.name.length == 0) {
            return false;
        }
        if ($scope.form.surname == null || $scope.form.surname.length == 0) {
            return false;
        }
        if ($scope.form.department == null || $scope.form.department.length == 0) {
            return false;
        }
        if ($scope.form.internalNumber == null || $scope.form.internalNumber.length == 0) {
            return false;
        }

        if (!$scope.newEmp &&
            $scope.form.name  === $scope.existingEmp.name &&
            $scope.form.surname  === $scope.existingEmp.surname &&
            $scope.form.department  === $scope.existingEmp.department &&
            $scope.form.internalNumber  === $scope.existingEmp.internalNumber) {
            console.log($scope.form);
            console.log($scope.existingEmp);
            return false;
        }
    }
})