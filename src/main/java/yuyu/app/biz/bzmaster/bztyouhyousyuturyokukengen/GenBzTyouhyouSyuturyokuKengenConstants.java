package yuyu.app.biz.bzmaster.bztyouhyousyuturyokukengen;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.configuration.Item.ErrorMsgKbn;

/**
 * 帳票出力権限登録 画面項目ID定義のベースクラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えてはいけません。
 */
public class GenBzTyouhyouSyuturyokuKengenConstants {

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

    static final Item DDID_HEADERBUTTONS_TOJIRUBTN = new Item("bztyouhyousyuturyokukengen", "headerButtons", "tojiruBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_KEYINFO_ROLECD = new Item("bztyouhyousyuturyokukengen", "keyInfo", "roleCd", null, ErrorMsgKbn.DD);

    static final Item DDID_KEYINFO_ROLENM = new Item("bztyouhyousyuturyokukengen", "keyInfo", "roleNm", null, ErrorMsgKbn.DD);

    static final Item DDID_KEYINFO_SUBSYSTEMID = new Item("bztyouhyousyuturyokukengen", "keyInfo", "subSystemId", null, ErrorMsgKbn.DISP);

    static final Item DDID_TYOUHYOULIST_DISPSUBSYSTEMNM = new Item("bztyouhyousyuturyokukengen", "tyouhyouList", "dispsubsystemnm", null, ErrorMsgKbn.DISP);

    static final Item DDID_TYOUHYOULIST_DISPSYORUINM = new Item("bztyouhyousyuturyokukengen", "tyouhyouList", "dispsyoruinm", null, ErrorMsgKbn.DISP);

    static final Item DDID_TYOUHYOULIST_DISPIKKATUOUTPUTCHKBOX = new Item("bztyouhyousyuturyokukengen", "tyouhyouList", "dispikkatuoutputchkbox", null, ErrorMsgKbn.DISP);

    static final Item DDID_TYOUHYOULIST_DISPKOBETUOUTPUTCHKBOX = new Item("bztyouhyousyuturyokukengen", "tyouhyouList", "dispkobetuoutputchkbox", null, ErrorMsgKbn.DISP);

    static final Item DDID_CHECKBUTTONS_ALLCHECKBTN = new Item("bztyouhyousyuturyokukengen", "checkButtons", "allCheckBtn", null, ErrorMsgKbn.DISP);

    static final Item DDID_CHECKBUTTONS_ALLUNCHECKBTN = new Item("bztyouhyousyuturyokukengen", "checkButtons", "allUnCheckBtn", null, ErrorMsgKbn.DISP);

    static final Item DDID_FOOTERBUTTONS_MODORUBTNBYINPUTCONTENTS = new Item("bztyouhyousyuturyokukengen", "footerButtons", "modoruBtnByInputContents", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS_MODORUBTNBYCONFIRM = new Item("bztyouhyousyuturyokukengen", "footerButtons", "modoruBtnByConfirm", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS_KAKUTEIBTN = new Item("bztyouhyousyuturyokukengen", "footerButtons", "kakuteiBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS_SYOKIGAMENHEBTN = new Item("bztyouhyousyuturyokukengen", "footerButtons", "syokigamenheBtn", null, ErrorMsgKbn.DD);
}
