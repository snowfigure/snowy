
'use strict';
var gulp = require('gulp');
var concat = require('gulp-concat');
var uglify = require('gulp-uglify');
var rename = require('gulp-rename');
var minifycss = require('gulp-minify-css');
var del = require('del');

function concatSnowyCss(){
    var snowyCss = [
        "./src/main/webapp/assets/_dev/snowy/css/default.css",
        "./src/main/webapp/assets/_dev/snowy/css/nav-bar.css"
    ];
    return gulp.src(snowyCss).
            pipe(concat('snowy.css')).
            pipe(gulp.dest('./src/main/webapp/assets/lib/snowy/css/'));
}

function concatSnowyJs(){
    var snowyCss = [
        "./src/main/webapp/assets/_dev/snowy/js/global.js",
        "./src/main/webapp/assets/_dev/snowy/js/base/Common.js",
        "./src/main/webapp/assets/_dev/snowy/js/base/FormGroup.js",
        "./src/main/webapp/assets/_dev/snowy/js/base/Modal.js",
        "./src/main/webapp/assets/_dev/snowy/js/base/Panel.js",
        "./src/main/webapp/assets/_dev/snowy/js/DataTable.js",
        "./src/main/webapp/assets/_dev/snowy/js/NavBar.js",
        "./src/main/webapp/assets/_dev/snowy/js/Tree.js"
    ];
    return gulp.src(snowyCss).
    pipe(concat('snowy.js')).
    pipe(gulp.dest('./src/main/webapp/assets/lib/snowy/js/'));
}

function compressSnowyJs(){
    return gulp.src('./src/main/webapp/assets/lib/snowy/js/snowy.js').
    pipe(uglify({output: {ascii_only: true}})).
    pipe(concat('snowy.min.js')).
    pipe(gulp.dest('./src/main/webapp/assets/lib/snowy/js/'))
}
function compressHighlight(){
    return gulp.src("./src/main/webapp/assets/lib/highlight/styles/*.css").
    pipe(rename({suffix: '.min'})).
    pipe(minifycss()).
    pipe(gulp.dest('./src/main/webapp/assets/lib/highlight/styles/'))
}

function compressSnowyCss(){
    return gulp.src('./src/main/webapp/assets/lib/snowy/css/snowy.css').
    pipe(rename({suffix: '.min'})).
    pipe(minifycss()).
    pipe(gulp.dest('./src/main/webapp/assets/lib/snowy/css/'))
}

function cleanProcess () {
    return del([
        './src/main/webapp/assets/lib/snowy/css/snowy.min.css',
        './src/main/webapp/assets/lib/snowy/js/snowy.min.js'
    ])
}

gulp.task('default',
    gulp.series(cleanProcess,
        gulp.parallel(concatSnowyCss, concatSnowyJs),
        //
        gulp.parallel(compressSnowyJs,compressSnowyCss)
    )
);
