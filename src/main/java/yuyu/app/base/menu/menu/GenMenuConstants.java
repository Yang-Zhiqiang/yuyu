package yuyu.app.base.menu.menu;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.configuration.Item.ErrorMsgKbn;

/**
 * メニュー 画面項目ID定義のベースクラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えてはいけません。
 */
public class GenMenuConstants {

    public static final int PAGENO_INIT          = 1;

    public static final int PAGENO_MENU          = 1;

    public static final int PAGENO_MYMENUTOUROKU = 2;

    static final String FORWARDNAME_INIT          = "init";

    static final String FORWARDNAME_MENU          = "menu";

    static final String FORWARDNAME_MYMENUTOUROKU = "myMenuTouroku";

    static final Item DDID_MYMENUCONTENTS_KINOUID = new Item("menu", "myMenuContents", "kinouId", null, ErrorMsgKbn.DD);

    static final Item DDID_MENUCONTENTS_COMMONCHECKBOX = new Item("menu", "menuContents", "commonCheckBox", null, ErrorMsgKbn.DD);

    static final Item DDID_MENUCONTENTS_SUBSYSTEMID = new Item("menu", "menuContents", "subSystemId", null, ErrorMsgKbn.DD);

    static final Item DDID_MENUCONTENTS_SUBSYSTEMNM = new Item("menu", "menuContents", "subSystemNm", null, ErrorMsgKbn.DD);

    static final Item DDID_MENUCONTENTS_CATEGORYID = new Item("menu", "menuContents", "categoryId", null, ErrorMsgKbn.DD);

    static final Item DDID_MENUCONTENTS_CATEGORYNM = new Item("menu", "menuContents", "categoryNm", null, ErrorMsgKbn.DD);

    static final Item DDID_MENUCONTENTS_KINOUID = new Item("menu", "menuContents", "kinouId", null, ErrorMsgKbn.DD);

    static final Item DDID_MENUCONTENTS_KINOUNM = new Item("menu", "menuContents", "kinouNm", null, ErrorMsgKbn.DD);

    static final Item DDID_MENUCONTENTS_JIKKOUPATH = new Item("menu", "menuContents", "jikkouPath", null, ErrorMsgKbn.DD);

    static final Item DDID_MENUFOOTERBUTTONS_TOJIRUBTN = new Item("menu", "menuFooterButtons", "tojiruBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_MYMENUTOUROKUBUTTONS_TORIKESIBTN = new Item("menu", "myMenuTourokuButtons", "torikesiBtn", null, ErrorMsgKbn.DD);
}
