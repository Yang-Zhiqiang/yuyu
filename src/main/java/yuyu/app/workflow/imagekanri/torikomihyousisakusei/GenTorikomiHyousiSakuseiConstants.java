package yuyu.app.workflow.imagekanri.torikomihyousisakusei;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.configuration.Item.ErrorMsgKbn;

/**
 * 取込用表紙作成 画面項目ID定義のベースクラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えてはいけません。
 */
public class GenTorikomiHyousiSakuseiConstants {

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

    static final Item DDID_HEADERBUTTONS_TOJIRUBTN = new Item("torikomihyousisakusei", "headerButtons", "tojiruBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_SEARCHINFO_SUBSYSTEMID = new Item("torikomihyousisakusei", "searchInfo", "subSystemId", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHINFO_JIMUTETUZUKICD = new Item("torikomihyousisakusei", "searchInfo", "jimutetuzukicd", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHINFO_MOSNO = new Item("torikomihyousisakusei", "searchInfo", "mosno", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHINFO_SYONO = new Item("torikomihyousisakusei", "searchInfo", "syono", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHINFO_NKSYSYNO = new Item("torikomihyousisakusei", "searchInfo", "nksysyno", null, ErrorMsgKbn.DISP);

    static final Item DDID_ANKENLIST_DISPJIMUTETUZUKINM = new Item("torikomihyousisakusei", "ankenList", "dispjimutetuzukinm", null, ErrorMsgKbn.DISP);

    static final Item DDID_ANKENLIST_DISPKOUTEIKANRISTATUS = new Item("torikomihyousisakusei", "ankenList", "dispkouteikanristatus", null, ErrorMsgKbn.DISP);

    static final Item DDID_ANKENLIST_DISPKOUTEIKAISIYMD = new Item("torikomihyousisakusei", "ankenList", "dispkouteikaisiymd", null, ErrorMsgKbn.DISP);

    static final Item DDID_ANKENLIST_DISPJIMUSTARTYMD = new Item("torikomihyousisakusei", "ankenList", "dispjimustartymd", null, ErrorMsgKbn.DISP);

    static final Item DDID_ANKENLIST_DISPKOUTEIKANYMD = new Item("torikomihyousisakusei", "ankenList", "dispkouteikanymd", null, ErrorMsgKbn.DISP);

    static final Item DDID_ANKENLIST_SAKUSEILINK = new Item("torikomihyousisakusei", "ankenList", "sakuseiLink", null, ErrorMsgKbn.DD);

    static final Item DDID_ANKENLIST2_DISPJIMUTETUZUKINM = new Item("torikomihyousisakusei", "ankenList2", "dispjimutetuzukinm", null, ErrorMsgKbn.DISP);

    static final Item DDID_ANKENLIST2_DISPKOUTEIKANRISTATUS = new Item("torikomihyousisakusei", "ankenList2", "dispkouteikanristatus", null, ErrorMsgKbn.DISP);

    static final Item DDID_ANKENLIST2_DISPKOUTEIKAISIYMD = new Item("torikomihyousisakusei", "ankenList2", "dispkouteikaisiymd", null, ErrorMsgKbn.DISP);

    static final Item DDID_ANKENLIST2_DISPJIMUSTARTYMD = new Item("torikomihyousisakusei", "ankenList2", "dispjimustartymd", null, ErrorMsgKbn.DISP);

    static final Item DDID_ANKENLIST2_DISPKOUTEIKANYMD = new Item("torikomihyousisakusei", "ankenList2", "dispkouteikanymd", null, ErrorMsgKbn.DISP);

    static final Item DDID_ANKENLIST2_SAKUSEILINK = new Item("torikomihyousisakusei", "ankenList2", "sakuseiLink", null, ErrorMsgKbn.DD);

    static final Item DDID_SYORUIINFO_TORIKOMISYORUICD = new Item("torikomihyousisakusei", "syoruiInfo", "torikomiSyoruiCd", null, ErrorMsgKbn.ERROR);

    static final Item DDID_BUTTONINPUTCONTENTS_MODORUBTNBYINPUTCONDITION = new Item("torikomihyousisakusei", "buttonInputContents", "modoruBtnByInputCondition", null, ErrorMsgKbn.DD);

    static final Item DDID_BUTTONINPUTCONTENTS_MODORUBTNBYCONFIRM = new Item("torikomihyousisakusei", "buttonInputContents", "modoruBtnByConfirm", null, ErrorMsgKbn.DD);
}
