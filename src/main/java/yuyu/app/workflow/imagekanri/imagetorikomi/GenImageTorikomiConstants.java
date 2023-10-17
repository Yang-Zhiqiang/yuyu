package yuyu.app.workflow.imagekanri.imagetorikomi;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.configuration.Item.ErrorMsgKbn;

/**
 * イメージ取込 画面項目ID定義のベースクラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えてはいけません。
 */
public class GenImageTorikomiConstants {

    public static final int PAGENO_INIT           = 1;

    public static final int PAGENO_SELECTDATA     = 1;

    public static final int PAGENO_INPUTCONDITION = 2;

    public static final int PAGENO_CONFIRM        = 3;

    public static final int PAGENO_RESULT         = 4;

    static final String FORWARDNAME_INIT           = "init";

    static final String FORWARDNAME_CURRENT        = "current";

    static final String FORWARDNAME_SELECTDATA     = "SelectData";

    static final String FORWARDNAME_INPUTCONDITION = "InputCondition";

    static final String FORWARDNAME_CONFIRM        = "Confirm";

    static final String FORWARDNAME_RESULT         = "Result";

    static final Item DDID_HEADERBUTTONS_TOJIRUBTN = new Item("imagetorikomi", "headerButtons", "tojiruBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_SEARCHINFO_SUBSYSTEMID = new Item("imagetorikomi", "searchInfo", "subSystemId", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHINFO_JIMUTETUZUKICD = new Item("imagetorikomi", "searchInfo", "jimutetuzukicd", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHINFO_SYONO = new Item("imagetorikomi", "searchInfo", "syono", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHINFO_NKSYSYNO = new Item("imagetorikomi", "searchInfo", "nksysyno", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHINFO_SRCHJIMUSTARTYMDFROM = new Item("imagetorikomi", "searchInfo", "srchjimustartymdfrom", null, ErrorMsgKbn.ERROR);

    static final Item DDID_SEARCHINFO_SRCHJIMUSTARTYMDTO = new Item("imagetorikomi", "searchInfo", "srchjimustartymdto", null, ErrorMsgKbn.ERROR);

    static final Item DDID_SEARCHINFO_KOUTEIKANRISTATUS = new Item("imagetorikomi", "searchInfo", "kouteikanristatus", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHINFO_JIMUYOUCD = new Item("imagetorikomi", "searchInfo", "jimuyoucd", null, ErrorMsgKbn.DISP);

    static final Item DDID_ANKENLIST_DISPGYOUMUKEY = new Item("imagetorikomi", "ankenList", "dispGyoumuKey", null, ErrorMsgKbn.DD);

    static final Item DDID_ANKENLIST_DISPJIMUSTARTYMD = new Item("imagetorikomi", "ankenList", "dispjimustartymd", null, ErrorMsgKbn.DISP);

    static final Item DDID_ANKENLIST_DISPKOUTEIKAISIYMD = new Item("imagetorikomi", "ankenList", "dispkouteikaisiymd", null, ErrorMsgKbn.DISP);

    static final Item DDID_ANKENLIST_DISPKOUTEIKANRISTATUS = new Item("imagetorikomi", "ankenList", "dispkouteikanristatus", null, ErrorMsgKbn.DISP);

    static final Item DDID_ANKENLIST_DISPTASKNM = new Item("imagetorikomi", "ankenList", "disptasknm", null, ErrorMsgKbn.DISP);

    static final Item DDID_ANKENLIST_JIMUYOUCD = new Item("imagetorikomi", "ankenList", "jimuyoucd", null, ErrorMsgKbn.DISP);

    static final Item DDID_ANKENLIST_DISPTANTOUNM = new Item("imagetorikomi", "ankenList", "disptantounm", null, ErrorMsgKbn.DISP);

    static final Item DDID_ANKENLIST_SYOUSAILINK = new Item("imagetorikomi", "ankenList", "syousaiLink", null, ErrorMsgKbn.DD);

    static final Item DDID_ANKENLIST2_DISPGYOUMUKEY = new Item("imagetorikomi", "ankenList2", "dispGyoumuKey", null, ErrorMsgKbn.DD);

    static final Item DDID_ANKENLIST2_DISPJIMUSTARTYMD = new Item("imagetorikomi", "ankenList2", "dispjimustartymd", null, ErrorMsgKbn.DISP);

    static final Item DDID_ANKENLIST2_DISPKOUTEIKAISIYMD = new Item("imagetorikomi", "ankenList2", "dispkouteikaisiymd", null, ErrorMsgKbn.DISP);

    static final Item DDID_ANKENLIST2_DISPKOUTEIKANRISTATUS = new Item("imagetorikomi", "ankenList2", "dispkouteikanristatus", null, ErrorMsgKbn.DISP);

    static final Item DDID_ANKENLIST2_DISPTASKNM = new Item("imagetorikomi", "ankenList2", "disptasknm", null, ErrorMsgKbn.DISP);

    static final Item DDID_ANKENLIST2_JIMUYOUCD = new Item("imagetorikomi", "ankenList2", "jimuyoucd", null, ErrorMsgKbn.DISP);

    static final Item DDID_ANKENLIST2_DISPTANTOUNM = new Item("imagetorikomi", "ankenList2", "disptantounm", null, ErrorMsgKbn.DISP);

    static final Item DDID_ANKENLIST2_SYOUSAILINK = new Item("imagetorikomi", "ankenList2", "syousaiLink", null, ErrorMsgKbn.DD);

    static final Item DDID_SYORUIINFO01_DISPSYORUINM = new Item("imagetorikomi", "syoruiInfo01", "dispsyoruinm", null, ErrorMsgKbn.DISP);

    static final Item DDID_SYORUIINFO01_SYORUITTYKYMDTIME = new Item("imagetorikomi", "syoruiInfo01", "syoruittykymdtime", null, ErrorMsgKbn.DISP);

    static final Item DDID_SYORUIINFO01_USERNM = new Item("imagetorikomi", "syoruiInfo01", "userNm", null, ErrorMsgKbn.DISP);

    static final Item DDID_SYORUIINFO01_HYOUJILINK = new Item("imagetorikomi", "syoruiInfo01", "hyoujilink", null, ErrorMsgKbn.DD);

    static final Item DDID_SYORUIINFO01_TORIKOMILINK = new Item("imagetorikomi", "syoruiInfo01", "torikomiLink", null, ErrorMsgKbn.DD);

    static final Item DDID_SYORUIINFO02_DISPSYORUINM = new Item("imagetorikomi", "syoruiInfo02", "dispsyoruinm", null, ErrorMsgKbn.DISP);

    static final Item DDID_SYORUIINFO02_FILENM = new Item("imagetorikomi", "syoruiInfo02", "fileNm", null, ErrorMsgKbn.DISP);

    static final Item DDID_BUTTONINPUTCONTENTS_MODORUBTNBYINPUTCONDITION = new Item("imagetorikomi", "buttonInputContents", "modoruBtnByInputCondition", null, ErrorMsgKbn.DD);

    static final Item DDID_BUTTONINPUTCONTENTS_MODORUBTNBYCONFIRM = new Item("imagetorikomi", "buttonInputContents", "modoruBtnByConfirm", null, ErrorMsgKbn.DD);

    static final Item DDID_HIDDENINFO_SELECTINDEX = new Item("imagetorikomi", "hiddeninfo", "selectindex", null, ErrorMsgKbn.DD);

    static final Item DDID_HIDDENINFO_TYOUHYOUSYUTURYOKULINK = new Item("imagetorikomi", "hiddeninfo", "tyouhyouSyuturyokuLink", null, ErrorMsgKbn.DD);
}
