package yuyu.app.sinkeiyaku.sksonota.skseirituhoryuu;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.configuration.Item.ErrorMsgKbn;

/**
 * 成立保留処理 画面項目ID定義のベースクラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えてはいけません。
 */
public class GenSkSeirituHoryuuConstants {

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

    static final Item DDID_HEADERBUTTONS_TOJIRUBTN = new Item("skseirituhoryuu", "headerButtons", "tojiruBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_BUTTONHUBISYOUSAI_HUBISYOUSAIBTN = new Item("skseirituhoryuu", "buttonHubisyousai", "hubisyousaibtn", null, ErrorMsgKbn.DD);

    static final Item DDID_KEYINFO_MOSNO = new Item("skseirituhoryuu", "keyInfo", "mosno", null, ErrorMsgKbn.DD);

    static final Item DDID_KEYINFO_HHKNNMKJ = new Item("skseirituhoryuu", "keyInfo", "hhknnmkj", null, ErrorMsgKbn.DISP);

    static final Item DDID_JIMUSRHINFO_JIMUSRHKBN = new Item("skseirituhoryuu", "jimusrhInfo", "jimusrhkbn", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS_MODORUBTNBYINPUTCONTENTS = new Item("skseirituhoryuu", "footerButtons", "modoruBtnByInputContents", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS_MODORUBTNBYCONFIRM = new Item("skseirituhoryuu", "footerButtons", "modoruBtnByConfirm", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS_KAKUTEIBTN = new Item("skseirituhoryuu", "footerButtons", "kakuteiBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS_SYOKIGAMENHEBTN = new Item("skseirituhoryuu", "footerButtons", "syokigamenheBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_SEIGYOGROUP_UNIQUEID = new Item("skseirituhoryuu", "seigyoGroup", "uniqueId", null, ErrorMsgKbn.DD);
}
