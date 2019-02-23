String.prototype.format = function(args) {
    var result = this;
    if (arguments.length > 0) {
        if (arguments.length == 1 && typeof (args) == "object") {
            for (var key in args) {
                if (args[key] != undefined) {
                    var reg = new RegExp("({" + key + "})", "g");
                    result = result.replace(reg, args[key]);
                }
            }
        }
        else {
            for (var i = 0; i < arguments.length; i++) {
                if (arguments[i] != undefined) {
                    var reg = new RegExp("({)" + i + "(})", "g");
                    result = result.replace(reg, arguments[i]);
                }
            }
        }
    }
    return result;
};
String.format = function () {
    if (arguments.length == 0)
        return null;

    var str = arguments[0];
    for (var i = 1; i < arguments.length; i++) {
        var re = new RegExp('\\{' + (i - 1) + '\\}', 'gm');
        str = str.replace(re, arguments[i]);
    }
    return str;
};

window.console = window.console || (function () {
    var c = {}; c.log = c.warn = c.debug = c.info = c.error = c.time = c.dir = c.profile
        = c.clear = c.exception = c.trace = c.assert = function () { };
    return c;
})();

var __IsEmpty = function(object){
    if(object === undefined){
        return true;
    }

    if(object === null){
        return true;
    }

    if(object === ""){
        return true;
    }

    if(object.length === 0){
        return true;
    }

    return false;
};

var __IsTrue = function(object){
    if(__IsEmpty(object)){
        return false;
    }
    if(true === object){
        return true;
    }

    return false;
};

var __IsFalse = function(object){
    if(__IsEmpty(object)){
        return true;
    }
    if(false === object){
        return true;
    }

    return false;
};

var __randomString = function(length){
    length = length || 32;
    var $chars = '_ABCD_EFGH_IJKLMN_OPQRSTUVWX_YZabcdefgh_ijklmnopqrstu_vwxyz01234_56789';
    var maxPos = $chars.length;
    var string = '';
    for (var idx = 0; idx < length; idx++) {
        string += $chars.charAt(Math.floor(Math.random() * maxPos));
    }
    return string;
};