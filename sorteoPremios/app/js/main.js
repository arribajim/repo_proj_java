/*global angular, console */
var angularApp = angular.module('SorteoPremios', ['ui.bootstrap']);
angularApp.controller('PremioController', function ($scope) {
    'use strict';

    $scope.listaPremios = {
        viajes: ["viaje 1", "viaje 2"],
        motor: ["Carro", "carro 2"],
        propiedades: ["bodega", "rancho"]
    };

    $scope.elegirPremios = function (tipoPremio) {
        var premiosPosibles = $scope.listaPremios[tipoPremio];
        $scope.premio = premiosPosibles[Math.floor(Math.random() * premiosPosibles.length)];

    };
});
/*   $scope.elegirPremio = function () {
       var primerPremio = Math.floor(Math.random() * $scope.listaPremios.length),
           ultimoPremio = Math.floor(Math.random() * $scope.listaPremios.length);
       $scope.premios = $scope.listaPremios.slice(Math.min(primerPremio, ultimoPremio),
           Math.max(primerPremio, ultimoPremio));

       $scope.fechaSorteo = new Date();
   };*/

/*.filter("filtroFechaSorteo", function () {
    "use strict";

    return function (fechaSorteo) {
        return fechaSorteo.getDate() + " del " +
            (fechaSorteo.getUTCMonth() + 1) + " de " +
            fechaSorteo.getFullYear();
    };
});*/

function saludo_consola() {
    "use strict";
    console.log("Welcome al sorteo de premioos");
}
