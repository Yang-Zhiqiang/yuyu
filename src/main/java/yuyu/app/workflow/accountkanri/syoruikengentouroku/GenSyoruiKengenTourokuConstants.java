package yuyu.app.workflow.accountkanri.syoruikengentouroku;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.configuration.Item.ErrorMsgKbn;

/**
 * 書類権限登録 画面項目ID定義のベースクラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えてはいけません。
 */
public class GenSyoruiKengenTourokuConstants {

    public static final int PAGENO_INIT          = 1;

    public static final int PAGENO_INPUTKEY      = 1;

    public static final int PAGENO_INPUTCONTENTS = 2;

    public static final int PAGENO_CONFIRM       = 3;

    public static final int PAGENO_RESULT        = 4;

    static final String FORWARDNAME_INIT          = "init";

    static final String FORWARDNAME_INPUTKEY      = "InputKey";

    static final String FORWARDNAME_INPUTCONTENTS = "InputContents";

    static final String FORWARDNAME_CONFIRM       = "Confirm";

    static final String FORWARDNAME_RESULT        = "Result";

    static final Item DDID_HEADERBUTTONS_TOJIRUBTN = new Item("syoruikengentouroku", "headerButtons", "tojiruBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_SEARCHKEYINPUT_ROLECD = new Item("syoruikengentouroku", "SearchKeyInput", "roleCd", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHKEYINPUT_SUBSYSTEMID = new Item("syoruikengentouroku", "SearchKeyInput", "subSystemId", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHKEYINPUT_DISPROLESETUMEI = new Item("syoruikengentouroku", "SearchKeyInput", "disproleSetumei", null, ErrorMsgKbn.DISP);

    static final Item DDID_SYORUIINFO_DISPSUBSYSTEMNM = new Item("syoruikengentouroku", "syoruiInfo", "dispsubsystemnm", null, ErrorMsgKbn.DISP);

    static final Item DDID_SYORUIINFO_DISPJIMUTETUZUKINM = new Item("syoruikengentouroku", "syoruiInfo", "dispjimutetuzukinm", null, ErrorMsgKbn.DISP);

    static final Item DDID_SYORUIINFO_DISPSYORUINM = new Item("syoruikengentouroku", "syoruiInfo", "dispsyoruinm", null, ErrorMsgKbn.DISP);

    static final Item DDID_SYORUIINFO_COMMONCHECKBOX = new Item("syoruikengentouroku", "syoruiInfo", "commonCheckBox", null, ErrorMsgKbn.DISP);

    static final Item DDID_BUTTONSELECT_ALLCHECKBTN = new Item("syoruikengentouroku", "buttonSelect", "allCheckBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_BUTTONSELECT_ALLUNCHECKBTN = new Item("syoruikengentouroku", "buttonSelect", "allUnCheckBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_BUTTONSERCH_MODORUBTNBYINPUTCONTENTS = new Item("syoruikengentouroku", "buttonSerch", "modoruBtnByInputContents", null, ErrorMsgKbn.DD);

    static final Item DDID_BUTTONSERCH_MODORUBTNBYCONFIRM = new Item("syoruikengentouroku", "buttonSerch", "modoruBtnByConfirm", null, ErrorMsgKbn.DD);
}
