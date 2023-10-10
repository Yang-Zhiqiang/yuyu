<%--
    menu.js.jsp - メニュー JavaScript(JSP)
--%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.app.base.menu.menu.MenuSelector.*"%>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector"%>
<%@page import="yuyu.common.base.BaseUserInfo"%>
<%@page import="yuyu.def.classification.C_KyokaKbn"%>
<%@page import="yuyu.app.base.menu.menu.MenuConstants"%>
<script type="text/javascript"><!--
$(function(){

  <% boolean debug = false; %>

  var toggleSpeed = 200;

  var myMenuTourokuButtons = $(<%= MYMENUTOUROKUBUTTONS %>);
  var myMenuTourokuMode = (myMenuTourokuButtons.length > 0);

  <% if (debug) { %>
    function removeCssStyle(fileName, selector, style) {
      for (var i = 0; i < document.styleSheets.length; i++) {
        if (document.styleSheets[i].href.endsWith("/" + fileName)) {
          var cssRules = document.styleSheets[i].cssRules;
          if (cssRules === undefined) {
            break;
          }
          for (var j = 0; j < cssRules.length; j++) {
            var rule = cssRules[j];
            if (rule.selectorText == selector) {
              rule.style.setProperty(style, "");
              break;
            }
          }
          break;
        }
      }
    }
   <% } %>

  $("form").wrapAll("<div class='mainContents'></div>");
  var mainContents = $("div.mainContents");

  $("div.footer").append($(<%= MENUFOOTERBUTTONS + DIV %>));

  var subSystems = {};
  var selectorRule;
  var myMenuItemsSelectorRule;
  var kinouIds = $("#menuContents span[id^='kinouId[']");
  if (kinouIds.length > 0) {
    selectorRule = function(groupId, itemId, suffix, index) {
      return "#" + groupId + " #" + itemId + index.escape4jQueryIdSelector() + suffix;
    };
    myMenuItemsSelectorRule = "#myMenuContents span[id^='kinouId[']";
  } else {
    kinouIds = $("#menuContents span[id$='kinouId']");
    selectorRule = function(groupId, itemId, suffix, index) {
      return "#" + groupId + (index + ".").escape4jQueryIdSelector() + itemId + suffix;
    };
    myMenuItemsSelectorRule = "#myMenuContents span[id$='kinouId']";
  }

  kinouIds.each(
    function(){
      var id          = this.id;
      var index       = id.substring(id.indexOf('['), id.indexOf(']') + 1);
      var subSystemId = $(selectorRule("menuContents", "subSystemId",    "",     index));
      var subSystemNm = $(selectorRule("menuContents", "subSystemNm",    "",     index));
      var categoryId  = $(selectorRule("menuContents", "categoryId",     "",     index));
      var categoryNm  = $(selectorRule("menuContents", "categoryNm",     "",     index));
      var kinouId     = $(selectorRule("menuContents", "kinouId",        "",     index));
      var kinouNmSpan = $(selectorRule("menuContents", "kinouNm",        "Span", index));
      var kinouNm     = $(selectorRule("menuContents", "kinouNm",        "",     index));
      var kinouNmPath = $(selectorRule("menuContents", "kinouNm",        "Path", index));
      var checkBox    = $(selectorRule("menuContents", "commonCheckBox", "Span", index));

      var subSystem = subSystems[subSystemId.text()];
      if (subSystem == undefined) {
        subSystem = {
          subSystemNm: subSystemNm,
          categories:  {}
        };
        subSystems[subSystemId.text()] = subSystem;
      }

      var category = subSystem.categories[categoryId.text()];
      if (category == undefined) {
        category = {
          categoryNm: categoryNm,
          kinous:     {}
        };
        subSystem.categories[categoryId.text()] = category;
      }

      var kinou = category.kinous[kinouId.text()] = {
        kinouNm:    {
          span: kinouNmSpan,
          nm:   kinouNm,
          path: kinouNmPath
        },
        checkBox:   checkBox
      };
    }
  );


  var menuContentsDiv = $(<%= MENUCONTENTS + DIV %>);
  for (var subSystemId in subSystems) {
    var subSystem = subSystems[subSystemId];
    var subSystemTitle    = $("<h1></h1>");
    var subSystemContents = $("<div></div>");
    subSystemTitle.append(subSystem.subSystemNm);
    menuContentsDiv.append(subSystemTitle);
    subSystemTitle.click(
      function() {
        $(this).next().toggle(toggleSpeed);
      }
    );

    for (var categoryId in subSystem.categories) {
      var category = subSystem.categories[categoryId];
      var categoryDiv      = $("<div></div>");
      var categoryTitle    = $("<h2></h2>");
      var categoryContents = $("<table class='kinous'></table>");
      categoryTitle.append(category.categoryNm);
      categoryDiv.append(categoryTitle);
      categoryDiv.append(categoryContents);
      categoryTitle.click(
        function() {
          $(this).next().toggle(toggleSpeed);
        }
      );

      var col = 0;
      for (var kinouId in category.kinous) {
        var kinou = category.kinous[kinouId];
        var td;
        if (col % 3 == 0) {
          var tr = $("<tr><td></td><td></td><td></td></tr>");
          td = tr.find("td:first");
          categoryContents.append(tr);
        } else {
          td = td.next();
        }
        td.addClass("kinou");

        var kinouTd;
        if (myMenuTourokuMode) {
          var innerTable = $("<table><tr><td class='check'></td><td></td></tr></table>");
          var innerTd = innerTable.find("td:first");
          innerTd.append(kinou.checkBox);
          td.append(innerTable);
          kinouTd = innerTd.next();
        } else {
          kinouTd = td;
        }
        kinouTd.append(
          kinou.kinouNm.span
        ).append(
          $("<span></span>").html(kinou.kinouNm.nm.html())
        ).hover(
          function() {
            $(this).addClass("active");
          },
          function() {
            $(this).removeClass("active");
          }
        ).attr(
          "id", subSystemId + "." + categoryId + "." + kinouId
        ).click(
          myMenuTourokuMode ? function() {
            $(this).parent().closest("td").find(":checkbox").click();
          } : function() {
            $(this).find("a:first").triggerHandler("click");
          }
        );
        col++;
      }
      subSystemContents.append(categoryDiv);
    }
    menuContentsDiv.append(subSystemContents);
  }
  menuContentsDiv.disableSelection();


  if (! myMenuTourokuMode) {
    var myMenuExists = ($(<%= MYMENUCONTENTS %>).get(0).rows.length > 1);
    if (myMenuExists) {
      var myMenuContentsDiv = $(<%= MYMENUCONTENTS + DIV %>);
      var myMenuTitle       = $("<h1></h1>");
      var myMenuDiv         = $("<div></div>");
      var myMenuContents    = $("<table class='kinous'></table>");

      myMenuTitle.append(
        $(<%= MYMENUCONTENTS + LABEL %>)
      ).click(
        function() {
          $(this).next().toggle(toggleSpeed);
        }
      );

      var myMenuItems = $(myMenuItemsSelectorRule);
      for (var i = 0; i < myMenuItems.length; i++) {
        var myMenuItem = $(myMenuItems[i]);
        if (i % 3 == 0) {
          var tr = $("<tr><td></td><td></td><td></td></tr>");
          myMenuContents.append(tr);
        }
        var td = $(tr.find("td")[i % 3]);
        td.replaceWith(
          $("#" + myMenuItem.text().replace(/\./g, "\\."))
          .clone(true)
          .removeAttr("id")
        );
        td.find("*").removeAttr("id");
      }

      myMenuDiv.append(myMenuContents);

      myMenuContentsDiv.append(myMenuTitle);
      myMenuContentsDiv.append(myMenuDiv);

      <% if (debug) { %>
        myMenuContentsDiv.append($(<%= MYMENUCONTENTS %>));
        $(<%= MYMENUCONTENTS %>).css("margin-top", "10px");
        removeCssStyle("menu.css", <%= MYMENUCONTENTS %>, "display");
      <% } else { %>
        $(<%= MYMENUCONTENTS %>).remove();
      <% } %>
    } else {
      $(<%= MYMENUCONTENTS + DIV %>).remove();
    }
  }

  <% if (debug) { %>
    menuContentsDiv.append($(<%= MENUCONTENTS %>));
    $(<%= MENUCONTENTS %>).css("margin-top", "24px");
    removeCssStyle("menu.css", "table.listItems", "display");
    removeCssStyle("menu.css", <%= MENUCONTENTS %>,   "display");
  <% } else { %>
    $(<%= MENUCONTENTS %>).remove();
  <% } %>
  $("table.groupTitle").remove();

  $(window).resize(
    function() {
      var body = $("body");
      var othersHeight = parseInt(body.css("padding-top")) +
                         parseInt(body.css("padding-bottom"));
      $("body > *:not(.mainContents)").each(
        function() {
          othersHeight += $(this).outerHeight() + 1;
        }
      );
      mainContents.height($(window).height() - othersHeight - 1);
    }
  );
  $(window).resize();

  $("#myMenuTourokuBtnSpan").after("<span style='float: right; line-height: 25px;'><a class='dualLink'>2画面化(無効中)</a></span>");

  $(".dualLink").click(function() {
    if ($(this).text() == "２画面化（有効中）") {
      setDualMode(false);
    } else {
      setDualMode(true);
    }
  });

  setDualMode = function(mode) {
    var control = $(".dualLink");
    if (mode) {
      control.text("２画面化（有効中）");
    } else {
      control.text("２画面化（無効中）");
    }
    setCookie(COOKIE_KEY_DUALMODE, mode, null, "/");
  };

  setDualMode(true);

});
//-->
</script>
