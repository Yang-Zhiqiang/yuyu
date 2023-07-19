$(function() {
  var REQUIRED_MARK = "※";

  $.fn.extend({
    required: function(required) {
      if (required) {
        if ($(this).find("span.requiredMark").length == 0) {
          $(this).append("<span class='requiredMark'>" + REQUIRED_MARK + "</span>");
        }
      } else {
        $(this).find("span.requiredMark").remove();
      }
      return this;
    }
  });

  $(".required").each(
    function() {
      $(this).required(true);
    }
  );

  $("input:file").keydown(
    function(e) {
      switch (e.keyCode) {
        case 8:
        case 27:
        case 46:
          $(this).replaceWith(
            $(this).clone(true)
          );
          break;
      }
    }
  );

  $("input[type='text']")
  .focus(
    function() {
    this.select();
  });

  $("input.zipFormat")
  .blur(
    function() {
  });

  $("input.seion,textarea.seion").blur(
    function() {
      $(this).val($(this).val().replace(/a/g,"A"));    $(this).val($(this).val().replace(/ａ/g,"Ａ"))
      $(this).val($(this).val().replace(/b/g,"B"));    $(this).val($(this).val().replace(/ｂ/g,"Ｂ"));
      $(this).val($(this).val().replace(/c/g,"C"));    $(this).val($(this).val().replace(/ｃ/g,"Ｃ"));
      $(this).val($(this).val().replace(/d/g,"D"));    $(this).val($(this).val().replace(/ｄ/g,"Ｄ"));
      $(this).val($(this).val().replace(/e/g,"E"));    $(this).val($(this).val().replace(/ｅ/g,"Ｅ"));
      $(this).val($(this).val().replace(/f/g,"F"));    $(this).val($(this).val().replace(/ｆ/g,"Ｆ"));
      $(this).val($(this).val().replace(/g/g,"G"));    $(this).val($(this).val().replace(/ｇ/g,"Ｇ"));
      $(this).val($(this).val().replace(/h/g,"H"));    $(this).val($(this).val().replace(/ｈ/g,"Ｈ"));
      $(this).val($(this).val().replace(/i/g,"I"));    $(this).val($(this).val().replace(/ｉ/g,"Ｉ"));
      $(this).val($(this).val().replace(/j/g,"J"));    $(this).val($(this).val().replace(/ｊ/g,"Ｊ"));
      $(this).val($(this).val().replace(/k/g,"K"));    $(this).val($(this).val().replace(/ｋ/g,"Ｋ"));
      $(this).val($(this).val().replace(/l/g,"L"));    $(this).val($(this).val().replace(/ｌ/g,"Ｌ"));
      $(this).val($(this).val().replace(/m/g,"M"));    $(this).val($(this).val().replace(/ｍ/g,"Ｍ"));
      $(this).val($(this).val().replace(/n/g,"N"));    $(this).val($(this).val().replace(/ｎ/g,"Ｎ"));
      $(this).val($(this).val().replace(/o/g,"O"));    $(this).val($(this).val().replace(/ｏ/g,"Ｏ"));
      $(this).val($(this).val().replace(/p/g,"P"));    $(this).val($(this).val().replace(/ｐ/g,"Ｐ"));
      $(this).val($(this).val().replace(/q/g,"Q"));    $(this).val($(this).val().replace(/ｑ/g,"Ｑ"));
      $(this).val($(this).val().replace(/r/g,"R"));    $(this).val($(this).val().replace(/ｒ/g,"Ｒ"));
      $(this).val($(this).val().replace(/s/g,"S"));    $(this).val($(this).val().replace(/ｓ/g,"Ｓ"));
      $(this).val($(this).val().replace(/t/g,"T"));    $(this).val($(this).val().replace(/ｔ/g,"Ｔ"));
      $(this).val($(this).val().replace(/u/g,"U"));    $(this).val($(this).val().replace(/ｕ/g,"Ｕ"));
      $(this).val($(this).val().replace(/v/g,"V"));    $(this).val($(this).val().replace(/ｖ/g,"Ｖ"));
      $(this).val($(this).val().replace(/w/g,"W"));    $(this).val($(this).val().replace(/ｗ/g,"Ｗ"));
      $(this).val($(this).val().replace(/x/g,"X"));    $(this).val($(this).val().replace(/ｘ/g,"Ｘ"));
      $(this).val($(this).val().replace(/y/g,"Y"));    $(this).val($(this).val().replace(/ｙ/g,"Ｙ"));
      $(this).val($(this).val().replace(/z/g,"Z"));    $(this).val($(this).val().replace(/ｚ/g,"Ｚ"));
      $(this).val($(this).val().replace(/ｦ/g,"ｵ"));    $(this).val($(this).val().replace(/ヲ/g,"オ"));
      $(this).val($(this).val().replace(/ｧ/g,"ｱ"));    $(this).val($(this).val().replace(/ァ/g,"ア"));
      $(this).val($(this).val().replace(/ｨ/g,"ｲ"));    $(this).val($(this).val().replace(/ィ/g,"イ"));
      $(this).val($(this).val().replace(/ｩ/g,"ｳ"));    $(this).val($(this).val().replace(/ゥ/g,"ウ"));
      $(this).val($(this).val().replace(/ｪ/g,"ｴ"));    $(this).val($(this).val().replace(/ェ/g,"エ"));
      $(this).val($(this).val().replace(/ｫ/g,"ｵ"));    $(this).val($(this).val().replace(/ォ/g,"オ"));
      $(this).val($(this).val().replace(/ｬ/g,"ﾔ"));    $(this).val($(this).val().replace(/ャ/g,"ヤ"));
      $(this).val($(this).val().replace(/ｭ/g,"ﾕ"));    $(this).val($(this).val().replace(/ュ/g,"ユ"));
      $(this).val($(this).val().replace(/ｮ/g,"ﾖ"));    $(this).val($(this).val().replace(/ョ/g,"ヨ"));
      $(this).val($(this).val().replace(/ｯ/g,"ﾂ"));    $(this).val($(this).val().replace(/ッ/g,"ツ"));
      $(this).val($(this).val().replace(/!/g," "));    $(this).val($(this).val().replace(/！/g,"　"));
      $(this).val($(this).val().replace(/\[/g," "));   $(this).val($(this).val().replace(/［/g,"　"));
      $(this).val($(this).val().replace(/\]/g," "));   $(this).val($(this).val().replace(/］/g,"　"));
      $(this).val($(this).val().replace(/\^/g," "));   $(this).val($(this).val().replace(/＾/g,"　"));
      $(this).val($(this).val().replace(/ｰ/g,"-"));    $(this).val($(this).val().replace(/ー/g,"－"));
      $(this).val($(this).val().replace(/`/g,"@"));    $(this).val($(this).val().replace(/｀/g,"＠"));
      $(this).val($(this).val().replace(/\{/g," "));   $(this).val($(this).val().replace(/｛/g,"　"));
      $(this).val($(this).val().replace(/\|/g,"\\"));  $(this).val($(this).val().replace(/｜/g,"￥"));
      $(this).val($(this).val().replace(/\}/g," "));   $(this).val($(this).val().replace(/｝/g,"　"));
      $(this).val($(this).val().replace(/~/g," "));    $(this).val($(this).val().replace(/￣/g,"　"));
  });

  $(".parentNoPadMargin").each(
    function() {
      $(this).parent().addClass("noPadMargin");
    });

  $(".parentBlockRight").each(
    function() {
      $(this).parent().addClass("blockRight");
    });

  $(".parentBlockLeft").each(
    function() {
      $(this).parent().addClass("blockLeft");
    });

  $(document).on("keypress", "input:not(.button,.ajaxButton,.closeButton,.ignoredSubmitButton"+
    ",.noValidationButton,.partSubmitButton,.codePopupButton,.modalPopupButton,.popupButton)",
    function(event) {
    return event.which !== 13;
  });
});

function openReport(methodName, target) {
  openWindow(methodName, target);
}

function fileDownLoad(methodName, target) {
  var url = "?_eventHandler=" + methodName;
  var swakCid = $("input:hidden[name='swak-cid']");
  if (swakCid.size()) {
    url += "&swak-cid=" + swakCid.val()
  }

  var iframe = document.getElementById("swak-hiddenIframe");
  if (iframe == undefined) {
    iframe = document.createElement("iframe");
    iframe.id = "swak-hiddenIframe";
    iframe.style.display = "none";
    document.body.appendChild(iframe);
  }
  iframe.src = url;
}

function openWindow(methodName, target){
  var url = "?_eventHandler=" + methodName;
  var swakCid = $("input:hidden[name='swak-cid']");
  if (swakCid.size()) {
    url += "&swak-cid=" + swakCid.val()
  }
  if (target == undefined) {
    target = "_blank";
  }
  var mode = getCookie(COOKIE_KEY_DUALMODE);
  if (mode == null || mode == "false") {
    open(url, target);
  } else {
    open(url, target, REPORT_WINDOW_FEATURES);
  }
}

function setCookie(key, value, maxAge, path) {
  var str = key + "=" + encodeURIComponent(value);
  if (maxAge !== undefined && maxAge !== null) {
    var expire = new Date();
    expire.setTime(expire.getTime() + maxAge * 1000);
    str += "; expires=" + expire.toUTCString() + "; max-age=" + maxAge;
  }
  if (path) {
    str += "; path=" + path;
  }
  document.cookie = str;
}

function getCookie(key) {
  var result = null;

  var cookieKey = key + '=';
  var allCookies = document.cookie;

  var position = allCookies.indexOf(cookieKey);
  if (position != -1) {
    var startIndex = position + cookieKey.length;

    var endIndex = allCookies.indexOf(';', startIndex);
    if (endIndex == -1) {
      endIndex = allCookies.length;
    }

    result = decodeURIComponent(allCookies.substring(startIndex, endIndex));
  }

  return result;
}

function deleteCookie(key) {
  var value = getCookie(key);
  if (value != null) {
    var expire = new Date();
    expire.setTime(expire.getTime() - 1000);
    document.cookie = key + "=" + encodeURIComponent(value) + "; expires="
        + expire.toUTCString() + "; max-age=0";
  }
}

function getFinalDay(year, month) {
  switch (month) {
  case 1:
  case 3:
  case 5:
  case 7:
  case 8:
  case 10:
  case 12:
    return 31;
  case 4:
  case 6:
  case 9:
  case 11:
    return 30;
  case 2:
    if (isLeapYear(year)) {
      return 29;
    }
    return 28;
  }
  function isLeapYear(year) {
    if (year % 4 != 0) {
      return false;
    }
    if (year % 100 != 0) {
      return true;
    }
    if (year % 400 != 0) {
      return false;
    }
    return true;
  }
}

function setDateSelectors(calender, yearKbn, monthKbn, dayKbn, startYear, endYear) {

  var dateTime = new Date();

  if (startYear == undefined) {
    startYear = 1901;
  }

  if (endYear == undefined) {
    endYear = dateTime.getFullYear();
  }

  $(calender).css('display', 'none');
  $(calender).datepicker();
  $(calender).datepicker("option", "minDate", new Date(startYear - 1, 12, 1));
  $(calender).datepicker("option", "maxDate", new Date(endYear, 12 - 1, 31));
  $(calender).datepicker("option", "showOn", 'button');
  $(calender).datepicker("option", "buttonImageOnly", true);
  $(calender).datepicker("option", "buttonImage",
      '../../../img/Datepicker.png');
  $(calender).bind("change", function() {
    setDatePulldown($(this).val(), yearKbn, monthKbn, dayKbn);
  });

  var year = $(yearKbn).val() == "" ? 0 : parseInt($(yearKbn).val());
  var month = parseInt($(monthKbn).val());
  var finalday = getFinalDay(year, month);

  setDayKbn(dayKbn, finalday);

  $(yearKbn).bind("change", function() {
    setDateHidden(calender, yearKbn, monthKbn, dayKbn);
  });
  $(monthKbn).bind("change", function() {
    setDateHidden(calender, yearKbn, monthKbn, dayKbn);
  });
  $(dayKbn).bind("change", function() {
    setDateHidden(calender, yearKbn, monthKbn, dayKbn);
  });

  if($(yearKbn).val() != ""){
    setCalenderValue(calender, $(yearKbn).val(), $(monthKbn).val(), $(dayKbn).val());
  }

  function setDatePulldown(date, yearKbn, monthKbn, dayKbn) {
    var dates = date.split('/');
    $(yearKbn).val(dates[0]);
    $(monthKbn).val(dates[1].substr(0, 1) == 0 ? dates[1].substr(1) : dates[1]);
    $(dayKbn).val(dates[2].substr(0, 1) == 0 ? dates[2].substr(1) : dates[2]);
  }

  function setDateHidden(calender, yearKbn, monthKbn, dayKbn) {

    var dates = $(calender).val().split('/');
    var year = $(yearKbn).val() == "" ? 0 : parseInt($(yearKbn).val());
    var month = parseInt($(monthKbn).val());
    var day = parseInt($(dayKbn).val());

    if ((year + month + day) == 0) {
      return;
    }

    if (year == 0)
      year = parseInt(dates[0]);
    if (month == 0)
      month = parseInt(dates[1].substr(0, 1) == 0 ? dates[1].substr(1) : dates[1]);

    var finalday = getFinalDay(year, month);

    setDayKbn(dayKbn, finalday);

    if (day == 0)
      day = parseInt(dates[2].substr(0, 1) == 0 ? dates[2].substr(1) : dates[2]);
      if (day > finalday) {
        day = finalday;
      }
    var newdate = year + "/" + month + "/" + day;
    $(calender).val(newdate);
  }

  function setDayKbn(dayKbn, finalday) {
    var dayKbnLength = $(dayKbn)[0].options.length;

    if (dayKbnLength < finalday + 1) {
      for (i = dayKbnLength; i < finalday + 1; i++) {
        var varItem = new Option(i + "日", i);
        $(dayKbn)[0].options.add(varItem)
      }
    }

    else if (dayKbnLength > finalday + 1) {
      for (i = 0; dayKbnLength - 1 - i > finalday; i++) {
        $(dayKbn)[0].options.remove(dayKbnLength - 1 - i);
      }
    }
  }

}

function setAroundPresentDateSelectors(calender, yearKbn, monthKbn, dayKbn, yearRange) {
  if (yearRange == undefined) {
    yearRange = 50;
  }
  setDateSelectors(calender, yearKbn, monthKbn, dayKbn, new Date().getFullYear() - yearRange, new Date().getFullYear() + yearRange);

  if($(yearKbn).val() == ""){
    setCalenderValue(calender, new Date.getFullYear());
  }
}

function setCalenderValue(calender, year, month, day) {

  var dateTime = new Date();

  if (month == undefined) {
  month = dateTime.getMonth() + 1;
  }
  if (day == undefined) {
  day = dateTime.getDate();
    var finalday = getFinalDay(year, month);
    if (day > finalday) {
      day = finalday;
    }
  }

  $(calender).val(year + "/" + month + "/" + day);
}

function setCalenderValueByBeforeYears(calender, beforeYears) {
  setCalenderValue(calender, new Date().getFullYear() - Number(beforeYears));
}

function formatPostalCd(selector) {
  $(selector).text(
    $(selector).text().replace(/(\d{3})\D*(.+)/, "$1-$2")
  );
}

function setDisabledGray(selector) {
  $(selector).attr("disabled", "true");
  $(selector).addClass("backgroundGray");
}

function removeDisabledGray(selector) {
  $(selector).removeAttr("disabled");
  $(selector).removeClass("backgroundGray");
}

function setPopupReturnValue(rtnVal) {
  if (parent !== null && parent.$("#_dialog").length > 0) {
    parent.$("#_dialog").dialog("option", "results", rtnVal);
    parent.$("#_dialog").dialog("close");
  }
}

function getRequiredMark() {
  var REQUIRED_MARK = "※";

  return "<span class='requiredMark'>" + REQUIRED_MARK + "</span>";
}
function dateFormat(dateStr, format, padding){

  if (padding == undefined) {
    padding = true;
  }

  var result = format;
  var f1;
  var f2;
  var rep;

  f1 = 'yyyy';
  f2 = 'y';
  if(result.indexOf(f1) > -1){
    rep = dateStr.slice(0,4);
    if(padding) {
      rep = zeroPadding(rep, 4);
    }
    result = result.replace(/yyyy/, rep);
  } else if(result.indexOf(f2) > -1){
    rep = dateStr.slice(0,4);
    rep = Number(dateStr.slice(0,4)).toString();
    result = result.replace(/y/, rep);
  }

  f1 = 'MM';
  f2 = 'M';
  if(result.indexOf(f1) > -1){
    rep = dateStr.slice(4,6);
    if(padding) {
      rep = zeroPadding(rep, 2);
    }
    result = result.replace(/MM/, rep);
  } else if(result.indexOf(f2) > -1){
    rep = Number(dateStr.slice(4,6)).toString();
    result = result.replace(/M/, rep);
  }

  f1 = 'dd';
  f2 = 'd';
  if(result.indexOf(f1) > -1){
    rep = dateStr.slice(6,8);
    if(padding) {
      rep = zeroPadding(rep, 2);
    }
    result = result.replace(/dd/, rep);
  } else if(result.indexOf(f2) > -1){
    rep = Number(dateStr.slice(6,8)).toString();
    result = result.replace(/d/, rep);
  }

  f1 = 'HH';
  f2 = 'H';
  if(result.indexOf(f1) > -1){
    rep = dateStr.slice(8,10);
    if(padding) {
      rep = zeroPadding(rep, 2);
    }
    result = result.replace(/HH/, rep);
  } else if(result.indexOf(f2) > -1){
    rep = Number(dateStr.slice(8,10)).toString();
    result = result.replace(/H/, rep);
  }

  f1 = 'mm';
  f2 = 'm';
  if(result.indexOf(f1) > -1){
    rep = dateStr.slice(10,12);
    if(padding) {
      rep = zeroPadding(rep, 2);
    }
    result = result.replace(/mm/, rep);
  } else if(result.indexOf(f2) > -1){
    rep = Number(dateStr.slice(10,12)).toString();
    result = result.replace(/m/, rep);
  }

  f1 = 'ss';
  f2 = 's';
  if(result.indexOf(f1) > -1){
    rep = dateStr.slice(12,14);
    if(padding) {
      rep = zeroPadding(rep, 2);
    }
    result = result.replace(/ss/, rep);
  } else if(result.indexOf(f2) > -1){
    rep = Number(dateStr.slice(12,14)).toString();
    result = result.replace(/s/, rep);
  }

  f1 = 'SSS';
  f2 = 'S';
  if(result.indexOf(f1) > -1){
    rep = dateStr.slice(14);
    if(padding) {
      rep = zeroPadding(rep, 3);
    }
    result = result.replace(/SSS/, rep);
  } else if(result.indexOf(f2) > -1){
    rep = Number(dateStr.slice(14)).toString();
    result = result.replace(/S/, rep);
  }
  return result;
}

function zeroPadding(value, length){
  var padding =  "000000000000000000000000000000000";

  return (padding.slice(0,length)+value).slice(0-length);
}

function getFormatNumberNames() {
    return [
    "integer"
    ,"number"
    ,"bizcurrency"
    ,"biznumber"];
  }

  function getFormatDateNames() {
    return [
    "dateYM_SEIREKI"
    ,"dateYM_WAREKI_INPUT"
    ,"dateYM_WAREKI_SYMBOL"
    ,"dateYM_WAREKI_KANJI"
    ,"dateYMD_SEIREKI"
    ,"dateYMD_WAREKI_INPUT"
    ,"dateYMD_WAREKI_SYMBOL"
    ,"dateYMD_WAREKI_KANJI"
    ,"dateMD"];
  }

function getFormat(formatName) {

      switch (formatName) {
      case "integer":
      case "biznumber":
          return "#,##0";
          break;
      case "number":
          return "#,##0.00";
          break;
      case "dateYM_SEIREKI":
          return "yyyy/MM";
          break;
      case "dateYM_WAREKI_INPUT":
          return "yy/MM";
          break;
      case "dateYM_WAREKI_SYMBOL":
          return "yy/MM";
          break;
      case "dateYM_WAREKI_KANJI":
          return "yy/MM";
          break;
      case "dateYMD_SEIREKI":
          return "yyyy/MM/dd";
          break
      case "dateYMD_WAREKI_INPUT":
          return "yy/MM/dd";
          break;
      case "dateYMD_WAREKI_SYMBOL":
          return "yy/MM/dd";
          break;
      case "dateYMD_WAREKI_KANJI":
          return "yy/MM/dd";
          break;
      case "dateMD":
          return "MM/dd";
          break;
      default:
          return "";;
      }
  }

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

function inputToOutput(selectObj){
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
                thisVal = $('<span></span>').text(thisVal).html();
                var outputVal = thisVal.replace(/\r\n/g, "<br />").replace(/\r/g, "<br />").replace(/\n/g, "<br />");
                targetSpan.html(outputVal);
                break;

            case "INPUT":
                var inputType = $(_this).attr('type').toLowerCase();
                switch(inputType){
                    case "checkbox":
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
                        targetSpan.text(outputVal);
                        break;
                }
                break;
        }
    }


    var targetObj = $(selectObj).filter(function(){
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
            if(inputType == "checkbox"){
                var thisId = $(this).attr('id');
                $(this).nextAll('label[for='+ _selecterEscape(thisId) +']').visible(false);
            }
        }
    });

    targetObj.on('valueSync', function(){
        _valueSync(this);
    });
}


function substrVal(val){
    return val.substring(val.indexOf(":") + 1);
}

function setReadOnlyGray(selector) {
  $(selector).attr("readonly", "true");
  $(selector).addClass("backgroundReadOnlyGray");
}

function removeReadOnlyGray(selector){
  $(selector).removeAttr("readonly");
  $(selector).removeClass("backgroundReadOnlyGray");
}
