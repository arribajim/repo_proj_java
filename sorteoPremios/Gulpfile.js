/*global require, console*/
var gulp = require("gulp"),
    webserver = require("gulp-webserver"),
    jsLint = require("gulp-jslint-simple");

// dev-server pay attention, gulp 4 needs return clause
gulp.task("dev-server", function () {
    "use strict";

    return gulp.src("./app")
        .pipe(webserver({
            open: true,
            livereload: true
        }));
});

// Busca errores de JavaScript de acuerdo con JsLint  pay attention, gulp 4 needs return clause
gulp.task("jsLint", function () {
    "use strict";
    return gulp.src('./app/js/*.js')
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
