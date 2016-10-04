angular.module('optilab-directory.services', [])
    .factory('Employees', function($resource) {
        return {
            employee: $resource('http://localhost:8080/dir/getData?type=getEmp&id=:empId', {empId: '@empId'}, { }),
            delEmployee: $resource('http://localhost:8080/dir/getData?type=delEmp&id=:empId', {empId: '@empId'}, { }),
            department: $resource('http://localhost:8080/dir/getData?type=dep&dep=:department', {department: '@department'}, {})

        };
    })