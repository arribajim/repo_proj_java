/*global require*/
var gulp = require("gulp"),
    webserver = require("gulp-webserver"),
    jsLint = require("gulp-jslint-simple");

// Servidor web de desarrollo
gulp.task("dev-server", function () {
    "use strict";

    gulp.src("./app")
        .pipe(webserver({
            open: true,
            livereload: true
        }));
});

// Busca errores de JavaScript de acuerdo con JsLint
gulp.task("jsLint", function () {
    "use strict";
    gulp.src('./app/js/*.js')
        .pipe(jsLint.run({
            // project-wide JSLint options
            node: true,
            vars: true
        }))
        .pipe(jsLint.report({
            // example of using a JSHint reporter
            reporter: require('jshint-stylish').reporter
        }));
});
gulp.task("default", gulp.series("jsLint", "dev-server"));