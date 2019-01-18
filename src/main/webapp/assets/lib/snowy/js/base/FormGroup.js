var FormGroup = function(id){
    this.id = id;
};

$.extend(FormGroup.prototype,{
    init : function(){
        return this;
    }
});