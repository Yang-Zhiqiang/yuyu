$(function() {

  $("input").hover(
    function() {
      $(this).addClass("hovered");
    },
    function() {
      $(this).removeClass("hovered");
    }
  );

  var resizeTimer = false;
  var resizeChk = true;

  $(window).resize(function(){
    try{
      if(resizeTimer !== false){
        clearTimeout(resizeTimer);
      }
      resizeTimer = setTimeout(function(){
        if(resizeChk === true){
          setCookie(COOKIE_KEY_WINDOWWIDTH,$(window).width(), null, "/");
          setCookie(COOKIE_KEY_WINDOWHEIGHT,$(window).height(), null, "/");
        }
        resizeChk = true;
      },200);
    } catch (e) {
      if(e.number === -2147024891) {
      } else {
        throw e;
      }
    }
  });

  var cookieWindowWidth = getCookie(COOKIE_KEY_WINDOWWIDTH);
  var cookieWindowHeight = getCookie(COOKIE_KEY_WINDOWHEIGHT);

  if (cookieWindowWidth == null && cookieWindowHeight == null) {
    try {
      resizeChk = false;
      window.resizeTo(WINDOW_WIDTH,WINDOW_HEIGHT);
    } catch (e) {
      if (e.number === -2147024891) {
      } else {
        throw e;
      }
    }
  } else {
    try {
      resizeChk = false;
      window.resizeTo(cookieWindowWidth,cookieWindowHeight);
      var dw = parseInt(cookieWindowWidth)-parseInt($(window).width());
      var dh = parseInt(cookieWindowHeight)-parseInt($(window).height());
      resizeChk = false;
      window.resizeTo(parseInt(cookieWindowWidth)+parseInt(dw),parseInt(cookieWindowHeight)+parseInt(dh));
    } catch (e) {
      if(e.number === -2147024891) {
      } else {
        throw e;
      }
    }
  }

});


function showList(selector){
  if ($(selector)[0].rows.length > 1) {
    $(selector + "Div").visible(true);
  }
}

function showGroup(selector){

  $(selector + "Div").visible(true);

}

function showKoumoku(selector){
  var labelId;
  if (selector.indexOf(".") == -1) {
    labelId = selector + "_label";
  } else {
    labelId = "#" + selector.substring(selector.indexOf(".") + 1) + "_label";
  }
  $(labelId).parent().visible(true);

  var koumokuId;

  koumokuId = "." +  selector.substring(1) + "_data";

  $(koumokuId).visible(true);

}

function addTopBottomLink(selector) {
  var selectorDiv = selector + "Div"
  $(selectorDiv).after('<div class="topBottomLink"><a href="#PageTop" class="topbottom">▲トップへ</a><a href="#PageBottom" class="topbottom">▼下へ</a></div>');
}

function addTopLink(selector) {
  var selectorDiv = selector + "Div"
  $(selectorDiv).after('<div class="topBottomLink"><a href="#PageTop" class="topbottom">▲トップへ</a></div>');
}

function addBottomLink(selector) {
  var selectorDiv = selector + "Div"
  $(selectorDiv).after('<div class="topBottomLink"><a href="#PageBottom" class="topbottom">▼下へ</a></div>');
}

function showTopBottomLink(selector) {
  var selectorDiv = selector + "Div"
  $(selectorDiv).next(".topBottomLink").visible(true);
}

function hideTopBottomLink(selector) {
  var selectorDiv = selector + "Div"
  $(selectorDiv).next(".topBottomLink").visible(false);
}

function gotoTop() {
  $('html, body').animate({scrollTop:0},'fast');
  return false;
}

function gotoBottom() {
  var targetOffset = $(document).height();
  $('html,body').animate({ scrollTop: targetOffset },'fast');
  return false;
}

function gotoTarget(selector) {
  var targetOffset = $(selector).offset().top;
  $('html,body').animate({ scrollTop: targetOffset },'fast');
}

$(function() {
  $(document).on('click', 'a[href="#PageTop"]', function(){
    gotoTop();
  });
  $(document).on('click', 'a[href="#PageBottom"]', function(){
    gotoBottom();
  });
});

function listRowShift(delRowObj){
   var delRowId = $(delRowObj).find(':input[id]').first().attr('id');
   var tmp = delRowId.split(/\[|\]/);
   var delRowNum = Number(tmp[1]);

   var moveRows = $(delRowObj).nextAll('tr:visible').filter(function(){
       var thisId = $(this).find(':input[id]').first().attr('id');
       var tmp = thisId.split(/\[|\]/);
       var thisNum = Number(tmp[1]);
       if(delRowNum < thisNum){
           return true;
       }else{
           return false;
       }
   });

   $(moveRows).find(':input[id]').each(function(){
       var thisListId = $(this).attr('id');
       tmp = thisListId.split(/\[|\]/);
       var ddid = tmp[0];
       var prevNum = tmp[1] - 1;
       var groupId = thisListId.slice(thisListId.indexOf("]") + 1);
       var prevInputId = "#" + ddid + "[" + prevNum + "]" + groupId;
       prevInputId = prevInputId.replace(/:/g, "\\:");
       prevInputId = prevInputId.replace(/\./g, "\\.");
       prevInputId = prevInputId.replace(/\[/g, "\\[");
       prevInputId = prevInputId.replace(/\]/g, "\\]");

       var tagName = this.tagName.toUpperCase();
       switch (tagName){
           case "INPUT":
               var type = $(this).attr("type");
               if(type == "checkbox" || type == "radio"){
                   $(prevInputId).prop('checked', $(this).prop('checked')).trigger('valueSync');
               }else if(type != "button"){
                   $(prevInputId).val($(this).val()).trigger('valueSync');
               }
               break;

           case "SELECT":
           case "TEXTAREA":
               $(prevInputId).val($(this).val()).trigger('valueSync');
               break;
       };

       if($(this).hasClass('errorItem')){
           $(this).removeClass('errorItem');
           $(prevInputId).addClass('errorItem');
       }
   });
}


function getListVisibleRowCount(listGroup){
   var rows = $(listGroup).find('tr:visible').filter(function(){
       if($(this).children('td.label').length){
           return false;
       }else{
           return true;
       }
   });

   var rowCount = 0;
   var lastRowNum = null;
   rows.each(function(){
     var rowId = $(this).find(':input[id]').first().attr('id');
     rowId = rowId.split(/\[|\]/);
     var thisRowNum = rowId[1];

     if(thisRowNum != lastRowNum){
       rowCount++;
     }

     lastRowNum = thisRowNum;
   });

   return rowCount;
}


function getMultiLineListRows(trObj){
   var rowId = $(trObj).find(':input').first().attr('id');
   var tmp = rowId.split(/\[|\]/);
   var rowNum = tmp[1];

   return $(trObj).parents('table').find('tr').filter(function(){
       if(!$(this).find(':input[id]').first().length){
           return false;
       }

       var thisId = $(this).find(':input[id]').first().attr('id');
       var tmp = thisId.split(/\[|\]/);
       var thisNum = tmp[1];
       if(rowNum == thisNum){
           return true;
       }else{
           return false;
       }
   });
}

function inputToOutput(selectObj) {
  $(selectObj).each(function (){
        var _selecterEscape = function(selecter){
            return String(selecter).replace(/:/g, "\\:").replace(/\./g, "\\.").replace(/\[/g, "\\[").replace(/\]/g, "\\]");
        }

        var _createSpanId = function(_this, escape){
            var spanId = $(_this).attr('id') + 'OutputSpan';
            if(escape === true){
                spanId = _selecterEscape(spanId);
            }
            return spanId;
        }

        var _valueSync = function(_this){
            var tagName = _this.tagName.toUpperCase();

            var targetSpan = $(_this).nextAll('span#' + _createSpanId(_this, true) + '.outputSpan').first();
            switch(tagName){
                case "SELECT":
                    var thisVal = $(_this).val();
                    var outputVal = $(_this).children('[value="' + _selecterEscape(thisVal) + '"]').text();
                    targetSpan.text(outputVal);
                    break;

                case "TEXTAREA":
                    var thisVal = $(_this).val();

                    var outputVal = thisVal.replace(/\r\n/g, "<br />").replace(/\r/g, "<br />").replace(/\n/g, "<br />");
                    targetSpan.html(outputVal);
                    break;

                case "INPUT":
                    var inputType = $(_this).attr('type').toLowerCase();
                    switch(inputType){
                        case "checkbox":
                            var outputVal = "";
                            if ($(_this)[0].nextSibling.nextSibling.nodeType == 3) {
                                outputVal = $(_this)[0].nextSibling.nextSibling.data;
                            } else {
                                var thisId = $(_this).attr('id');
                                outputVal = $(_this).nextAll('label[for='+ _selecterEscape(thisId) +']').text();
                            }

                            targetSpan.text(outputVal);
                            if($(_this).prop('checked')){
                                targetSpan.visible(true);
                            }else{
                                targetSpan.visible(false);
                            }
                            break;
                        case "radio":
                            var thisId = $(_this).attr('id');
                            var outputVal = $(_this).nextAll('label[for='+ _selecterEscape(thisId) +']').text();
                            targetSpan.text(outputVal);

                            if($(_this).prop('checked')){
                                targetSpan.visible(true);
                            }else{
                                targetSpan.visible(false);
                            }
                            break;
                        case "text":
                            var outputVal = $(_this).val();

                            var id = $(_this).attr("id").replace(":date", ":");
                            id = _selecterEscape(id);
                            if ($('#' + id + 'gengou')[0] && outputVal == '' && $('#' + id + 'gengouOutputSpan')[0]) {

                               $('#' + id + 'gengouOutputSpan').text('');
                            }
                            targetSpan.text(outputVal);
                            break;
                    }
                    break;
            }
        }


        var targetObj = $(this).filter(function(){
            if(!$(this).attr('id')){
                return false;
            }

            var tagName = this.tagName.toUpperCase();
            switch(tagName){
                case "SELECT":
                case "TEXTAREA":
                    return true;
                    break;

                case "INPUT":
                    var inputType = $(this).attr('type').toLowerCase();
                    switch(inputType){
                        case "checkbox":
                            return true;
                            break;
                        case "radio":
                            return true;
                            break;
                        case "text":
                            return true;
                            break;
                        }
                break;
            }
            return false;
        });

        targetObj.each(function(){
            $(this).nextAll('span#' +  _createSpanId(this, true) + '.outputSpan').first().remove();

            $('<span></span>').insertAfter(this)
                .attr('id',   _createSpanId(this))
                .attr('class', $(this).attr('class'))
                .addClass('outputSpan');

            _valueSync(this);

            $(this).visible(false);

            var tagName = this.tagName.toUpperCase();
            if(tagName == "INPUT"){
                var inputType = $(this).attr('type').toLowerCase();
                switch(inputType){
                  case "checkbox":
                      var thisId = $(this).attr('id');
                      if ($(this).nextAll('label[for='+ _selecterEscape(thisId) +']')[0]) {
                          $(this).nextAll('label[for='+ _selecterEscape(thisId) +']')[0].nextSibling.removeNode(true);
                      }
                      $(this)[0].nextSibling.nextSibling.removeNode(true);
                      break;
                  case "radio":
                      var thisId = $(this).attr('id');
                      $(this).nextAll('label[for='+ _selecterEscape(thisId) +']').visible(false);
                      $(this).nextAll('label[for='+ _selecterEscape(thisId) +']')[0].nextSibling.removeNode(true);
                      break;
                  case "text":
                      $(this).nextAll('input.codePopupButton').visible(false);
                      break;
                }
            }
        });

        targetObj.on('valueSync', function(){
            _valueSync(this);
        });
    });
}


function substrVal(val){
    return val.substring(val.indexOf(":") + 1);
}
