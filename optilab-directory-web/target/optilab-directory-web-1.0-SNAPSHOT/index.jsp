<%--
  Created by IntelliJ IDEA.
  User: Uros
  Date: 1. 10. 2016
  Time: 13:16
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html  ng-app="dirApp">
<head>
    <meta charset="ISO-8859-1">
    <title>Employee directory</title>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.5.8/angular.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.5.8/angular-animate.min.js"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.5.8/angular-aria.min.js"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.5.8/angular-messages.min.js"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.5.8/angular-route.min.js"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.5.8/angular-resource.min.js"></script>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/angular-material/1.1.1/angular-material.min.css">
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/angular-material/1.1.1/angular-material.min.js"></script>

    <link data-require="bootstrap-css@*" data-semver="3.3.1" rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css" />
    <script data-require="ui-bootstrap@*" data-semver="0.12.1" src="http://angular-ui.github.io/bootstrap/ui-bootstrap-tpls-0.12.1.min.js"></script>

    <script src="//angular-ui.github.io/bootstrap/ui-bootstrap-tpls-1.0.3.js"></script>
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">

    <!-- Icons -->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

    <script type="text/javascript" src="js/app.js"></script>
    <script type="text/javascript" src="js/services.js"></script>
</head>
<body>
    <section layout="row" flex style="background-color: #3f51b5" layout-align="center"><h1><span style="color:white">Employee directory</span></h1></section>
    <div ng-controller="MainController" layout="column" style="min-height:100%" ng-cloak>
        <section layout="row" flex>
            <md-content flex>
                <div layout="row" layout-padding layout-align="top center" ng-view>

                </div>
            </md-content>
        </section>
    </div>
</body>
</html>