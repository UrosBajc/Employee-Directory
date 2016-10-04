<div flex="20">
</div>
<div flex="70" layout-align="top-center" style="min-height:100%">
    <section layout="row" layout-sm="column" layout-align="center center" layout-wrap>
        <div flex="35" layout-align="center">
            <h3>Choose department:</h3>
        </div>
        <div flex="35" layout-align="center" class="btn-group" uib-dropdown is-open="status.isopen" >
            <button id="single-button" type="button" class="btn btn-primary" uib-dropdown-toggle style="background-color: #3f51b5; width:100%">
                {{department}} <span class="caret"></span>
            </button>
            <ul class="dropdown-menu" uib-dropdown-menu role="menu" aria-labelledby="single-button" style="width: 100%; text-align: center">
                <li role="menuitem"><a ng-click="department='All'">All</a></li>
                <li role="menuitem"><a ng-click="department='Sales'">Sales</a></li>
                <li role="menuitem"><a ng-click="department='Finance'">Finance</a></li>
                <li role="menuitem"><a ng-click="department='Administrative'">Administrative</a></li>
                <li role="menuitem"><a ng-click="department='Development'">Development</a></li>
            </ul>
        </div>
    </section>
    <div ng-if="employees.length == 0" style="text-align:center"><h4> There are no employees to be shown. </h4></div>
    <div ng-if="employees.length != 0">
        <md-card ng-repeat="employee in employees track by $index">
            <md-card-content>
                <div layout="row" layout-align="space-around end">
                    <div><strong>{{$index + 1}}</strong></div>
                    <div>Name:<strong> {{employee.name}}</strong></div>
                    <div>Surname:<strong> {{employee.surname}}</strong></div>
                </div>
            </md-card-content>
            <md-card-actions layout="row" layout-align="end center">
                <md-button class="md-raised md-primary" ng-click="getEmployee(employee.id)">More info</md-button>
                <md-button class="md-raised md-warn" ng-click="removeEmployee(employee.id)">Remove</md-button>
            </md-card-actions>
        </md-card>
    </div>
    <div layout="row">
        <section layout="row" layout-sm="column" layout-align="end center" style="width: 100%" layout-wrap>
            <md-button class="md-raised md-primary md-hue-1" ng-href="#!/employee/new">Add new employee</md-button>
        </section>
    </div>
</div>