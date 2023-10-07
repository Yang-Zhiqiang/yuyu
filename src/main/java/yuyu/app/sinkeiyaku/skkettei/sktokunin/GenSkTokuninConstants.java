package yuyu.app.sinkeiyaku.skkettei.sktokunin;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.configuration.Item.ErrorMsgKbn;

/**
 * 特認処理 画面項目ID定義のベースクラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えてはいけません。
 */
public class GenSkTokuninConstants {

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

    static final Item DDID_HEADERBUTTONS_TOJIRUBTN = new Item("sktokunin", "headerButtons", "tojiruBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_BUTTONHUBISYOUSAI_HUBISYOUSAIBTN = new Item("sktokunin", "buttonHubisyousai", "hubisyousaibtn", null, ErrorMsgKbn.DD);

    static final Item DDID_KIHONINFO_MOSNO = new Item("sktokunin", "kihonInfo", "mosno", null, ErrorMsgKbn.DD);

    static final Item DDID_KIHONINFO_HHKNNMKJ = new Item("sktokunin", "kihonInfo", "hhknnmkj", null, ErrorMsgKbn.DISP);

    static final Item DDID_TOKUNININFO_SPGNDTKNKBN = new Item("sktokunin", "tokuninInfo", "spgndtknkbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_TOKUNININFO_NENKKNTKNKBN = new Item("sktokunin", "tokuninInfo", "nenkkntknkbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_TOKUNININFO_TSNGNDTKNKBN = new Item("sktokunin", "tokuninInfo", "tsngndtknkbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_TOKUNININFO_SENTAKUINFOTKNKBN = new Item("sktokunin", "tokuninInfo", "sentakuinfotknkbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_TOKUNININFO_SIGNALKAIHIKBN = new Item("sktokunin", "tokuninInfo", "signalkaihikbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_TOKUNININFO_KAKOYMDKYYTKNKBN = new Item("sktokunin", "tokuninInfo", "kakoymdkyytknkbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_TOKUNININFO_SAITEIPTKNKBN = new Item("sktokunin", "tokuninInfo", "saiteiptknkbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_TOKUNININFO_YOTEIRIRITUTKNKBN = new Item("sktokunin", "tokuninInfo", "yoteiriritutknkbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_TOKUNININFO_NENREIUPTKNKBN = new Item("sktokunin", "tokuninInfo", "nenreiuptknkbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_TOKUNININFO_KZMEIGITKNKBN = new Item("sktokunin", "tokuninInfo", "kzmeigitknkbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_TOKUNININFO_IKKATUYOUPTKNKBN = new Item("sktokunin", "tokuninInfo", "ikkatuyouptknkbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_TOKUNININFO_SONOTATKNKBN = new Item("sktokunin", "tokuninInfo", "sonotatknkbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_FOOTERBUTTONS_MODORUBTNBYINPUTCONTENTS = new Item("sktokunin", "footerButtons", "modoruBtnByInputContents", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS_MODORUBTNBYCONFIRM = new Item("sktokunin", "footerButtons", "modoruBtnByConfirm", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS_KAKUTEIBTN = new Item("sktokunin", "footerButtons", "kakuteiBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS_SYOKIGAMENHEBTN = new Item("sktokunin", "footerButtons", "syokigamenheBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_SEIGYOGROUP_UNIQUEID = new Item("sktokunin", "seigyoGroup", "uniqueId", null, ErrorMsgKbn.DD);
}
