package yuyu.app.base.system.kinouteigitouroku;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.configuration.Item.ErrorMsgKbn;

/**
 * 機能定義登録 画面項目ID定義のベースクラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えてはいけません。
 */
public class GenKinouTeigiTourokuConstants {

    public static final int PAGENO_INIT          = 1;

    public static final int PAGENO_SELECTDATA    = 1;

    public static final int PAGENO_INPUTCONTENTS = 2;

    public static final int PAGENO_CONFIRM       = 3;

    public static final int PAGENO_RESULT        = 4;

    static final String FORWARDNAME_INIT          = "init";

    static final String FORWARDNAME_SELECTDATA    = "selectData";

    static final String FORWARDNAME_INPUTCONTENTS = "inputContents";

    static final String FORWARDNAME_CONFIRM       = "confirm";

    static final String FORWARDNAME_RESULT        = "result";

    static final Item DDID_HEADERBUTTONS_TOJIRUBTN = new Item("kinouteigitouroku", "headerButtons", "tojiruBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_KEYINFO_SUBSYSTEMID = new Item("kinouteigitouroku", "keyInfo", "subSystemId", null, ErrorMsgKbn.DISP);

    static final Item DDID_KINOUMODEINFOINPUTCONTENTS_SUBSYSTEMNM = new Item("kinouteigitouroku", "kinouModeInfoInputContents", "subSystemNm", "subSystem", ErrorMsgKbn.DISP);

    static final Item DDID_KINOUMODEINFOINPUTCONTENTS_CATEGORYNM = new Item("kinouteigitouroku", "kinouModeInfoInputContents", "categoryNm", "category", ErrorMsgKbn.DISP);

    static final Item DDID_KINOUMODEINFOINPUTCONTENTS_KINOUNM = new Item("kinouteigitouroku", "kinouModeInfoInputContents", "kinouNm", "kinou", ErrorMsgKbn.DISP);

    static final Item DDID_KINOUMODEINFOINPUTCONTENTS_KINOUMODENM = new Item("kinouteigitouroku", "kinouModeInfoInputContents", "kinouModeNm", "kinouMode", ErrorMsgKbn.DISP);

    static final Item DDID_SYSTEMSETTEIINFO_YUUKOUKBN = new Item("kinouteigitouroku", "systemSetteiInfo", "yuukouKbn", "kinouMode", ErrorMsgKbn.DD);

    static final Item DDID_SYSTEMSETTEIINFO_YUUKOUKAISIYMD = new Item("kinouteigitouroku", "systemSetteiInfo", "yuukouKaisiYmd", "kinouMode", ErrorMsgKbn.DD);

    static final Item DDID_SYSTEMSETTEIINFO_KADOUTIMEGROUPCD = new Item("kinouteigitouroku", "systemSetteiInfo", "kadouTimeGroupCd", "kinouMode", ErrorMsgKbn.DISP);

    static final Item DDID_KENGENSETTEILIST_COMMONCHECKBOX = new Item("kinouteigitouroku", "kengenSetteiList", "commonCheckBox", null, ErrorMsgKbn.DISP);

    static final Item DDID_KENGENSETTEILIST_ROLENM = new Item("kinouteigitouroku", "kengenSetteiList", "roleNm", null, ErrorMsgKbn.DD);

    static final Item DDID_KENGENSETTEILIST_ROLESETUMEI = new Item("kinouteigitouroku", "kengenSetteiList", "roleSetumei", null, ErrorMsgKbn.DISP);

    static final Item DDID_KENGENSETTEILIST_SIBORIKOMIID = new Item("kinouteigitouroku", "kengenSetteiList", "siborikomiId", null, ErrorMsgKbn.DD);

    static final Item DDID_BUTTONCHECK_ALLCHECKBTN = new Item("kinouteigitouroku", "buttonCheck", "allCheckBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_BUTTONCHECK_ALLUNCHECKBTN = new Item("kinouteigitouroku", "buttonCheck", "allUnCheckBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_HANEIKBNINFO_KOUSINNAIYOUHANEIKBN = new Item("kinouteigitouroku", "haneiKbnInfo", "kousinNaiyouHaneiKbn", null, ErrorMsgKbn.DD);

    static final Item DDID_KINOUMODEINFOLIST_SUBSYSTEMNM = new Item("kinouteigitouroku", "kinouModeInfoList", "subSystemNm", null, ErrorMsgKbn.DISP);

    static final Item DDID_KINOUMODEINFOLIST_CATEGORYNM = new Item("kinouteigitouroku", "kinouModeInfoList", "categoryNm", null, ErrorMsgKbn.DISP);

    static final Item DDID_KINOUMODEINFOLIST_KINOUNM = new Item("kinouteigitouroku", "kinouModeInfoList", "kinouNm", null, ErrorMsgKbn.DISP);

    static final Item DDID_KINOUMODEINFOLIST_KINOUMODENM = new Item("kinouteigitouroku", "kinouModeInfoList", "kinouModeNm", null, ErrorMsgKbn.DISP);

    static final Item DDID_KINOUMODEINFOLIST_HENKOULINK = new Item("kinouteigitouroku", "kinouModeInfoList", "henkouLink", null, ErrorMsgKbn.DD);

    static final Item DDID_BUTTONINPUTCONTENTS_MODORUBTNBYINPUTCONTENTS = new Item("kinouteigitouroku", "buttonInputContents", "modoruBtnByInputContents", null, ErrorMsgKbn.DD);

    static final Item DDID_BUTTONINPUTCONTENTS_MODORUBTNBYCONFIRM = new Item("kinouteigitouroku", "buttonInputContents", "modoruBtnByConfirm", null, ErrorMsgKbn.DD);
}
