package org.apache.jsp.WEB_002dINF.classes.yuyu.app.base.menu.menu;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*;
import static yuyu.app.base.menu.menu.MenuSelector.*;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.base.BaseUserInfo;
import yuyu.def.classification.C_KyokaKbn;
import yuyu.app.base.menu.menu.MenuConstants;

public final class menu_js_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\"><!--\r\n");
      out.write("$(function(){\r\n");
      out.write("\r\n");
      out.write("  ");
 boolean debug = false; 
      out.write("\r\n");
      out.write("\r\n");
      out.write("  var toggleSpeed = 200;\r\n");
      out.write("\r\n");
      out.write("  var myMenuTourokuButtons = $(");
      out.print( MYMENUTOUROKUBUTTONS );
      out.write(");\r\n");
      out.write("  var myMenuTourokuMode = (myMenuTourokuButtons.length > 0);\r\n");
      out.write("\r\n");
      out.write("  ");
 if (debug) { 
      out.write("\r\n");
      out.write("    function removeCssStyle(fileName, selector, style) {\r\n");
      out.write("      for (var i = 0; i < document.styleSheets.length; i++) {\r\n");
      out.write("        if (document.styleSheets[i].href.endsWith(\"/\" + fileName)) {\r\n");
      out.write("          var cssRules = document.styleSheets[i].cssRules;\r\n");
      out.write("          if (cssRules === undefined) { // for IE8\r\n");
      out.write("            break;                      // IE8 では rule.style.setProperty() できない\r\n");
      out.write("          }\r\n");
      out.write("          for (var j = 0; j < cssRules.length; j++) {\r\n");
      out.write("            var rule = cssRules[j];\r\n");
      out.write("            if (rule.selectorText == selector) {\r\n");
      out.write("              rule.style.setProperty(style, \"\");\r\n");
      out.write("              break;\r\n");
      out.write("            }\r\n");
      out.write("          }\r\n");
      out.write("          break;\r\n");
      out.write("        }\r\n");
      out.write("      }\r\n");
      out.write("    }\r\n");
      out.write("   ");
 } 
      out.write("\r\n");
      out.write("\r\n");
      out.write("  $(\"form\").wrapAll(\"<div class='mainContents'></div>\");\r\n");
      out.write("  var mainContents = $(\"div.mainContents\");\r\n");
      out.write("\r\n");
      out.write("  $(\"div.footer\").append($(");
      out.print( MENUFOOTERBUTTONS + DIV );
      out.write("));\r\n");
      out.write("\r\n");
      out.write("  var subSystems = {};\r\n");
      out.write("  var selectorRule;\r\n");
      out.write("  var myMenuItemsSelectorRule;\r\n");
      out.write("  var kinouIds = $(\"#menuContents span[id^='kinouId[']\");\r\n");
      out.write("  if (kinouIds.length > 0) {\r\n");
      out.write("    // #2685 対応前\r\n");
      out.write("    selectorRule = function(groupId, itemId, suffix, index) {\r\n");
      out.write("      return \"#\" + groupId + \" #\" + itemId + index.escape4jQueryIdSelector() + suffix;\r\n");
      out.write("    };\r\n");
      out.write("    myMenuItemsSelectorRule = \"#myMenuContents span[id^='kinouId[']\";\r\n");
      out.write("  } else {\r\n");
      out.write("    // #2685 対応後\r\n");
      out.write("    kinouIds = $(\"#menuContents span[id$='kinouId']\");\r\n");
      out.write("    selectorRule = function(groupId, itemId, suffix, index) {\r\n");
      out.write("      return \"#\" + groupId + (index + \".\").escape4jQueryIdSelector() + itemId + suffix;\r\n");
      out.write("    };\r\n");
      out.write("    myMenuItemsSelectorRule = \"#myMenuContents span[id$='kinouId']\";\r\n");
      out.write("  }\r\n");
      out.write("\r\n");
      out.write("  kinouIds.each( // menuContents の 機能Id 全エレメント に対し、以下を実行\r\n");
      out.write("    function(){\r\n");
      out.write("      var id          = this.id; // 機能Idエレメントの id\r\n");
      out.write("      var index       = id.substring(id.indexOf('['), id.indexOf(']') + 1);               // その配列添字部分\r\n");
      out.write("      var subSystemId = $(selectorRule(\"menuContents\", \"subSystemId\",    \"\",     index)); // サブシステムID <span>のjQueryオブジェクト\r\n");
      out.write("      var subSystemNm = $(selectorRule(\"menuContents\", \"subSystemNm\",    \"\",     index)); // サブシステム名 <span>のjQueryオブジェクト\r\n");
      out.write("      var categoryId  = $(selectorRule(\"menuContents\", \"categoryId\",     \"\",     index)); // カテゴリID <span>のjQueryオブジェクト\r\n");
      out.write("      var categoryNm  = $(selectorRule(\"menuContents\", \"categoryNm\",     \"\",     index)); // カテゴリ名 <span>のjQueryオブジェクト\r\n");
      out.write("      var kinouId     = $(selectorRule(\"menuContents\", \"kinouId\",        \"\",     index)); // 機能ID <span>タグの jQueryオブジェクト\r\n");
      out.write("      var kinouNmSpan = $(selectorRule(\"menuContents\", \"kinouNm\",        \"Span\", index)); // 機能名 popupLink の <span>タグの jQueryオブジェクト\r\n");
      out.write("      var kinouNm     = $(selectorRule(\"menuContents\", \"kinouNm\",        \"\",     index)); // 機能名 popupLink の <a>   タグの jQueryオブジェクト\r\n");
      out.write("      var kinouNmPath = $(selectorRule(\"menuContents\", \"kinouNm\",        \"Path\", index)); // 機能名 popupLink の popupPath の jQueryオブジェクト\r\n");
      out.write("      var checkBox    = $(selectorRule(\"menuContents\", \"commonCheckBox\", \"Span\", index)); // マイメニュー登録対象指定用チェックボックス のjQueryオブジェクト\r\n");
      out.write("\r\n");
      out.write("      // サブシステム・カテゴリ・機能・実行パス のマップ(JavaScriptObject)を作成\r\n");
      out.write("      var subSystem = subSystems[subSystemId.text()];\r\n");
      out.write("      if (subSystem == undefined) {\r\n");
      out.write("        subSystem = {\r\n");
      out.write("          subSystemNm: subSystemNm,\r\n");
      out.write("          categories:  {}\r\n");
      out.write("        };\r\n");
      out.write("        subSystems[subSystemId.text()] = subSystem;\r\n");
      out.write("      }\r\n");
      out.write("\r\n");
      out.write("      var category = subSystem.categories[categoryId.text()];\r\n");
      out.write("      if (category == undefined) {\r\n");
      out.write("        category = {\r\n");
      out.write("          categoryNm: categoryNm,\r\n");
      out.write("          kinous:     {}\r\n");
      out.write("        };\r\n");
      out.write("        subSystem.categories[categoryId.text()] = category;\r\n");
      out.write("      }\r\n");
      out.write("\r\n");
      out.write("      var kinou = category.kinous[kinouId.text()] = {\r\n");
      out.write("        kinouNm:    {\r\n");
      out.write("          span: kinouNmSpan,\r\n");
      out.write("          nm:   kinouNm,\r\n");
      out.write("          path: kinouNmPath\r\n");
      out.write("        },\r\n");
      out.write("        checkBox:   checkBox\r\n");
      out.write("      };\r\n");
      out.write("    }\r\n");
      out.write("  );\r\n");
      out.write("\r\n");
      out.write("  // 上記の 機能名.each() で構築したマップからメニューを再構築する\r\n");
      out.write("\r\n");
      out.write("  var menuContentsDiv = $(");
      out.print( MENUCONTENTS + DIV );
      out.write(");\r\n");
      out.write("  for (var subSystemId in subSystems) {\r\n");
      out.write("    var subSystem = subSystems[subSystemId];\r\n");
      out.write("    var subSystemTitle    = $(\"<h1></h1>\");\r\n");
      out.write("    var subSystemContents = $(\"<div></div>\");\r\n");
      out.write("    subSystemTitle.append(subSystem.subSystemNm);\r\n");
      out.write("    menuContentsDiv.append(subSystemTitle);\r\n");
      out.write("    subSystemTitle.click(\r\n");
      out.write("      function() {\r\n");
      out.write("        $(this).next().toggle(toggleSpeed);\r\n");
      out.write("      }\r\n");
      out.write("    );\r\n");
      out.write("\r\n");
      out.write("    for (var categoryId in subSystem.categories) {\r\n");
      out.write("      var category = subSystem.categories[categoryId];\r\n");
      out.write("      var categoryDiv      = $(\"<div></div>\");\r\n");
      out.write("      var categoryTitle    = $(\"<h2></h2>\");\r\n");
      out.write("      var categoryContents = $(\"<table class='kinous'></table>\");\r\n");
      out.write("      categoryTitle.append(category.categoryNm);\r\n");
      out.write("      categoryDiv.append(categoryTitle);\r\n");
      out.write("      categoryDiv.append(categoryContents);\r\n");
      out.write("      categoryTitle.click(\r\n");
      out.write("        function() {\r\n");
      out.write("          $(this).next().toggle(toggleSpeed);\r\n");
      out.write("        }\r\n");
      out.write("      );\r\n");
      out.write("\r\n");
      out.write("      var col = 0;\r\n");
      out.write("      for (var kinouId in category.kinous) {\r\n");
      out.write("        var kinou = category.kinous[kinouId];\r\n");
      out.write("        var td;\r\n");
      out.write("        if (col % 3 == 0) {\r\n");
      out.write("          var tr = $(\"<tr><td></td><td></td><td></td></tr>\");\r\n");
      out.write("          td = tr.find(\"td:first\");\r\n");
      out.write("          categoryContents.append(tr);\r\n");
      out.write("        } else {\r\n");
      out.write("          td = td.next();\r\n");
      out.write("        }\r\n");
      out.write("        td.addClass(\"kinou\");\r\n");
      out.write("\r\n");
      out.write("        var kinouTd;\r\n");
      out.write("        if (myMenuTourokuMode) {\r\n");
      out.write("          var innerTable = $(\"<table><tr><td class='check'></td><td></td></tr></table>\");\r\n");
      out.write("          var innerTd = innerTable.find(\"td:first\");\r\n");
      out.write("          innerTd.append(kinou.checkBox);\r\n");
      out.write("          td.append(innerTable);\r\n");
      out.write("          kinouTd = innerTd.next();\r\n");
      out.write("        } else {\r\n");
      out.write("          kinouTd = td;\r\n");
      out.write("        }\r\n");
      out.write("        kinouTd.append(\r\n");
      out.write("          kinou.kinouNm.span\r\n");
      out.write("        ).append(\r\n");
      out.write("          $(\"<span></span>\").html(kinou.kinouNm.nm.html())\r\n");
      out.write("        ).hover(\r\n");
      out.write("          function() {\r\n");
      out.write("            $(this).addClass(\"active\");\r\n");
      out.write("          },\r\n");
      out.write("          function() {\r\n");
      out.write("            $(this).removeClass(\"active\");\r\n");
      out.write("          }\r\n");
      out.write("        ).attr(\r\n");
      out.write("          \"id\", subSystemId + \".\" + categoryId + \".\" + kinouId\r\n");
      out.write("        ).click(\r\n");
      out.write("          myMenuTourokuMode ? function() {\r\n");
      out.write("            $(this).parent().closest(\"td\").find(\":checkbox\").click();\r\n");
      out.write("          } : function() {\r\n");
      out.write("            $(this).find(\"a:first\").triggerHandler(\"click\");\r\n");
      out.write("          }\r\n");
      out.write("        );\r\n");
      out.write("        col++;\r\n");
      out.write("      }\r\n");
      out.write("      subSystemContents.append(categoryDiv);\r\n");
      out.write("    }\r\n");
      out.write("    menuContentsDiv.append(subSystemContents);\r\n");
      out.write("  }\r\n");
      out.write("  menuContentsDiv.disableSelection();\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("  if (! myMenuTourokuMode) {\r\n");
      out.write("    var myMenuExists = ($(");
      out.print( MYMENUCONTENTS );
      out.write(").get(0).rows.length > 1);\r\n");
      out.write("    if (myMenuExists) {\r\n");
      out.write("      var myMenuContentsDiv = $(");
      out.print( MYMENUCONTENTS + DIV );
      out.write(");\r\n");
      out.write("      var myMenuTitle       = $(\"<h1></h1>\");\r\n");
      out.write("      var myMenuDiv         = $(\"<div></div>\");\r\n");
      out.write("      var myMenuContents    = $(\"<table class='kinous'></table>\");\r\n");
      out.write("\r\n");
      out.write("      myMenuTitle.append(\r\n");
      out.write("        $(");
      out.print( MYMENUCONTENTS + LABEL );
      out.write(")\r\n");
      out.write("      ).click(\r\n");
      out.write("        function() {\r\n");
      out.write("          $(this).next().toggle(toggleSpeed);\r\n");
      out.write("        }\r\n");
      out.write("      );\r\n");
      out.write("\r\n");
      out.write("      var myMenuItems = $(myMenuItemsSelectorRule);\r\n");
      out.write("      for (var i = 0; i < myMenuItems.length; i++) {\r\n");
      out.write("        var myMenuItem = $(myMenuItems[i]);\r\n");
      out.write("        if (i % 3 == 0) {\r\n");
      out.write("          var tr = $(\"<tr><td></td><td></td><td></td></tr>\");\r\n");
      out.write("          myMenuContents.append(tr);\r\n");
      out.write("        }\r\n");
      out.write("        var td = $(tr.find(\"td\")[i % 3]);\r\n");
      out.write("        td.replaceWith(\r\n");
      out.write("          $(\"#\" + myMenuItem.text().replace(/\\./g, \"\\\\.\"))\r\n");
      out.write("          .clone(true)\r\n");
      out.write("          .removeAttr(\"id\")\r\n");
      out.write("        );\r\n");
      out.write("        td.find(\"*\").removeAttr(\"id\");\r\n");
      out.write("      }\r\n");
      out.write("\r\n");
      out.write("      myMenuDiv.append(myMenuContents);\r\n");
      out.write("\r\n");
      out.write("      myMenuContentsDiv.append(myMenuTitle);\r\n");
      out.write("      myMenuContentsDiv.append(myMenuDiv);\r\n");
      out.write("\r\n");
      out.write("      ");
 if (debug) { 
      out.write("\r\n");
      out.write("        myMenuContentsDiv.append($(");
      out.print( MYMENUCONTENTS );
      out.write("));\r\n");
      out.write("        $(");
      out.print( MYMENUCONTENTS );
      out.write(").css(\"margin-top\", \"10px\");\r\n");
      out.write("        // debugモードの時は display: none; 属性を削除して myMenuContents のテーブルを表示\r\n");
      out.write("        removeCssStyle(\"menu.css\", ");
      out.print( MYMENUCONTENTS );
      out.write(", \"display\");\r\n");
      out.write("      ");
 } else { 
      out.write("\r\n");
      out.write("        $(");
      out.print( MYMENUCONTENTS );
      out.write(").remove();\r\n");
      out.write("      ");
 } 
      out.write("\r\n");
      out.write("    } else {\r\n");
      out.write("      $(");
      out.print( MYMENUCONTENTS + DIV );
      out.write(").remove();\r\n");
      out.write("    }\r\n");
      out.write("  }\r\n");
      out.write("\r\n");
      out.write("  ");
 if (debug) { 
      out.write("\r\n");
      out.write("    menuContentsDiv.append($(");
      out.print( MENUCONTENTS );
      out.write("));\r\n");
      out.write("    $(");
      out.print( MENUCONTENTS );
      out.write(").css(\"margin-top\", \"24px\");\r\n");
      out.write("    removeCssStyle(\"menu.css\", \"table.listItems\", \"display\");\r\n");
      out.write("    removeCssStyle(\"menu.css\", ");
      out.print( MENUCONTENTS );
      out.write(",   \"display\");\r\n");
      out.write("  ");
 } else { 
      out.write("\r\n");
      out.write("    $(");
      out.print( MENUCONTENTS );
      out.write(").remove();\r\n");
      out.write("  ");
 } 
      out.write("\r\n");
      out.write("  $(\"table.groupTitle\").remove();\r\n");
      out.write("\r\n");
      out.write("  $(window).resize(\r\n");
      out.write("    function() {\r\n");
      out.write("      var body = $(\"body\");\r\n");
      out.write("      var othersHeight = parseInt(body.css(\"padding-top\")) +\r\n");
      out.write("                         parseInt(body.css(\"padding-bottom\"));\r\n");
      out.write("      $(\"body > *:not(.mainContents)\").each(\r\n");
      out.write("        function() {\r\n");
      out.write("          othersHeight += $(this).outerHeight() + 1;\r\n");
      out.write("        }\r\n");
      out.write("      );\r\n");
      out.write("      mainContents.height($(window).height() - othersHeight - 1);\r\n");
      out.write("    }\r\n");
      out.write("  );\r\n");
      out.write("  $(window).resize();\r\n");
      out.write("\r\n");
      out.write("  // 2画面モード切り替えリンクの追加\r\n");
      out.write("  $(\"#myMenuTourokuBtnSpan\").after(\"<span style='float: right; line-height: 25px;'><a class='dualLink'>2画面化(無効中)</a></span>\");\r\n");
      out.write("\r\n");
      out.write("  $(\".dualLink\").click(function() {\r\n");
      out.write("    if ($(this).text() == \"２画面化（有効中）\") {\r\n");
      out.write("      setDualMode(false);\r\n");
      out.write("    } else {\r\n");
      out.write("      setDualMode(true);\r\n");
      out.write("    }\r\n");
      out.write("  });\r\n");
      out.write("\r\n");
      out.write("  setDualMode = function(mode) {\r\n");
      out.write("    var control = $(\".dualLink\");\r\n");
      out.write("    if (mode) {\r\n");
      out.write("      control.text(\"２画面化（有効中）\");\r\n");
      out.write("    } else {\r\n");
      out.write("      control.text(\"２画面化（無効中）\");\r\n");
      out.write("    }\r\n");
      out.write("    setCookie(COOKIE_KEY_DUALMODE, mode, null, \"/\");\r\n");
      out.write("  };\r\n");
      out.write("\r\n");
      out.write("  // 2画面モード切り替えリンクの初期表示設定\r\n");
      out.write("  setDualMode(true);\r\n");
      out.write("\r\n");
      out.write("});\r\n");
      out.write("//-->\r\n");
      out.write("</script>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
