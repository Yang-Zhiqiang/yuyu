package yuyu.app.siharai.sisonota.simakesyorui;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.configuration.Item.ErrorMsgKbn;

/**
 * 保険金給付金書類作成 画面項目ID定義のベースクラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えてはいけません。
 */
public class GenSiMakeSyoruiConstants {

    public static final int PAGENO_INIT        = 1;

    public static final int PAGENO_SELECTDATA  = 1;

    public static final int PAGENO_INPUTSYORUI = 2;

    public static final int PAGENO_CONFIRM     = 3;

    public static final int PAGENO_RESULT      = 4;

    static final String FORWARDNAME_INIT        = "init";

    static final String FORWARDNAME_SELECTDATA  = "SelectData";

    static final String FORWARDNAME_INPUTSYORUI = "InputSyorui";

    static final String FORWARDNAME_CONFIRM     = "Confirm";

    static final String FORWARDNAME_RESULT      = "Result";

    static final Item DDID_HEADERBUTTONS_TOJIRUBTN = new Item("simakesyorui", "headerButtons", "tojiruBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_SEARCHINFO_SYONO = new Item("simakesyorui", "searchInfo", "syono", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHINFO_SEIKYUUSYUBETU = new Item("simakesyorui", "searchInfo", "seikyuusyubetu", null, ErrorMsgKbn.DISP);

    static final Item DDID_ANKENSEARCHRESULTLIST_DISPJIMUTETUZUKINM = new Item("simakesyorui", "ankenSearchResultList", "dispjimutetuzukinm", null, ErrorMsgKbn.DISP);

    static final Item DDID_ANKENSEARCHRESULTLIST_DISPKOUTEIKANRISTATUS = new Item("simakesyorui", "ankenSearchResultList", "dispkouteikanristatus", null, ErrorMsgKbn.DISP);

    static final Item DDID_ANKENSEARCHRESULTLIST_DISPKOUTEIKAISIYMD = new Item("simakesyorui", "ankenSearchResultList", "dispkouteikaisiymd", null, ErrorMsgKbn.DISP);

    static final Item DDID_ANKENSEARCHRESULTLIST_DISPJIMUSTARTYMD = new Item("simakesyorui", "ankenSearchResultList", "dispjimustartymd", null, ErrorMsgKbn.DISP);

    static final Item DDID_ANKENSEARCHRESULTLIST_DISPKOUTEIKANYMD = new Item("simakesyorui", "ankenSearchResultList", "dispkouteikanymd", null, ErrorMsgKbn.DISP);

    static final Item DDID_ANKENSEARCHRESULTLIST_SYORUISAKUSEILINK = new Item("simakesyorui", "ankenSearchResultList", "syoruisakuseilink", null, ErrorMsgKbn.DD);

    static final Item DDID_SAKUSEITAISYOUANKENLIST_DISPJIMUTETUZUKINM = new Item("simakesyorui", "sakuseiTaisyouAnkenList", "dispjimutetuzukinm", null, ErrorMsgKbn.DISP);

    static final Item DDID_SAKUSEITAISYOUANKENLIST_DISPKOUTEIKANRISTATUS = new Item("simakesyorui", "sakuseiTaisyouAnkenList", "dispkouteikanristatus", null, ErrorMsgKbn.DISP);

    static final Item DDID_SAKUSEITAISYOUANKENLIST_DISPKOUTEIKAISIYMD = new Item("simakesyorui", "sakuseiTaisyouAnkenList", "dispkouteikaisiymd", null, ErrorMsgKbn.DISP);

    static final Item DDID_SAKUSEITAISYOUANKENLIST_DISPJIMUSTARTYMD = new Item("simakesyorui", "sakuseiTaisyouAnkenList", "dispjimustartymd", null, ErrorMsgKbn.DISP);

    static final Item DDID_SAKUSEITAISYOUANKENLIST_DISPKOUTEIKANYMD = new Item("simakesyorui", "sakuseiTaisyouAnkenList", "dispkouteikanymd", null, ErrorMsgKbn.DISP);

    static final Item DDID_SAKUSEITAISYOUANKENLIST_SYORUISAKUSEILINK = new Item("simakesyorui", "sakuseiTaisyouAnkenList", "syoruisakuseilink", null, ErrorMsgKbn.DD);

    static final Item DDID_SYORUIINFO_SISYORUISAKUSEIKBN = new Item("simakesyorui", "syoruiInfo", "sisyoruisakuseikbn", null, ErrorMsgKbn.ERROR);

    static final Item DDID_BUTTONINPUTCONTENTS_MODORUBTNBYINPUTSYORUI = new Item("simakesyorui", "buttonInputContents", "modorubtnbyinputsyorui", null, ErrorMsgKbn.DD);

    static final Item DDID_BUTTONINPUTCONTENTS_MODORUBTNBYCONFIRM = new Item("simakesyorui", "buttonInputContents", "modoruBtnByConfirm", null, ErrorMsgKbn.DD);
}
