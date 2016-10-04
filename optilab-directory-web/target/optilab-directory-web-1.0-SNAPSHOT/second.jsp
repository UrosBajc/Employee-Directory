<div flex="20">
</div>
<div flex="60">
    <div ng-show="newEmp"><h3>Add new employee</h3></div>
    <div ng-hide="newEmp"><h3>Info about employee</h3></div>
    <form name="inputForm">
        <div layout-gt-sm="row">
            <md-input-container class="md-block" flex-gt-sm>
                <label>Name</label>
                <input name="name" minLength="1" ng-model="form.name">
            </md-input-container>
            <md-input-container class="md-block" flex-gt-sm>
                <label>Surname</label>
                <input name="surname"  minLength="1" ng-model="form.surname">
            </md-input-container>
        </div>
        <div layout-gt-sm="row">
            <md-input-container class="md-block" flex-gt-sm>
                <label>Choose department</label>
                <md-select name="department" ng-model="form.department">
                    <md-option value="SALES">Sales</md-option>
                    <md-option value="FINANCE">Finance</md-option>
                    <md-option value="ADMINISTRATIVE">Administrative</md-option>
                    <md-option value="DEVELOPMENT">Development</md-option>
                </md-select>
            </md-input-container>
            <md-input-container class="md-block" flex-gt-sm>
                <label>Internal number</label>
                <input name="internalNumber"  minLength="1" ng-model="form.internalNumber">
            </md-input-container>
        </div>
        <div>
            <section layout="row" layout-sm="column" layout-align="center center" layout-wrap>
                <md-button class="md-raised md-primary" ng-click="save(form)" ng-disabled="saveCheck()==false">Save</md-button>
                <md-button class="md-raised md-warn" ng-href="#!/">Cancel</md-button>
            </section>
        </div>
    </form>
</div>