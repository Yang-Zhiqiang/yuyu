package yuyu.app.siharai.sisatei.sisyounintorikesi;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.configuration.Item.ErrorMsgKbn;

/**
 * 承認取消 画面項目ID定義のベースクラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えてはいけません。
 */
public class GenSiSyouninTorikesiConstants {

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

    static final Item DDID_HEADERBUTTONS_TOJIRUBTN = new Item("sisyounintorikesi", "headerButtons", "tojiruBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_HEADERBUTTONS_TOJIRUBTNBYPOPUP = new Item("sisyounintorikesi", "headerButtons", "tojiruBtnByPopup", null, ErrorMsgKbn.DD);

    static final Item DDID_SATEIINFO_SYONO = new Item("sisyounintorikesi", "sateiInfo", "syono", null, ErrorMsgKbn.DD);

    static final Item DDID_SATEIINFO_SKNO = new Item("sisyounintorikesi", "sateiInfo", "skno", null, ErrorMsgKbn.DD);

    static final Item DDID_SATEIINFO_TSKNM = new Item("sisyounintorikesi", "sateiInfo", "tsknm", null, ErrorMsgKbn.DD);

    static final Item DDID_SATEIINFO_SASIMODOSITSKNM = new Item("sisyounintorikesi", "sateiInfo", "sasimodositsknm", null, ErrorMsgKbn.DD);

    static final Item DDID_HHKNINFO_HHKNNMKN = new Item("sisyounintorikesi", "hhkninfo", "hhknnmkn", null, ErrorMsgKbn.DD);

    static final Item DDID_HHKNINFO_HHKNNMKJ = new Item("sisyounintorikesi", "hhkninfo", "hhknnmkj", null, ErrorMsgKbn.DD);

    static final Item DDID_COMMENTINFO_SYANAICOMMENT = new Item("sisyounintorikesi", "commentinfo", "syanaicomment", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS2_MODORUBTNBYINPUTCONTENTS = new Item("sisyounintorikesi", "footerButtons2", "modoruBtnByInputContents", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS3_MODORUBTNBYCONFIRM = new Item("sisyounintorikesi", "footerButtons3", "modoruBtnByConfirm", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS3_KAKUTEIBTN = new Item("sisyounintorikesi", "footerButtons3", "kakuteiBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS4_SYOKIGAMENHEBTN = new Item("sisyounintorikesi", "footerButtons4", "syokigamenheBtn", null, ErrorMsgKbn.DD);
}
